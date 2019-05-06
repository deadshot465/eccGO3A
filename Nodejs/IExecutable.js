"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
class IExecutable {
    Execute(num, rl) {
        return __awaiter(this, void 0, void 0, function* () {
            switch (num) {
                case 1:
                    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                        yield this.Question1(rl);
                        resolve();
                    }));
                case 2:
                    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                        yield this.Question2(rl);
                        resolve();
                    }));
                case 3:
                    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                        yield this.Question3(rl);
                        resolve();
                    }));
                case 4:
                    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                        yield this.Question4(rl);
                        resolve();
                    }));
                default:
                    break;
            }
        });
    }
}
exports.IExecutable = IExecutable;
//# sourceMappingURL=IExecutable.js.map