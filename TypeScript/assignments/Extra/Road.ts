import { Tuple, Triple } from "../../shared/Utility.ts";

interface Route {
    destination: number,
    path: Tuple<string, number>[]
}

interface RoutingResult {
    a: Route,
    b: Route
}

function parseMap(content: string): number[] {
    return content
    .split('\n')
    .map(s => s.trim())
    .filter(s => s.length > 0 && s != "")
    .map(s => Number.parseInt(s));
}

function groupValues(numbers: number[]): Triple<number, number, number>[] {
    const arr = new Array<Triple<number, number, number>>();
    
    while (numbers.length > 0) {
        const a = numbers.shift() ?? 0;
        const b = numbers.shift() ?? 0;
        const x = numbers.shift() ?? 0;
        arr.push({ a, b, x })
    }

    return arr;
}

function shortestSteps(acc: RoutingResult, elem: Triple<number, number, number>): RoutingResult {
    const { a, b, x } = elem;
    
    const optA1Path = [...acc.a.path];
    optA1Path.push({ first: 'a', second: a })
    const optA1: Route = {
        destination: acc.a.destination + a,
        path: optA1Path
    };

    const optA2Path = [...acc.b.path];
    optA2Path.push({ first: 'b', second: b })
    optA2Path.push({ first: 'x', second: x })
    const optA2: Route = {
        destination: acc.b.destination + b + x,
        path: optA2Path
    };

    const optB1Path = [...acc.b.path];
    optB1Path.push({ first: 'b', second: b })
    const optB1: Route = {
        destination: acc.b.destination + b,
        path: optB1Path
    };

    const optB2Path = [...acc.a.path];
    optB2Path.push({ first: 'a', second: a })
    optB2Path.push({ first: 'x', second: x })
    const optB2: Route = {
        destination: acc.a.destination + a + x,
        path: optB2Path
    };

    return {
        a: minRoute(optA1, optA2),
        b: minRoute(optB1, optB2),
    };
}

function optimalPath(values: Triple<number, number, number>[]): Tuple<string, number>[] {
    const { a, b } = values.reduce(shortestSteps, {
        a: {
            destination: 0,
            path: []
        },
        b: {
            destination: 0,
            path: []
        }
    });

    if (a.path[a.path.length - 1].first !== 'x' && a.path[a.path.length - 1].second !== 0) {
        return a.path;
    } else if (b.path[b.path.length - 1].first !== 'x' && b.path[b.path.length - 1].second !== 0) {
        return b.path;
    } else {
        return [];
    }
}

function minRoute(routeA: Route, routeB: Route): Route {
    if (routeA.destination !== routeB.destination) {
        return routeA.destination < routeB.destination ? routeA : routeB;
    }

    const shorterPath = routeA.path.length < routeB.path.length ? routeA.path : routeB.path;
    const longerPath = routeA.path.length > routeB.path.length ? routeA.path : routeB.path;

    for (let i = 0; i < shorterPath.length; i++) {
        if (shorterPath[i].first !== longerPath[i].first) {
            return shorterPath[i].first < longerPath[i].first ? routeA : routeB;
        } else if (shorterPath[i].second !== longerPath[i].second) {
            return shorterPath[i].second < longerPath[i].second ? routeA : routeB;
        }
    }
    return routeA.path.length < routeB.path.length ? routeA : routeB;
}

export default function road(): Tuple<string, number>[] {
    const content = Deno.readTextFileSync("road.txt");
    const map = parseMap(content);
    const values = groupValues(map);
    return optimalPath(values);
}