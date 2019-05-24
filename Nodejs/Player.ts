export class PlayerEx {
    private INITIAL_HP = 500;
    private DEFENSE = 30;
    hp: number;
    defense: number;

    constructor() {
        this.hp = this.INITIAL_HP;
        this.defense = this.DEFENSE;
    }
}