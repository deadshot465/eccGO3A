using System;

namespace CSharp
{
    public class K02 : IExecutable
    {
        public override void Question01()
        {
            int seisuu = 3;
            float jissuu = 2.6f;
            char moji = 'A';

            Console.WriteLine("変数seisuuの値は" + seisuu);
            Console.WriteLine("変数jissuuの値は" + jissuu);
            Console.WriteLine("変数mojiの値は" + moji);
        }

        public override void Question02()
        {
            try
            {
                Console.Write("一つ目の整数は？");
                int a = int.Parse(Console.ReadLine());
                Console.Write("二つ目の整数は？");
                int b = int.Parse(Console.ReadLine());

                Console.WriteLine(string.Format("{0}÷{1}={2}...{3}", a, b, a / b, a % b));

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        public override void Question03()
        {
            try
            {
                Console.Write("一つ目の商品の値段は？");
                int priceA = int.Parse(Console.ReadLine());
                Console.Write("個数は？");
                int amountA = int.Parse(Console.ReadLine());
                Console.Write("二つ目の商品の値段は？");
                int priceB = int.Parse(Console.ReadLine());
                Console.Write("個数は？");
                int amountB = int.Parse(Console.ReadLine());

                Console.WriteLine(string.Format("お支払いは税込み￥{0}です", (int)((priceA * amountA + priceB * amountB) * 1.08f)));

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        public override void Question04()
        {
            try
            {
                Golem golem = new Golem();

                Console.WriteLine(string.Format("ゴーレム　（HP:{0}　防御力：{1}）\n", golem.Hp, golem.Defense));
                Console.WriteLine("HP：" + golem.Hp);
                Console.Write("今回の攻撃の値を入力してください＞");
                int atk = int.Parse(Console.ReadLine());
                atk = atk - golem.Defense > 0 ? atk - golem.Defense : 0;
                Console.WriteLine("ダメージは" + atk + "です");
                golem.Hp -= atk;
                Console.WriteLine("残りのHPは" + golem.Hp + "です");

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
