package com.ecc.gkgo1a;

public abstract class IExecutable implements IDispatchable
{
    public void Execute(int num)
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
            default:
                break;
        }
    }

    @Override
    public abstract void Question1();
    @Override
    public abstract void Question2();
    @Override
    public abstract void Question3();
    @Override
    public abstract void Question4();

}
