using System;

namespace CSharp
{
    public class K05_1 : IExecutable
    {
        public void Execute()
        {
            float salary = 19.0f;
            int age = 22;

            while (salary < 50.0f)
            {
                salary *= 1.035f;
                age++;
            }

            Console.Write(age + "歳で月給" + salary + "万円");
        }
    }
}
