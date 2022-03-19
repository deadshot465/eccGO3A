using System.Threading.Channels;

namespace CSharpRewrite.Assignments.Musicians;

public class Musician
{
    public string Name { get; }
    public string Role { get; }
    public SkillLevel SkillLevel { get; }
    public ChannelReader<int> Reader { get; }

    public const int Delay = 750;

    private static readonly string[] FirstNames =
    {
        "Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
        "Janet", "Leo", "Yuhei", "Carson"
    };

    public static readonly string[] LastNames =
    {
        "Frizzle",
        "Perlstein",
        "Ramon",
        "Ann",
        "Franklin",
        "Terese",
        "Tennelli",
        "Jamal",
        "Li",
        "Perlstein",
        "Fujioka",
        "Ito",
        "Hage"
    };

    public Musician(string role, SkillLevel skillLevel, ChannelReader<int> reader)
    {
        Name = PickName();
        Role = role;
        SkillLevel = skillLevel;
        Reader = reader;
        Console.WriteLine($"Musician {Name}, playing the {Role} entered the room.");
    }

    public bool PlaySound()
    {
        if (Reader.TryRead(out _))
        {
            Console.WriteLine($"{Name} just got back to playing in the subway.");
            return false;
        }

        switch (SkillLevel)
        {
            case SkillLevel.Good:
            {
                Console.WriteLine($"{Name} produced sound!");
                return true;
            }
            case SkillLevel.Bad:
            {
                var rng = new Random();
                var failed = rng.Next(0, 5) == 0;
                if (failed)
                {
                    Console.WriteLine($"{Name} played a false note. Uh oh.");
                    Console.WriteLine($"{Name} sucks! kicked that member out of the band! ({Role})");
                }
                else
                {
                    Console.WriteLine($"{Name} produced sound!");
                }

                return !failed;
            }
            default:
                return true;
        }
    }

    private static string PickName()
    {
        var rng = new Random();
        var firstName = FirstNames[rng.Next(0, FirstNames.Length)];
        var lastName = LastNames[rng.Next(0, LastNames.Length)];
        return $"{firstName} {lastName}";
    }
}