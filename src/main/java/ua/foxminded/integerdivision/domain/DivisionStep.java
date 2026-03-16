package ua.foxminded.integerdivision.domain;

import java.util.Objects;

public class DivisionStep {
    private final int currentDividend;
    private final int quotientDigit;
    private final int remainder;

    public DivisionStep(int currentDividend, int quotientDigit, int remainder) {
        this.currentDividend = currentDividend;
        this.quotientDigit = quotientDigit;
        this.remainder = remainder;
    }

    public int getCurrentDividend() {
        return currentDividend;
    }

    public int getQuotientDigit() {
        return quotientDigit;
    }

    public int getRemainder() {
        return remainder;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DivisionStep that)) {
            return false;
        }
        return currentDividend == that.currentDividend
                && quotientDigit == that.quotientDigit
                && remainder == that.remainder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentDividend, quotientDigit, remainder);
    }

    @Override
    public String toString() {
        return "DivisionStep{" +
                "currentDividend=" + currentDividend +
                ", quotientDigit=" + quotientDigit +
                ", remainder=" + remainder +
                '}';
    }
}
