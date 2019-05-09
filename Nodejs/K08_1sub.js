"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function GetMaxValue(v1, v2, v3) {
    let temp = v1 >= v2 ? v1 : v2;
    temp = temp >= v3 ? temp : v3;
    return temp;
}
exports.GetMaxValue = GetMaxValue;
function GetMinValue(v1, v2, v3) {
    let temp = v1 < v2 ? v1 : v2;
    temp = temp < v3 ? temp : v3;
    return temp;
}
exports.GetMinValue = GetMinValue;
//# sourceMappingURL=K08_1sub.js.map