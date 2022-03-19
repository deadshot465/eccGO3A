// See https://aka.ms/new-console-template for more information

using CSharpRewrite.Assignments;
using CSharpRewrite.Assignments.K08;
using CSharpRewrite.Assignments.Musicians;
using CSharpRewrite.Shared;

void ShowSelection(int chapter)
{
    if (chapter < 10)
    {
        for (var i = 1; i <= 4; i++)
        {
            Console.WriteLine($"\t{i}) K0{chapter}_{i}");
        }

        if (chapter == 9)
        {
            Console.WriteLine($"\t5) K0{chapter}_5");
        }
    }
    else
    {
        for (var i = 1; i <= 4; i++)
        {
            Console.WriteLine($"\t{i}) K{chapter}_{i}");
        }
    }
}

var questions = new List<IQuestion>()
{
    new K01(), new K02(), new K03(), new K04(), new K05(),
    new K06(), new K07(), new K08()
};

Console.WriteLine("実行したいプログラムを選択してください。");

for (var i = 1; i <= questions.Count; i++)
{
    if (i < 10)
    {
        Console.WriteLine($"{i}) K0{i}");
    }
    else
    {
        var addedNumber = i >= 12 ? i + 3 : i;
        Console.WriteLine($"{i}) K{addedNumber}");
    }
}
Console.WriteLine("100) Kex_1");
Console.WriteLine("101) Kex_2");
Console.WriteLine("102) Sort");
Console.WriteLine("103) Band Supervisor");

var choice = int.Parse(Console.ReadLine() ?? "0");

switch (choice)
{
    case 100:
    case 101:
    case 102:
        break;
    case 103:
        BandSupervisor.StartBand(5).GetAwaiter().GetResult();
        break;
    default:
        ShowSelection(choice);
        var choice2 = int.Parse(Console.ReadLine() ?? "0");
        questions[choice - 1].Execute(choice2);
        break;
}