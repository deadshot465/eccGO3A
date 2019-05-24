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

class GolemEx {
    private final int GOLEM_HIT = 70;
    private final int GOLEM_FLEE = 20;
    public int Hp;
    public int Defense;
    public int Attack;
    public int Hit;
    public int Flee;

    GolemEx(int hp, int defense, int attack) {
        this.Hp = hp;
        this.Defense = defense;
        this.Attack = attack;
        this.Hit = GOLEM_HIT;
        this.Flee = GOLEM_FLEE;
    }
}