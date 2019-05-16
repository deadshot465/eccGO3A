"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const IExecutable_1 = require("./IExecutable");
const fs = require("fs");
class FileControl extends IExecutable_1.IExecutable {
    Question1(rl) {
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
    Question2(rl) {
        throw new Error("Method not implemented.");
    }
    Question3(rl) {
        throw new Error("Method not implemented.");
    }
    Question4(rl) {
        throw new Error("Method not implemented.");
    }
}
exports.FileControl = FileControl;
//# sourceMappingURL=FileControl.js.map