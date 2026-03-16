package ua.foxminded.integerdivision.app;

import ua.foxminded.integerdivision.provider.DivisionValidator;
import ua.foxminded.integerdivision.service.LongDivisionCalculator;
import ua.foxminded.integerdivision.provider.MathProvider;
import ua.foxminded.integerdivision.provider.ViewProvider;
import ua.foxminded.integerdivision.provider.impl.DivisionValidatorImpl;
import ua.foxminded.integerdivision.provider.impl.MathProviderImpl;
import ua.foxminded.integerdivision.provider.impl.ViewProviderImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInputReader reader = new UserInputReader(new Scanner(System.in));
        DivisionValidator validator = new DivisionValidatorImpl();
        MathProvider mathProvider = new MathProviderImpl();
        ViewProvider viewProvider = new ViewProviderImpl();

        LongDivisionCalculator calculator = new LongDivisionCalculator(validator, mathProvider, viewProvider);

        while (true) {
            try {
                int dividend = reader.readDividend();
                int divisor = reader.readDivisor();
                String result = calculator.calculate(dividend, divisor);
                System.out.println(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again");
            }
        }
    }
}
