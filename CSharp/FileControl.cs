using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace CSharp
{
    class FileControl : IExecutable
    {
        public override void Question01()
        {
            FileStream fs = new FileStream("output.txt", FileMode.OpenOrCreate, FileAccess.ReadWrite);

            string output = "This is the string to write.\n";
            byte[] outputBytes = Encoding.Unicode.GetBytes(output);

            fs.Write(outputBytes);

            fs.Close();

            Console.WriteLine("Completed.");

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
