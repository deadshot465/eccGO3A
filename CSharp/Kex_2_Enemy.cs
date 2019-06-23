using System;

namespace CSharp
{
    public static class Kex_2_Enemy
    {
        public static readonly int MAX_GOLEM_LEVEL = 5;
        public static readonly int MAX_GOBLIN_LEVEL = 7;
        public static readonly int MAX_SLIME_LEVEL = 9;
        public static readonly int GOLEM_HIT = 75;
        public static readonly int GOLEM_FLEE = 20;
        public static readonly int GOBLIN_HIT = 85;
        public static readonly int GOBLIN_FLEE = 40;
        public static readonly int SLIME_HIT = 95;
        public static readonly int SLIME_FLEE = 30;

        public static Enemy CreateEnemy(EnemyType type)
        {
            Enemy enemy = new Enemy();
            Random random = new Random();

            switch (type)
            {
                case EnemyType.TYPE_GOLEM:
                    {
                        int lv = random.Next(0, MAX_GOLEM_LEVEL);
                        enemy = new Enemy(
                        lv,
                        lv * 50 + 100,
                        lv * 10 + 40,
                        lv * 10 + 40,
                        GOLEM_HIT,
                        GOLEM_FLEE,
                        type,
                        "ゴーレム"
                        );
                        break;
                    }
                case EnemyType.TYPE_GOBLIN:
                    {
                        int lv = random.Next(0, MAX_GOBLIN_LEVEL);
                        enemy = new Enemy(
                        lv,
                        lv * 30 + 75,
                        lv * 5 + 20,
                        lv * 5 + 20,
                        GOBLIN_HIT,
                        GOBLIN_FLEE,
                        type,
                        "ゴブリン"
                        );
                        break;
                    } 
                case EnemyType.TYPE_SLIME:
                    {
                        int lv = random.Next(0, MAX_SLIME_LEVEL);
                        enemy = new Enemy(
                        lv,
                        lv * 10 + 50,
                        lv * 2 + 10,
                        lv * 2 + 10,
                        SLIME_HIT,
                        SLIME_FLEE,
                        type,
                        "スライム"
                        );
                        break;
                    }
                default:
                    break;
            }

            return enemy;
        }
    }
}
