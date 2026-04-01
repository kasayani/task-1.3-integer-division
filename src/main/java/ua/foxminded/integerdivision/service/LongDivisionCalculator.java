package ua.foxminded.integerdivision.service;

import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.provider.DivisionValidator;
import ua.foxminded.integerdivision.provider.MathProvider;
import ua.foxminded.integerdivision.provider.ViewProvider;

public class LongDivisionCalculator {
    private final DivisionValidator validator;
    private final MathProvider mathProvider;
    private final ViewProvider viewProvider;

    public LongDivisionCalculator(DivisionValidator validator, MathProvider mathProvider, ViewProvider viewProvider) {
        this.validator = validator;
        this.mathProvider = mathProvider;
        this.viewProvider = viewProvider;
    }

    public String calculate(int dividend, int divisor) {
        validator.validate(dividend, divisor);

        DivisionResult result = mathProvider.calculate(dividend, divisor);

        return viewProvider.provideView(result);
    }
}
