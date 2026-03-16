package ua.foxminded.integerdivision.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.provider.DivisionValidator;
import ua.foxminded.integerdivision.provider.MathProvider;
import ua.foxminded.integerdivision.provider.ViewProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LongDivisionCalculatorTest {

    @Mock
    private DivisionValidator validator;

    @Mock
    private MathProvider mathProvider;

    @Mock
    private ViewProvider viewProvider;

    @InjectMocks
    private LongDivisionCalculator calculator;

    @Test
    void shouldReturnStringProvidedByViewProvider() {
        DivisionResult divisionResult = DivisionResult.builder()
                .quotient(10)
                .remainder(2)
                .steps(List.of())
                .build();

        when(mathProvider.calculate(42, 4)).thenReturn(divisionResult);
        when(viewProvider.provideView(divisionResult)).thenReturn("formatted result");

        String actual = calculator.calculate(42, 4);

        assertThat(actual).isEqualTo("formatted result");

        verify(validator).validate(42, 4);
        verify(mathProvider).calculate(42, 4);
        verify(viewProvider).provideView(divisionResult);
    }

    @Test
    void shouldThrowExceptionWhenValidatorRejectsInput() {
        doThrow(new IllegalArgumentException("Divisor cannot be zero"))
                .when(validator).validate(10, 0);

        LongDivisionCalculator calculator =
                new LongDivisionCalculator(validator, mathProvider, viewProvider);

        assertThatThrownBy(() -> calculator.calculate(10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Divisor cannot be zero");

        verify(validator).validate(10, 0);
        verifyNoInteractions(mathProvider, viewProvider);
    }
}
