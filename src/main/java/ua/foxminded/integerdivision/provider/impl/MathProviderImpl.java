package ua.foxminded.integerdivision.provider.impl;

import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.domain.DivisionStep;
import ua.foxminded.integerdivision.provider.MathProvider;

import java.util.ArrayList;
import java.util.List;

public class MathProviderImpl implements MathProvider {

    @Override
    public DivisionResult calculate(int dividend, int divisor) {
        int[] dividendArr = splitDividend(dividend);
        List<DivisionStep> steps = new ArrayList<>();
        int remainder = 0;
        int currentDividend;

        for (int i = 0; i < dividendArr.length; i++) {
            currentDividend = remainder * 10 + dividendArr[i];
            remainder = currentDividend % divisor;
            int quotientDigit = currentDividend / divisor;

            DivisionStep step = new DivisionStep(currentDividend, quotientDigit, remainder);
            steps.add(step);
        }
        return DivisionResult.builder()
                .quotient(dividend / divisor)
                .remainder(dividend % divisor)
                .steps(steps)
                .build();
    }

    private int[] splitDividend(int dividend) {
        String textDividend = String.valueOf(dividend);
        int[] dividendArr = new int[textDividend.length()];
        for (int i = 0; i < dividendArr.length; i++) {
            dividendArr[i] = Character.getNumericValue(textDividend.charAt(i));
        }
        return dividendArr;
    }
}
