pub struct Attack {
    pub damage: i32,
    pub hit: i32
}

impl Attack {
    pub fn new() -> Attack {
        let attack = Attack {
            damage: 0,
            hit: 0
        };
        attack
    }
}