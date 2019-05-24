"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Golem {
    constructor(hp = 300, defense = 80, attack = 50) {
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
    }
}
exports.Golem = Golem;
class GolemEx {
    constructor(hp, defense, attack) {
        this.HIT = 70;
        this.FLEE = 20;
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
        this.hit = this.HIT;
        this.flee = this.FLEE;
    }
}
exports.GolemEx = GolemEx;
//# sourceMappingURL=Golem.js.map