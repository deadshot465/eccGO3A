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