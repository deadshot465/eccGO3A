using System;

namespace CSharp
{
    public class K04_2 : IExecutable
    {
        public void Execute()
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

            return;
        }
    }
}
