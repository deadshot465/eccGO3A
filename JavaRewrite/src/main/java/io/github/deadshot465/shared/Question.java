package io.github.deadshot465.shared;

public interface Question {
    void question1();
    void question2();
    void question3();
    void question4();

    default void execute(int num) {
        switch (num) {
            case 1 -> question1();
            case 2 -> question2();
            case 3 -> question3();
            case 4 -> question4();
            default -> {
            }
        }
    }
}
