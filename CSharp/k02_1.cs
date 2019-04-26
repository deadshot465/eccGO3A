using System;

namespace CSharp
{
    public class K02_1 : IExecutable
    {
        public void Execute()
        {
            int seisuu = 3;
            float jissuu = 2.6f;
            char moji = 'A';

            Console.WriteLine("変数seisuuの値は" + seisuu);
            Console.WriteLine("変数jissuuの値は" + jissuu);
            Console.WriteLine("変数mojiの値は" + moji);
        }
    }
}
