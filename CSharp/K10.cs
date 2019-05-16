using System;
using System.Linq;

namespace CSharp
{
    public class K10 : IExecutable
    {
        public override void Question01()
        {
            Console.Write("文字列の入力＞");
            var inputString = Console.ReadLine();
            Console.WriteLine($"入力された文字列の文字数：{inputString.Length}");
        }

        public override void Question02()
        {
            string str = "STRINGcopy";
            Console.WriteLine($"コピーしたい文字列：{str}");
            string copyStr = str;
            Console.WriteLine($"コピー後の文字列：{copyStr}");
        }

        public override void Question03()
        {
            string[] str =
            {
                "abcdef", "GHIJKL", "13579"
            };

            string strCombined = "";

            Console.WriteLine("連結したい３つの文字列：");
            foreach (var s in str)
            {
                Console.WriteLine(s);
                strCombined += s;
            }

            Console.WriteLine($"連結した文字列：\n{strCombined}");
        }

        public override void Question04()
        {
            string alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            string inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.";

            int count = 0;
            int _count = 0;
            Console.WriteLine($"文字列：{inputString}\n");
            Console.WriteLine("文字頻度");
            alphabets.ToList().ForEach((x) => {
                inputString.ToList().ForEach((y) =>
                {
                    if (x == y)
                    {
                        count++;
                    }
                });
                Console.Write($"{x}: {count}\t");
                count = 0;
                _count++;

                if (_count % 4 == 0)
                {
                    Console.WriteLine();
                }
            });
        }
    }
}