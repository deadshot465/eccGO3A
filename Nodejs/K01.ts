import { IExecutable } from "./IExecutable";

export class K01 extends IExecutable {

    Question1() {
        console.log("Hello World! ようこそTypeScript言語の世界へ！");
        return new Promise<string>((resolve, reject) => {
            resolve();
        });
    }

    Question2() {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
        return new Promise<string>((resolve, reject) => {
            resolve();
        });
    }

    Question3() {
        console.log("整数：" + 12345);
        console.log("実数：" + 123.456789);
        console.log("文字：" + 'A');
        console.log("文字列：" + "ABCdef");
        return new Promise<string>((resolve, reject) => {
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
        return new Promise<string>((resolve, reject) => {
            resolve();
        });
    }

}