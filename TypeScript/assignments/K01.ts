import Executable from "../shared/Executable.ts";

export default class K01 extends Executable {
    question1(): void {
        console.log("Hello World! ようこそTypeScript言語の世界へ！");
    }

    question2(): void {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
    }

    question3(): void {
        console.log("整数：" + 12345);
        console.log("実数：" + 123.456789);
        console.log("文字：" + 'A');
        console.log("文字列：" + "ABCdef");
    }

    question4(): void {
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
    }
}