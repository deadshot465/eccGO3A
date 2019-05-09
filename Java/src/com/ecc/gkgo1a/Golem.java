package com.ecc.gkgo1a;

class Golem {
    int hp = 300;
    int defense = 80;
    int attack = 50;

    Golem() {}

    Golem(int hp)
    {
        this.hp = hp;
    }

    Golem(int hp, int defense)
    {
        this.hp = hp;
        this.defense = defense;
    }

    Golem(int hp, int defense, int attack) {
        this.hp = hp;
        this.defense = defense;
        this.attack = attack;
    }
}