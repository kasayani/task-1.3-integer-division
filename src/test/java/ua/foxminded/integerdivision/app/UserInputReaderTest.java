package ua.foxminded.integerdivision.app;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputReaderTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDividendIsNotInteger() {
        UserInputReader userInputReader = new UserInputReader(new Scanner("sfgfg"));
        assertThatThrownBy(userInputReader::readDividend)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input value must be an integer");
    }

    @Test
    void shouldReadDivisorWhenInputIsInteger() {
        UserInputReader userInputReader = new UserInputReader(new Scanner("4"));
        int result = userInputReader.readDivisor();
        assertThat(result).isEqualTo(4);
    }
}
