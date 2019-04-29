using System;

namespace CSharp
{
    class K04 : IExecutable
    {
        public override void Question01()
        {
            try
            {
                Console.Write("年齢を入力してください。＞");
                int age = int.Parse(Console.ReadLine());

                if (age < 3 || age >= 70)
                {
                    Console.WriteLine("入場料金無料です。");
                }
                else
                {
                    Console.WriteLine("通常料金です。");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        public override void Question02()
        {
            try
            {
                Console.Write("性別を選択してください。（０：男性　１：女性）＞");
                int gender = int.Parse(Console.ReadLine());

                switch (gender)
                {
                    case 0:
                        Console.WriteLine("あら、格好良いですね。");
                        break;
                    case 1:
                        Console.WriteLine("あら、モデルさんみたいですね。");
                        break;
                    default:
                        Console.WriteLine("そんな選択肢はありません。");
                        break;
                }
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
                Console.Write("年齢を入力してください。＞");
                int age = int.Parse(Console.ReadLine());

                if (age < 3 || age >= 70)
                {
                    Console.WriteLine("入場料金無料です。");
                }
                else if (age >= 3 && age <= 15)
                {
                    Console.WriteLine("子供料金で半額です。");
                }
                else if (age >= 60 && age < 70)
                {
                    Console.WriteLine("シニア割引で一割引きです。");
                }
                else
                {
                    Console.WriteLine("通常料金です。");
                }
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
                Console.WriteLine("＊＊＊おみくじプログラム＊＊＊");
                Console.Write("おみくじを引きますか　（はい：１　いいえ：０）　＞");
                int choice = int.Parse(Console.ReadLine());

                if (choice >= 1)
                {
                    Random randomNumber = new Random();
                    int oracle = randomNumber.Next(0, 4);
                    switch (oracle)
                    {
                        case 0:
                            Console.WriteLine("大吉　とってもいいことがありそう！！");
                            break;
                        case 1:
                            Console.WriteLine("中吉　きっといいことあるんじゃないかな");
                            break;
                        case 2:
                            Console.WriteLine("小吉　少しぐらいはいいことあるかもね");
                            break;
                        case 3:
                            Console.WriteLine("凶　今日はおとなしくておいた方がいいかも");
                            break;
                        case 4:
                            Console.WriteLine("大凶　これじゃやばくない？早く家に帰った方がいいかも");
                            break;
                        default:
                            break;
                    }
                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
