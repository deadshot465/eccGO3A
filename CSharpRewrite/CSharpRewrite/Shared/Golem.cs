namespace CSharpRewrite.Shared;

public struct Golem
{
    public int Hp { get; set; }
    public int Defense { get; set; }
    public int Attack { get; set; }

    public Golem(int hp, int defense, int attack)
    {
        Hp = hp;
        Defense = defense;
        Attack = attack;
    }
}