export async function prompt(message = "") {
    const buffer = new Uint8Array();
    await Deno.stdout.write(new TextEncoder().encode(message));
    const n = <number>(await Deno.stdin.read(buffer));
    return new TextDecoder().decode(buffer.subarray(0, n)).trim();
}

export function writeToStdout(message = "") {
    Deno.stdout.writeSync(new TextEncoder().encode(message));
}

export function getRandomNumber(max: number): number {
    return Math.floor(Math.random() * Math.floor(max));
}

export interface Tuple<T, U> {
    first: T,
    second: U
}

export interface Triple<T, U, V> {
    a: T,
    b: U,
    x: V,
}