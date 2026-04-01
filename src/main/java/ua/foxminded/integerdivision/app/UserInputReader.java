package ua.foxminded.integerdivision.app;

import java.util.Scanner;

public class UserInputReader {
    private final Scanner sc;

    public UserInputReader(Scanner sc) {
        this.sc = sc;
    }

    public int readDividend() {
        return readInt("Enter a positive dividend:");
    }

    public int readDivisor() {
        return readInt("Enter a positive divisor:");
    }

    private int readInt(String prompt) {
        System.out.println(prompt);
        if (!sc.hasNextInt()) {
            sc.next();
            throw new IllegalArgumentException("Input value must be an integer");
        }
        return sc.nextInt();
    }
}
