package ua.foxminded.integerdivision.provider;

import ua.foxminded.integerdivision.domain.DivisionResult;

/**
 * Provides calculation logic for integer division.
 */
public interface MathProvider {

    /**
     * Calculates quotient, remainder, and intermediate division steps.
     *
     * @param dividend value to be divided
     * @param divisor value by which the dividend is divided
     * @return division result containing quotient, remainder, and steps
     */
    DivisionResult calculate(int dividend, int divisor);
}
