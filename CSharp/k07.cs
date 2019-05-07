using System;

namespace CSharp
{
    class K07 : IExecutable
    {

        public override void Question01()
        {
            int choice = 0;
            do
            {
                try
                {
                    Console.Write("メッセージを表示しますか？（０：終了する　１：表示する）＞");
                    choice = int.Parse(Console.ReadLine());
                    if (choice == 1)
                    {
                        ShowTexts();
                    }
                }
                catch (Exception ex)
                {
                    Console.Error.WriteLine(ex.Message);
                }
                

            } while (choice != 0);
        }

        public override void Question02()
        {
            try
            {
                int[] numbers = new int[3];
                for (int i = 0; i < 3; i++)
                {
                    Console.Write(string.Format("{0}つ目の値を入力してください。＞", i + 1));
                    numbers[i] = int.Parse(Console.ReadLine());
                }

                Console.WriteLine(string.Format("{0}つの中で最大値は{1}です。",
                    numbers.Length, GetMaxValue(numbers[0], numbers[1], numbers[2])));
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.Message);
            }
        }

        public override void Question03()
        {
            try
            {
                int age = 0;
                int no = 0;
                Console.Write("年齢を入力して下さい。＞");
                age = int.Parse(Console.ReadLine());

                no = this.GetType(age);
                switch (no)
                {
                    case 0:
                        Console.WriteLine("不適切な値が入力されました。");
                        break;
                    case 1:
                        Console.WriteLine("入場料金無料です。");
                        break;
                    case 2:
                        Console.WriteLine("子供料金で半額です。");
                        break;
                    case 3:
                        Console.WriteLine("シニア割引で１割引きです。");
                        break;
                    default:
                        Console.WriteLine("通常料金です。");
                        break;
                }
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.Message);
            }
        }

        public override void Question04()
        {
            return;
        }

        private void ShowTexts()
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine("ようこそ");
            Console.WriteLine("C#言語の世界へ！");
        }

        private int GetMaxValue(int value1, int value2, int value3)
        {
            int temp = value1 >= value2 ? value1 : value2;
            temp = temp >= value3 ? temp : value3;
            return temp;
        }

        private int GetType(int age)
        {
            if (age <= 0)
                return 0;
            else if (age < 3 || age >= 70)
                return 1;
            else if (age >= 3 && age <= 15)
                return 2;
            else if (age >= 60 && age < 70)
                return 3;
            else
                return 4;
        }
    }
}
