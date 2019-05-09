export function GetMaxValue(v1: number, v2: number, v3: number): number {
    let temp = v1 >= v2 ? v1 : v2;
    temp = temp >= v3 ? temp : v3;
    return temp;
}

export function GetMinValue(v1: number, v2: number, v3: number): number {
    let temp = v1 < v2 ? v1 : v2;
    temp = temp < v3 ? temp : v3;
    return temp;
}