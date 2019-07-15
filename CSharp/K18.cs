using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace CSharp
{
    class K18 : IExecutable
    {
        private struct Result
        {
            string Name;
            int Score;
            int Miss;
        }

        private void ReadFile()
        {
            FileStream fs = File.Open("save1.dat", FileMode.OpenOrCreate, FileAccess.ReadWrite, FileShare.None);
            if (fs.Length > 0)
            {
                Console.WriteLine("\n名前\t得点\tミス回数\n");
                for (int i = 0; i < 45; i++)
                {
                    Console.Write("-");
                }
                Console.WriteLine();

                byte[] data = File.ReadAllBytes("save1.dat");
            }

        }

        public override void Question01()
        {
            
        }

        public override void Question02()
        {
            throw new NotImplementedException();
        }

        public override void Question03()
        {
            throw new NotImplementedException();
        }

        public override void Question04()
        {
            throw new NotImplementedException();
        }
    }
}
