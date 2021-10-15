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