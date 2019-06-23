class Enemy {
  int Lv;
  int Hp;
  int Defense;
  int Attack;
  int Hit;
  int Flee;
  String Name;

  Enemy({int lv = 0, int hp = 0, int defense = 0, int attack = 0, int hit = 0, int flee = 0, String name = ''}) {
    Lv = lv;
    Hp = hp;
    Defense = defense;
    Attack = attack;
    Hit = hit;
    Flee = flee;
    Name = name;
  }
}