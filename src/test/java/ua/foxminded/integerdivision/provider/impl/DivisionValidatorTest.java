package ua.foxminded.integerdivision.provider.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DivisionValidatorTest {

    private final DivisionValidatorImpl defaultDivisionValidator = new DivisionValidatorImpl();

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDividingByZero() {
        assertThatThrownBy(() -> defaultDivisionValidator.validate(454, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Divisor cannot be zero");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDividendIsNegative() {
        assertThatThrownBy(() -> defaultDivisionValidator.validate(-467, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must not be negative");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDivisorIsNegative() {
        assertThatThrownBy(() -> defaultDivisionValidator.validate(467, -2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must not be negative");
    }

    @Test
    void shouldNotThrowExceptionWhenValuesAreValid() {
        assertDoesNotThrow(() -> defaultDivisionValidator.validate(467, 2));
    }
}
