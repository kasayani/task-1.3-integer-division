package ua.foxminded.integerdivision.provider.impl;

import org.junit.jupiter.api.Test;
import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.domain.DivisionStep;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewProviderTest {

    private final ViewProviderImpl defaultViewProvider = new ViewProviderImpl();

    @Test
    void shouldBuildStringFromCalculationResult() {
        DivisionResult input = DivisionResult.builder()
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

        String expected = String.join(System.lineSeparator(),
                "1) 7 -> 1 (remainder 3)",
                "2) 38 -> 9 (remainder 2)",
                "3) 29 -> 7 (remainder 1)",
                "4) 14 -> 3 (remainder 2)",
                "5) 25 -> 6 (remainder 1)",
                "Summary: quotient = 19736, remainder = 1");

        String result = defaultViewProvider.provideView(input);
        assertThat(result).isEqualTo(expected);
    }
}
