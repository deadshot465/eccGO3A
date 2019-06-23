pub struct Enemy {
    pub lv: i32,
    pub hp: i32,
    pub defense: i32,
    pub attack: i32,
    pub hit: i32,
    pub flee: i32,
    pub name: String
}

impl Enemy {
    pub fn new() -> Enemy {
        let enemy = Enemy {
            lv: 0,
            hp: 0,
            defense: 0,
            attack: 0,
            hit: 0,
            flee: 0,
            name: String::new()
        };

        enemy
    }
}