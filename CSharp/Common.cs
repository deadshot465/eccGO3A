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

    public enum EnemyType
    {
        TYPE_GOLEM = 0,
        TYPE_GOBLIN = 1,
        TYPE_SLIME = 2
    }

    public struct Enemy
    {
        public readonly int Lv;
        public int Hp;
        public readonly int Defense;
        public readonly int Attack;
        public readonly int Hit;
        public readonly int Flee;
        public readonly EnemyType Type;
        public readonly string Name;

        public Enemy(int lv, int hp, int defense, int attack,
            int hit, int flee, EnemyType type, string name)
        {
            Lv = lv;
            Hp = hp;
            Defense = defense;
            Attack = attack;
            Hit = hit;
            Flee = flee;
            Type = type;
            Name = name;
        }
    }

    public struct Attack
    {
        public readonly int Damage;
        public readonly int Hit;

        public Attack(int damage, int hit)
        {
            Damage = damage;
            Hit = hit;
        }
    }
}
