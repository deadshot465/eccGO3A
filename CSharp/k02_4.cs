using System;

namespace CSharp
{
    public class K02_4 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Golem golem = new Golem()
                {
                    hp = 300,
                    defense = 80
                };

                Console.WriteLine(string.Format("ゴーレム　（HP:{0}　防御力：{1})\n", golem.hp, golem.defense));
                Console.WriteLine("HP：" + golem.hp);
                Console.Write("今回の攻撃の値を入力してください＞");
                int atk = int.Parse(Console.ReadLine());
                atk = atk - golem.defense > 0 ? atk - golem.defense : 0;
                Console.WriteLine("ダメージは" + atk + "です");
                golem.hp -= atk;
                Console.WriteLine("残りのHPは" + golem.hp + "です");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
