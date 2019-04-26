using System;

namespace CSharp
{
    public class K01_3 : IExecutable
    {
        public void Execute()
        {
            Console.WriteLine("整数：" + 12345);
            Console.WriteLine("実数：" + 123.456789);
            Console.WriteLine("文字：" + 'X');
            Console.WriteLine("文字列：" + "ABCdef");
        }
    }
}
