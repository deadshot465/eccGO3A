using System;

namespace CSharp
{
    public class K06_3 : IExecutable
    {
        public void Execute()
        {
            int total = 370;
            int count = 0;

            for (int i = 0; i <= total / 100; i++)
            {
                for (int j = 0; j <= total / 50; j++)
                {
                    for (int k = 0; k <= total / 10; k++)
                    {
                        if (100 * i + 50 * j + 10 * k == total)
                        {
                            Console.WriteLine(string
                                .Format("10円の硬貨{0}枚 50円の硬貨{1}枚 100円の硬貨{2}枚", k, j, i));
                            count++;
                        }
                    }
                }
            }

            Console.WriteLine("\n以上" + count + "通りを発見しました。");
        }
    }
}
