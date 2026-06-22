import org.example.EvenChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    @Test
    void testEven() {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(4));
    }
}