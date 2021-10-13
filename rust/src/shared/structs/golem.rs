#[derive(Copy, Clone, Debug)]
pub struct Golem {
    pub hp: i32,
    pub defense: i32,
    pub attack: i32,
}

impl Golem {
    pub fn new(hp: i32) -> Self {
        Golem {
            hp,
            defense: 80,
            attack: 50,
        }
    }
}

impl Default for Golem {
    fn default() -> Self {
        Golem::new(300)
    }
}

pub struct GolemEx {
    pub hp: i32,
    pub defense: i32,
    pub attack: i32,
    pub hit: i32,
    pub flee: i32,
}
impl GolemEx {
    const GOLEM_HIT: i32 = 70;
    const GOLEM_FLEE: i32 = 20;

    pub fn new(hp: i32, defense: i32, attack: i32) -> Self {
        GolemEx {
            hp,
            defense,
            attack,
            hit: GolemEx::GOLEM_HIT,
            flee: GolemEx::GOLEM_FLEE,
        }
    }
}
