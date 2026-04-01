package ua.foxminded.integerdivision.provider.impl;

import ua.foxminded.integerdivision.domain.DivisionResult;
import ua.foxminded.integerdivision.domain.DivisionStep;
import ua.foxminded.integerdivision.provider.ViewProvider;

import java.util.List;

public class ViewProviderImpl implements ViewProvider {

    @Override
    public String provideView(DivisionResult result) {
        List<DivisionStep> steps = result.getSteps();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < steps.size(); i++) {
            DivisionStep currentStep = steps.get(i);
            int stepNumber = i + 1;

            output.append(stepNumber)
                    .append(") ")
                    .append(currentStep.getCurrentDividend())
                    .append(" -> ")
                    .append(currentStep.getQuotientDigit())
                    .append(" (remainder ")
                    .append(currentStep.getRemainder())
                    .append(")");

            output.append(System.lineSeparator());
        }
        output.append("Summary: quotient = ")
                .append(result.getQuotient())
                .append(", remainder = ")
                .append(result.getRemainder());

        return output.toString();
    }
}
