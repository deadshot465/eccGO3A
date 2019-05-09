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
}
