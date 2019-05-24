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

pub struct GolemEx {
    pub hp: i32,
    pub defense: i32,
    pub attack: i32,
    pub hit: i32,
    pub flee: i32
}
impl GolemEx {
    const GOLEM_HIT: i32 = 70;
    const GOLEM_FLEE: i32 = 20;
    pub fn new(hp: i32, defense: i32, attack: i32) -> GolemEx {
        let mut golem = GolemEx {
            hp,
            defense,
            attack,
            hit: GolemEx::GOLEM_HIT,
            flee: GolemEx::GOLEM_FLEE
        };
        golem
    }
}