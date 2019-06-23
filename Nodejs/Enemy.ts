export class Enemy {
    Lv: number;
    Hp: number;
    Defense: number;
    Attack: number;
    Hit: number;
    Flee: number;
    Name: string;

    constructor(lv: number, hp: number, defense: number,
        attack: number, hit: number, flee: number, name: string) {
        this.Lv = lv;
        this.Hp = hp;
        this.Defense = defense;
        this.Attack = attack;
        this.Hit = hit;
        this.Flee = flee;
        this.Name = name;
    }
}