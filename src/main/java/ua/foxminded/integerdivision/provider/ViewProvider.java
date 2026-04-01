package ua.foxminded.integerdivision.provider;

import ua.foxminded.integerdivision.domain.DivisionResult;

/**
 * Converts a division result into a formatted string representation.
 */
public interface ViewProvider {

    /**
     * Builds a formatted view of the division result.
     *
     * @param result calculated division result
     * @return formatted string representation of the result
     */
    String provideView(DivisionResult result);
}
