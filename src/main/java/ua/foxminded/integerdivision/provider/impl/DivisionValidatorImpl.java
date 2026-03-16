package ua.foxminded.integerdivision.provider.impl;

import ua.foxminded.integerdivision.provider.DivisionValidator;

public class DivisionValidatorImpl implements DivisionValidator {

    @Override
    public void validate(int dividend, int divisor) {
        validateNonNegativeNumber(dividend);
        validateNonNegativeNumber(divisor);
        validateDivisorIsNotZero(divisor);
    }

    private void validateDivisorIsNotZero(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
    }

    private void validateNonNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Value must not be negative");
        }
    }
}
