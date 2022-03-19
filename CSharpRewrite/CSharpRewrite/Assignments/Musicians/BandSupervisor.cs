using System.Threading.Channels;

namespace CSharpRewrite.Assignments.Musicians;

public static class BandSupervisor
{
    public static async Task StartBand(int maxRetries)
    {
        var channel = Channel.CreateUnbounded<(string, SkillLevel)>();
        var senders = new Dictionary<string, ChannelWriter<int>>
        {
            { "singer", AddBandMember("singer", SkillLevel.Good, channel.Writer) },
            { "bass", AddBandMember("bass", SkillLevel.Good, channel.Writer) },
            { "drum", AddBandMember("drum", SkillLevel.Bad, channel.Writer) },
            { "guitar", AddBandMember("guitar", SkillLevel.Good, channel.Writer) },
        };

        while (true)
        {
            var (role, skillLevel) = await channel.Reader.ReadAsync();
            maxRetries--;
            senders.Remove(role);
            if (maxRetries <= 0)
            {
                Console.WriteLine("The manager is mad and fired the whole band!");
                foreach (var (_, writer) in senders)
                {
                    await writer.WriteAsync(0);
                }

                await Task.Delay(TimeSpan.FromSeconds(3));
                break;
            }
            
            senders.Add(role, AddBandMember(role, skillLevel, channel.Writer));
        }
    }

    private static ChannelWriter<int> AddBandMember(string role, SkillLevel skillLevel, ChannelWriter<(string, SkillLevel)> writer)
    {
        var fireChannel = Channel.CreateUnbounded<int>();
        _ = Task.Run(async () =>
        {
            var musician = new Musician(role, skillLevel, fireChannel.Reader);
            while (true)
            {
                await Task.Delay(TimeSpan.FromMilliseconds(Musician.Delay));
                var playResult = musician.PlaySound();
                if (playResult) continue;

                await writer.WriteAsync((role, skillLevel));
                break;
            }
        });

        return fireChannel.Writer;
    }
}