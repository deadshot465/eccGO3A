const int GOLEM_HIT = 70;
const int GOLEM_FLEE = 20;

class Golem {
  int Hp;
  int Defense;
  int Attack;

  Golem({int hp = 300, int defense = 80, int attack = 50}) {
    this.Hp = hp;
    this.Defense = defense;
    this.Attack = attack;
  }
}

class GolemEx {
  int Hp;
  int Defense;
  int Attack;
  int Hit;
  int Flee;

  GolemEx(int hp, int defense, int attack) {
    this.Hp = hp;
    this.Defense = defense;
    this.Attack = attack;
    this.Hit = GOLEM_HIT;
    this.Flee = GOLEM_FLEE;
  }
}