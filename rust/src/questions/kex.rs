use crate::kex_1sub::attack_golem;
use crate::player::Player;
use crate::read_user_input::read_user_input;
use std::io::Write;
use rand::Rng;

pub struct Kex {}
impl Kex {
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
                Err(e) => {
                    eprintln!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            };
            if continue_game == 1 {
                let golem_lv = rand::thread_rng().gen_range(0, 5);
                attack_golem(golem_lv, &mut player);
                kills += 1;
                if player.hp == 0 {
                    break;
                }
            }
        }
        println!("リ〇ミト！\n");
        println!("戦闘回数：{}　残りHP：{}", kills, player.hp);
    }
}