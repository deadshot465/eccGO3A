use crate::player::Player;
use crate::read_user_input::read_user_input;
use std::io::Write;
use rand::Rng;
use crate::kex_2_enemy::{create_enemy, EnemyType};
use crate::kex_2_battle::attack_enemy;

pub struct Kex_2 {}
impl Kex_2 {
    pub fn execute() {
        println!("冒険が今始まる！");
        let mut player = Player::new();
        let mut continue_game = 1;
        let mut kills = 0;

        while continue_game != 0 {
            println!("現HP：{}", player.hp);
            print!("奥に進みますか？（１：奥に進む　０．帰る）＞");
            std::io::stdout().flush().unwrap();
            let mut reader = String::new();
            continue_game = match read_user_input(&mut reader) {
                Ok(x) => x,
                Err(ex) => {
                    eprintln!("エラーが発生しました：{}", ex.to_string());
                    return;
                }
            };
            if continue_game == 1 {
                let lv = rand::thread_rng().gen_range(0, 3);
                let mut enemy = create_enemy(EnemyType::from(lv));
                let result = attack_enemy(&mut player, &mut enemy);
                kills += 1;
                if !result {
                    break;
                }
            }
        }
        println!("リ〇ミト！\n");
        println!("戦闘回数：{}回　残りHP：{}", kills, player.hp);
    }
}