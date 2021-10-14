namespace CSharpRewrite.Assignments.Extra;

public static class Road
{
    private readonly struct Route : IComparable<Route>
    {
        public int Destination { get; init; }
        public IEnumerable<(char, int)> Path { get; init; }

        public int CompareTo(Route other)
        {
            var destinationCompareResult = Destination.CompareTo(other.Destination);
            if (destinationCompareResult != 0)
                return destinationCompareResult;

            var zipped = Path.Zip(other.Path);
            foreach (var (first, second) in zipped)
            {
                var compareResult = first.CompareTo(second);
                if (compareResult != 0)
                    return compareResult;
            }

            return Path.Count().CompareTo(other.Path.Count());
        }
    }

    private struct RoutingResult
    {
        public Route A { get; init; }
        public Route B { get; init; }
    }
    
    public static IEnumerable<(char, int)> Run()
    {
        var content = File.ReadAllLines("road.txt");
        var map = ParseMap(content);
        var values = GroupValues(new Queue<int>(map));
        return OptimalPath(values);
    }

    private static IEnumerable<int> ParseMap(IEnumerable<string> content)
        => content.Select(s => s.Trim()).Select(int.Parse);

    private static Queue<(int, int, int)> GroupValues(Queue<int> numbers)
    {
        var queue = new Queue<(int, int, int)>();
        while (numbers.Count != 0)
        {
            var a = numbers.Dequeue();
            var b = numbers.Dequeue();
            var x = numbers.Dequeue();
            queue.Enqueue((a, b, x));
        }

        return queue;
    }

    private static RoutingResult ShortestSteps(RoutingResult routingResult, (int, int, int) item)
    {
        var (a, b, x) = item;
        var optA1 = new Route()
        {
            Destination = routingResult.A.Destination + a,
            Path = routingResult.A.Path.Append(('a', a))
        };

        var optA2 = new Route()
        {
            Destination = routingResult.B.Destination + b + x,
            Path = routingResult.B.Path.Append(('b', b)).Append(('x', x))
        };
        
        var optB1 = new Route()
        {
            Destination = routingResult.B.Destination + b,
            Path = routingResult.B.Path.Append(('b', b))
        };
        
        var optB2 = new Route()
        {
            Destination = routingResult.A.Destination + a + x,
            Path = routingResult.A.Path.Append(('a', a)).Append(('x', x))
        };

        return new RoutingResult()
        {
            A = new[] { optA1, optA2 }.Min(),
            B = new[] { optB1, optB2 }.Min()
        };
    }

    private static IEnumerable<(char, int)> OptimalPath(IEnumerable<(int, int, int)> values)
    {
        var result = values.Aggregate(new RoutingResult()
        {
            A = new Route() { Destination = 0, Path = Enumerable.Empty<(char, int)>() },
            B = new Route() { Destination = 0, Path = Enumerable.Empty<(char, int)>() },
        }, ShortestSteps);

        if (result.A.Path.Last() != ('x', 0))
            return result.A.Path;
        return result.B.Path.Last() != ('x', 0) ? result.B.Path : new Route().Path;
    }
}