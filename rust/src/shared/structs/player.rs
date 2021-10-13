pub struct Player {
    pub hp: i32,
    pub defense: i32,
}

impl Player {
    const PLAYER_HP: i32 = 500;
    const PLAYER_DEFENSE: i32 = 30;

    pub fn new() -> Self {
        Player {
            hp: Player::PLAYER_HP,
            defense: Player::PLAYER_DEFENSE,
        }
    }
}
