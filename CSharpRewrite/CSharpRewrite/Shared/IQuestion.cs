namespace CSharpRewrite.Shared;

public interface IQuestion
{
    void Question1();
    void Question2();
    void Question3();
    void Question4();

    void Execute(int num)
    {
        switch (num)
        {
            case 1:
                Question1();
                break;
            case 2:
                Question2();
                break;
            case 3:
                Question3();
                break;
            case 4:
                Question4();
                break;
        }
    }
}