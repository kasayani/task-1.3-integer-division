package ua.foxminded.integerdivision.provider;

/**
 * Validates dividend and divisor before division calculation.
 */
public interface DivisionValidator {

    /**
     * Validates input values for integer division.
     *
     * @param dividend value to be divided
     * @param divisor value by which the dividend is divided
     * @throws IllegalArgumentException if input values are invalid
     */
    void validate(int dividend, int divisor) throws IllegalArgumentException;
}
