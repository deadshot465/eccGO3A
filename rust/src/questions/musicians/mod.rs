use rand::prelude::*;
use std::collections::HashMap;
use std::sync::mpsc::{Receiver, Sender};
use std::thread::JoinHandle;

#[derive(Debug, Copy, Clone)]
enum SkillLevel {
    Good,
    Bad,
}

#[derive(Debug)]
struct Musician {
    pub name: String,
    pub role: String,
    pub skill: SkillLevel,
    pub receiver: Receiver<()>,
}

#[derive(Debug)]
struct BandSupervisor {
    pub handles: Vec<JoinHandle<()>>,
    pub max_retries: i32,
    pub retry_duration: i32,
}

const DELAY: u64 = 750;

const FIRST_NAMES: [&str; 13] = [
    "Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
    "Janet", "Leo", "Yuhei", "Carson",
];

const LAST_NAMES: [&str; 13] = [
    "Frizzle",
    "Perlstein",
    "Ramon",
    "Ann",
    "Franklin",
    "Terese",
    "Tennelli",
    "Jamal",
    "Li",
    "Perlstein",
    "Fujioka",
    "Ito",
    "Hage",
];

pub fn start_band(mut max_retries: i32) {
    let (sender, receiver) = std::sync::mpsc::channel::<(String, SkillLevel)>();
    let mut senders = HashMap::new();
    senders.insert(
        "singer".to_string(),
        add_band_member("singer", SkillLevel::Good, sender.clone()),
    );
    senders.insert(
        "bass".to_string(),
        add_band_member("bass", SkillLevel::Good, sender.clone()),
    );
    senders.insert(
        "drum".to_string(),
        add_band_member("drum", SkillLevel::Bad, sender.clone()),
    );
    senders.insert(
        "guitar".to_string(),
        add_band_member("guitar", SkillLevel::Good, sender.clone()),
    );

    while let Ok((role, skill)) = receiver.recv() {
        max_retries -= 1;
        senders.remove(&role);
        if max_retries <= 0 {
            println!("The manager is mad and fired the whole band!");
            for sender in senders.values() {
                sender.send(());
            }
            std::thread::sleep(std::time::Duration::from_secs(3));
            break;
        }
        senders.insert(role.clone(), add_band_member(&role, skill, sender.clone()));
    }
}

fn add_band_member(
    role: &str,
    skill: SkillLevel,
    sender: Sender<(String, SkillLevel)>,
) -> Sender<()> {
    let role = role.to_string();
    let role_clone = role.clone();
    let (fire_sender, fire_receiver) = std::sync::mpsc::channel::<()>();
    std::thread::spawn(move || {
        let role = role_clone;
        let musician = Musician::new(&role, skill, fire_receiver);
        loop {
            std::thread::sleep(std::time::Duration::from_millis(DELAY));
            let play_result = musician.play_sound();
            if !play_result {
                if let Err(e) = sender.send((role, skill)) {
                    eprintln!(
                        "Failed to inform the supervisor that the member sucks: {}",
                        e
                    );
                }
                break;
            }
        }
    });
    fire_sender
}

fn pick_name() -> String {
    let mut rng = rand::thread_rng();
    let first_name = FIRST_NAMES.choose(&mut rng).copied().unwrap_or_default();
    let last_name = LAST_NAMES.choose(&mut rng).copied().unwrap_or_default();
    format!("{} {}", first_name, last_name)
}

impl Musician {
    pub fn new(role: &str, skill: SkillLevel, receiver: Receiver<()>) -> Self {
        let name = pick_name();
        println!("Musician {}, playing the {} entered the room.", &name, role);

        Musician {
            name,
            role: role.to_string(),
            skill,
            receiver,
        }
    }

    pub fn play_sound(&self) -> bool {
        if let Ok(_) = self.receiver.try_recv() {
            println!("{} just got back to playing in the subway.", &self.name);
            return false;
        }

        match self.skill {
            SkillLevel::Good => {
                println!("{} produced sound!", &self.name);
                true
            }
            SkillLevel::Bad => {
                let mut rng = rand::thread_rng();
                let failed = rng.gen_range(0..5) == 0;
                if failed {
                    println!("{} played a false note. Uh oh.", &self.name);
                    println!(
                        "{} sucks! kicked that member out of the band! ({})",
                        &self.name, &self.role
                    );
                } else {
                    println!("{} produced sound!", &self.name);
                }
                !failed
            }
        }
    }
}
