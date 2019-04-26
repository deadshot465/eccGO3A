using System;

namespace CSharp
{
    public class K02_3 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Console.Write("一つ目の商品の値段は？");
                int priceA = int.Parse(Console.ReadLine());
                Console.Write("個数は？");
                int amountA = int.Parse(Console.ReadLine());
                Console.Write("二つ目の商品の値段は？");
                int priceB = int.Parse(Console.ReadLine());
                Console.Write("個数は？");
                int amountB = int.Parse(Console.ReadLine());

                Console.WriteLine(string.Format("お支払いは税込み￥{0}です", (int)((priceA * amountA + priceB * amountB) * 1.08f)));

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
