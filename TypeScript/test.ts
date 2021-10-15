import { assertEquals } from "https://deno.land/std@0.111.0/testing/asserts.ts";
import Rpn from "./assignments/Extra/Rpn.ts";
import Road from "./assignments/Extra/Road.ts";
import { Tuple } from "./shared/Utility.ts";

Deno.test({
    name: "Test Plus",
    fn: () => assertEquals(5.0, Rpn("2 3 +"))
});

Deno.test({
    name: "Test Minus",
    fn: () => assertEquals(87.0, Rpn("90 3 -"))
});

Deno.test({
    name: "Test Multiply",
    fn: () => assertEquals(-4.0, Rpn("10 4 3 + 2 * -"))
});

Deno.test({
    name: "Test Divide",
    fn: () => assertEquals(-2.0, Rpn("10 4 3 + 2 * - 2 /"))
});

Deno.test({
    name: "Test Bad Input",
    fn: () => assertEquals(null, Rpn("90 34 12 33 55 66 + * - +"))
});

Deno.test({
    name: "Test Complex Input",
    fn: () => assertEquals(4037.0, Rpn("90 34 12 33 55 66 + * - + -"))
});

Deno.test({
    name: "Test Power",
    fn: () => assertEquals(8.0, Rpn("2 3 ^"))
});

Deno.test({
    name: "Test Sqrt",
    fn: () => assertEquals(Math.sqrt(2.0), Rpn("2 0.5 ^"))
});

Deno.test({
    name: "Test Ln",
    fn: () => assertEquals(Math.log(2.7), Rpn("2.7 ln"))
});

Deno.test({
    name: "Test Log10",
    fn: () => assertEquals(Math.log10(2.7), Rpn("2.7 log10"))
});

Deno.test({
    name: "Test Sum",
    fn: () => assertEquals(50.0, Rpn("10 10 10 20 sum"))
});

Deno.test({
    name: "Test Sum And Divide",
    fn: () => assertEquals(10.0, Rpn("10 10 10 20 sum 5 /"))
});

Deno.test({
    name: "Test Product",
    fn: () => assertEquals(1000.0, Rpn("10 10 20 0.5 prod"))
});

Deno.test({
    name: "Test Heathrow to London",
    fn: () => {
        const expectedRoad: Tuple<string, number>[] = [
            { first: 'b', second: 10 },
            { first: 'x', second: 30 },
            { first: 'a', second: 5 },
            { first: 'x', second: 20 },
            { first: 'b', second: 2 },
            { first: 'b', second: 8 },
        ];
        assertEquals(expectedRoad, Road());
    }
});