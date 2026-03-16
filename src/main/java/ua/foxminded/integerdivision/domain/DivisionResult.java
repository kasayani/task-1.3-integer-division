package ua.foxminded.integerdivision.domain;

import java.util.List;
import java.util.Objects;

public class DivisionResult {
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> steps;

    private DivisionResult(Builder builder) {
        this.quotient = builder.quotient;
        this.remainder = builder.remainder;
        this.steps = List.copyOf(builder.steps);
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public List<DivisionStep> getSteps() {
        return steps;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DivisionResult that)) {
            return false;
        }
        return quotient == that.quotient
                && remainder == that.remainder
                && Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quotient, remainder, steps);
    }

    @Override
    public String toString() {
        return "DivisionResult{" +
                "quotient=" + quotient +
                ", remainder=" + remainder +
                ", steps=" + steps +
                '}';
    }

    public static class Builder {
        private int quotient;
        private int remainder;
        private List<DivisionStep> steps;

        private Builder() {
        }

        public DivisionResult build() {
            return new DivisionResult(this);
        }

        public Builder quotient(int quotient) {
            this.quotient = quotient;
            return this;
        }

        public Builder remainder(int remainder) {
            this.remainder = remainder;
            return this;
        }

        public Builder steps(List<DivisionStep> steps) {
            this.steps = steps;
            return this;
        }
    }
}
