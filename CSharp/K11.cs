using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace CSharp
{
    class K11 : IExecutable
    {
        private const int MaxPeople = 5;

        public override void Question01()
        {
            try
            {
                List<int> ages = new List<int>();

                for (int i = 0; i < MaxPeople; i++)
                {
                    Console.Write((i + 1) + "人目の年齢を入力して下さい：");
                    ages.Add(int.Parse(Console.ReadLine()));
                }

                Console.WriteLine($"{ages.Count}人の平均年齢は{ages.Average()}です。");
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e.Message);
            }
        }

        public override void Question02()
        {
            try
            {
                Console.Write("1つ目の文字列を入力して下さい。＞");
                string str1 = Console.ReadLine();
                Console.Write("2つ目の文字列を入力して下さい。＞");
                string str2 = Console.ReadLine();
                str1 += str2;
                Console.WriteLine($"{str1}の文字数は{str1.Length}です。");
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        public override void Question03()
        {
            try
            {
                char chr;
                Console.Write("文字を入力して下さい。＞");
                chr = char.Parse(Console.ReadLine());
                bool applied = false;

                if (char.IsDigit(chr))
                {
                    Console.WriteLine("この文字は数字です。");
                    applied = true;
                }

                if (char.IsUpper(chr))
                {
                    Console.WriteLine("この文字は英大文字です。");
                    applied = true;
                }

                if (char.IsLower(chr))
                {
                    Console.WriteLine("この文字は英小文字です。");
                    applied = true;
                }

                Regex rx = new Regex("^[A-Fa-f0-9]{6}$");

                if (rx.IsMatch(chr.ToString()))
                {
                    Console.WriteLine("この文字は16進数として使える文字です。");
                    applied = true;
                }

                if (char.IsPunctuation(chr))
                {
                    Console.WriteLine("この文字は区切り文字です。");
                    applied = true;
                }

                if (!applied)
                {
                    Console.WriteLine("この文字はよくわからない文字です。");
                }

            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        public override void Question04()
        {
            string alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            string inputString = "I am a STUDENT. I am good at GAME PROGRAMMING.";

            int count = 0;
            int _count = 0;
            Console.WriteLine($"文字列：{inputString}\n");
            Console.WriteLine("文字頻度");
            alphabets.ToList().ForEach((x) => {
                inputString.ToList().ForEach((y) =>
                {
                    if (x.ToString() == y.ToString().ToUpper())
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
