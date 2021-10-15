export default abstract class Executable {
    abstract question1(): void;
    abstract question2(): void
    abstract question3(): void;
    abstract question4(): void;

    execute(num: number): void {
        switch (num) {
            case 1:
                this.question1();
                break;
            case 2:
                this.question2();
                break;
            case 3:
                this.question3();
                break;
            case 4:
                this.question4();
                break;
            default:
                break;
        }
    }
}