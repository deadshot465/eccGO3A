import * as readline from 'readline';

export abstract class IExecutable {

    async Execute(num: number, rl?: readline.ReadLine): Promise<string> {
        switch (num) {
            case 1:
                return new Promise<string>(async (resolve, reject) => {
                    await this.Question1(rl);
                    resolve();
                });
            case 2:
                return new Promise<string>(async (resolve, reject) => {
                    await this.Question2(rl);
                    resolve();
                });
            case 3:
                return new Promise<string>(async (resolve, reject) => {
                    await this.Question3(rl);
                    resolve();
                });
            case 4:
                return new Promise<string>(async (resolve, reject) => {
                    await this.Question4(rl);
                    resolve();
                });
            default:
                break;
        }
    }

    abstract Question1(rl?: readline.ReadLine): Promise<string>;

    abstract Question2(rl?: readline.ReadLine): Promise<string>;

    abstract Question3(rl?: readline.ReadLine): Promise<string>;

    abstract Question4(rl?: readline.ReadLine): Promise<string>;
}