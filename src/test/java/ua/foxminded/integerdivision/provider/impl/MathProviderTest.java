package ua.foxminded.integerdivision.provider.impl;

import org.junit.jupiter.api.Test;
import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.domain.DivisionStep;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MathProviderTest {

    private final MathProviderImpl defaultMathProvider = new MathProviderImpl();

    @Test
    void shouldDivideTwoIntegersStepByStepWithFinalResult() {
        DivisionResult expected = DivisionResult.builder()
                .quotient(19736)
                .remainder(1)
                .steps(
                        List.of(
                                new DivisionStep(7, 1, 3),
                                new DivisionStep(38, 9, 2),
                                new DivisionStep(29, 7, 1),
                                new DivisionStep(14, 3, 2),
                                new DivisionStep(25, 6, 1))
                ).build();
        DivisionResult actual = defaultMathProvider.calculate(78945, 4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldDivideByStepWhenDivisorIsGreaterThanDividend() {
        DivisionResult expected = DivisionResult.builder()
                .quotient(0)
                .remainder(4)
                .steps(
                        List.of(
                                new DivisionStep(4, 0, 4))
                ).build();
        DivisionResult actual = defaultMathProvider.calculate(4, 33);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldDivideByStepWhenDividendIsZero() {
        DivisionResult expected = DivisionResult.builder()
                .quotient(0)
                .remainder(0)
                .steps(
                        List.of(
                                new DivisionStep(0, 0, 0))
                ).build();
        DivisionResult actual = defaultMathProvider.calculate(0, 18);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldDivideByStepWithoutRemainder() {
        DivisionResult expected = DivisionResult.builder()
                .quotient(21)
                .remainder(0)
                .steps(
                        List.of(
                                new DivisionStep(8, 2, 0),
                                new DivisionStep(4, 1, 0))
                ).build();
        DivisionResult actual = defaultMathProvider.calculate(84, 4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldDivideByStepWhenZeroInsideDividend() {
        DivisionResult expected = DivisionResult.builder()
                .quotient(21)
                .remainder(0)
                .steps(
                        List.of(
                                new DivisionStep(1, 0, 1),
                                new DivisionStep(10, 2, 0),
                                new DivisionStep(5, 1, 0))
                ).build();
        DivisionResult actual = defaultMathProvider.calculate(105, 5);
        assertThat(actual).isEqualTo(expected);
    }
}
