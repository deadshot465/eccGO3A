using System.Collections;

namespace CSharp
{
    public struct Golem
    {
        public int Hp;
        public int Defense;
        public int Attack;

        public Golem(int hp = 300, int defense = 80, int attack = 50)
        {
            Hp = hp;
            Defense = defense;
            Attack = attack;
        }
    }

    public struct GolemEx
    {
        private const int HIT = 75;
        private const int FLEE = 20;
        public int Hp;
        public int Defense;
        public int Attack;
        public int Hit;
        public int Flee;

        public GolemEx(int hp, int defense, int attack, int hit = HIT, int flee = FLEE)
        {
            Hp = hp;
            Defense = defense;
            Attack = attack;
            Hit = hit;
            Flee = flee;
        }
    }

    public struct PlayerEx
    {
        public const int INITIAL_HP = 500;
        private const int DEFENSE = 30;
        public int Hp;
        public int Defense;

        public PlayerEx(int hp = INITIAL_HP, int defense = DEFENSE)
        {
            Hp = hp;
            Defense = defense;
        }
    }
}
