using System;
using System.Linq;

namespace CSharp
{
    class K12 : IExecutable
    {
        internal struct Person
        {
            internal string Name;
            internal int BirthYear;
            internal float Height;
            internal float Weight;
        }

        internal struct Staff
        {
            internal string Name;
            internal char Gender;
            internal int Age;

            internal Staff(string name, char gender, int age)
            {
                Name = name;
                Gender = gender;
                Age = age;
            }
        }

        internal struct Position : IComparable<Position>
        {
            internal int X;
            internal int Y;
            internal double Distance;

            internal Position(int x, int y, double distance = 0.0)
            {
                X = x;
                Y = y;
                Distance = distance;
            }


            public int CompareTo(Position other)
            {
                return Distance.CompareTo(other.Distance);
            }
        }

        public override void Question01()
        {
            Person person = new Person();
            Console.Write("名前を入力してください＞");
            person.Name = Console.ReadLine();
            Console.Write("生年（西暦）を入力してください＞");
            person.BirthYear = int.Parse(Console.ReadLine());
            Console.Write("身長を入力してください＞");
            person.Height = float.Parse(Console.ReadLine());
            Console.Write("体重を入力してください＞");
            person.Weight = float.Parse(Console.ReadLine());

            Console.WriteLine("プロファイル：");
            Console.WriteLine($"名前：{person.Name}");
            Console.WriteLine($"生年：{person.BirthYear}");
            Console.WriteLine($"身長：{person.Height}");
            Console.WriteLine($"体重：{person.Weight}");
        }

        public override void Question02()
        {
            Staff[] staffs =
            {
                new Staff("神木隆之介", 'M', 23),
                new Staff("上白石萌音", 'F', 18),
                new Staff("長澤まさみ", 'F', 28)
            };

            Console.WriteLine("名前\t\t性別\t年齢");
            for (int i = 0; i <= 35; ++i)
            {
                Console.Write('-');
            }
            Console.WriteLine();

            foreach (var staff in staffs)
            {
                Console.WriteLine($"{staff.Name}\t{staff.Gender}\t{staff.Age}歳");
            }

        }

        public override void Question03()
        {
            Random random = new Random();
            Func<int> getRandomNumber = () => random.Next(0, 101) - 50;
            Position playerPos = new Position(getRandomNumber(), getRandomNumber());
            Position[] enemyPos = new Position[5];
            for (int i = 0; i < enemyPos.Length; i++)
            {
                enemyPos[i].X = getRandomNumber();
                enemyPos[i].Y = getRandomNumber();
                enemyPos[i].Distance = GetDistance(playerPos, enemyPos[i]);
            }

            Console.WriteLine($"プレーヤーの座標：x= {playerPos.X}\t\ty= {playerPos.Y}\n");
            for (int i = 0; i < enemyPos.Length; i++)
            {
                var pos = enemyPos[i];
                var str = $"敵キャラの座標0{i}：x= {pos.X,5:F2}\t\ty= {pos.Y,5:F2}\t\t距離={Math.Round(pos.Distance, 2)}";
                Console.WriteLine(str);
            }

        }

        public override void Question04()
        {
            Random random = new Random();
            Func<int> getRandomNumber = () => random.Next(0, 101) - 50;
            Position playerPos = new Position(getRandomNumber(), getRandomNumber());
            Position[] enemyPos = new Position[5];
            for (int i = 0; i < enemyPos.Length; i++)
            {
                enemyPos[i].X = getRandomNumber();
                enemyPos[i].Y = getRandomNumber();
                enemyPos[i].Distance = GetDistance(playerPos, enemyPos[i]);
            }

            Console.WriteLine($"プレーヤーの座標：x= {playerPos.X}\t\ty= {playerPos.Y}\n");
            for (int i = 0; i < enemyPos.Length; i++)
            {
                var pos = enemyPos[i];
                Console.WriteLine($"敵キャラの座標0%d：x= {pos.X, 5:F2}\t\ty= {pos.Y, 5:F2}\t\t距離={Math.Round(pos.Distance, 2)}");
            }

            Console.WriteLine("\n並び替え後");
            var enemyList = enemyPos.ToList();
            enemyList.Sort();
            for (int i = 0; i < enemyList.Count; i++)
            {
                var pos = enemyList[i];
                Console.WriteLine($"敵キャラの座標0%d：x= {pos.X, 5:F2}\t\ty= {pos.Y, 5:F2}\t\t距離={Math.Round(pos.Distance, 2)}");
            }
        }

        private double GetDistance(Position playerPos, Position enemyPos)
        {
            int diffX = playerPos.X - enemyPos.X;
            int diffY = playerPos.Y - enemyPos.Y;
            return Math.Sqrt(diffX * diffX + diffY * diffY);
        }
    }
}
