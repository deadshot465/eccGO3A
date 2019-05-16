import { IExecutable } from './IExecutable';
import * as fs from 'fs'

export class FileControl extends IExecutable {
    Question1(rl?: import("readline").ReadLine): Promise<string> {

        var outputString = "This is the string to write.\n";

        return new Promise((resolve, reject) => {
            fs.writeFile("output.txt", outputString, (err) => {
                if (err) {
                    reject(err);
                    return;
                }
                console.log("Completed.");
            });
            resolve();
        });

    }

    Question2(rl?: import("readline").ReadLine): Promise<string> {
        throw new Error("Method not implemented.");
    }

    Question3(rl?: import("readline").ReadLine): Promise<string> {
        throw new Error("Method not implemented.");
    }

    Question4(rl?: import("readline").ReadLine): Promise<string> {
        throw new Error("Method not implemented.");
    }


}