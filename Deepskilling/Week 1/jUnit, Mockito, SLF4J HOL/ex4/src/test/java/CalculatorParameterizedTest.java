import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorParameterizedTest {

    private final CalculatorService calculator = new CalculatorService();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "0, 0, 0",
            "-1, 1, 0",
            "-3, -4, -7",
            "100, 250, 350"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}