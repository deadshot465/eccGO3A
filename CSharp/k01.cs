using System;

namespace CSharp
{
    public class K01 : IExecutable
    {

        public override void Question01()
        {
            Console.WriteLine("Hello World! ようこそC#言語の世界へ！");
        }

        public override void Question02()
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine("ようこそ");
            Console.WriteLine("C#言語の世界へ！");
        }

        public override void Question03()
        {
            Console.WriteLine("整数：" + 12345);
            Console.WriteLine("実数：" + 123.456789);
            Console.WriteLine("文字：" + 'X');
            Console.WriteLine("文字列：" + "ABCdef");
        }

        public override void Question04()
        {
            Console.WriteLine("              ##");
            Console.WriteLine("             #  #");
            Console.WriteLine("             #  #");
            Console.WriteLine("            #    #");
            Console.WriteLine("           #      #");
            Console.WriteLine("         ##        ##");
            Console.WriteLine("       ##            ##");
            Console.WriteLine("    ###                ###");
            Console.WriteLine(" ###       ##    ##       ###");
            Console.WriteLine("##        #  #  #  #        ##");
            Console.WriteLine("##         ##    ##         ##");
            Console.WriteLine(" ##     #            #     ##");
            Console.WriteLine("  ###     ##########     ###");
            Console.WriteLine("     ###              ###");
            Console.WriteLine("        ##############");
        }
    }
}
