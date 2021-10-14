using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K04 : IQuestion
{
    public void Question1()
    {
        try
        {
            Console.Write("年齢を入力してください。＞");
            var age = int.Parse(Console.ReadLine() ?? "0");

            Console.WriteLine(age is < 3 or >= 70 ? "入場料金無料です。" : "通常料金です。");
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question2()
    {
        try
        {
            Console.Write("性別を選択してください。（０：男性　１：女性）＞");
            var gender = int.Parse(Console.ReadLine() ?? "0");
            
            Console.WriteLine(gender switch
            {
                0 => "あら、格好良いですね。",
                1 => "あら、モデルさんみたいですね。",
                _ => "そんな選択肢はありません。"
            });
            
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question3()
    {
        try
        {
            Console.Write("年齢を入力してください。＞");
            var age = int.Parse(Console.ReadLine() ?? "0");
            
            Console.WriteLine(age switch
            {
                < 3 or >= 70 => "入場料金無料です。",
                >= 3 and <= 15 => "子供料金で半額です。",
                >= 60 and < 70 => "シニア割引で一割引きです。",
                _ => "通常料金です。"
            });
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question4()
    {
        try
        {
            Console.WriteLine("＊＊＊おみくじプログラム＊＊＊");
            Console.Write("おみくじを引きますか　（はい：１　いいえ：０）　＞");
            var choice = int.Parse(Console.ReadLine() ?? "0");

            if (choice == 0)
                return;
            
            var randomNumber = new Random();
            var oracle = randomNumber.Next(0, 5);
            
            Console.WriteLine(oracle switch
            {
                0 => "大吉　とってもいいことがありそう！！",
                1 => "中吉　きっといいことあるんじゃないかな",
                2 => "小吉　少しぐらいはいいことあるかもね",
                3 => "凶　今日はおとなしくておいた方がいいかも",
                4 => "大凶　これじゃやばくない？早く家に帰った方がいいかも",
                _ => ""
            });
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }
}