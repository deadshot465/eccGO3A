pub struct Golem
{
    pub hp: i32,
    pub defense: i32,
    pub attack: i32
}

impl Golem {
    pub fn new(hp: i32) -> Golem {
        let mut _golem = Golem::default();
        _golem.hp = hp;
        _golem
    }
}

impl Default for Golem {
    fn default() -> Self {
        Golem {
            hp: 300,
            defense: 80,
            attack: 50
        }
    }
}