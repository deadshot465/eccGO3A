export class Golem {
    hp: number;
    defense: number;
    attack: number;

    constructor(hp: number = 300, defense: number = 80, attack: number = 50) {
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
    }
}

export class GolemEx {
    private HIT = 70;
    private FLEE = 20;

    hp: number;
    defense: number;
    attack: number;
    hit: number;
    flee: number;

    constructor(hp: number, defense: number, attack: number) {

        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.hit = this.HIT;
        this.flee = this.FLEE;

    }
}