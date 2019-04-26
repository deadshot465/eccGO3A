using System;

namespace CSharp
{
    public class K04_4 : IExecutable
    {
        public void Execute()
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

            return;
        }
    }
}
