"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const IExecutable_1 = require("./IExecutable");
class K01 extends IExecutable_1.IExecutable {
    Question1() {
        console.log("Hello World! ようこそTypeScript言語の世界へ！");
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question2() {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question3() {
        console.log("整数：" + 12345);
        console.log("実数：" + 123.456789);
        console.log("文字：" + 'A');
        console.log("文字列：" + "ABCdef");
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question4() {
        console.log("              ##");
        console.log("             #  #");
        console.log("             #  #");
        console.log("            #    #");
        console.log("           #      #");
        console.log("         ##        ##");
        console.log("       ##            ##");
        console.log("    ###                ###");
        console.log(" ###       ##    ##       ###");
        console.log("##        #  #  #  #        ##");
        console.log("##         ##    ##         ##");
        console.log(" ##     #            #     ##");
        console.log("  ###     ##########     ###");
        console.log("     ###              ###");
        console.log("        ##############");
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
}
exports.K01 = K01;
//# sourceMappingURL=K01.js.map