import org.example.ExceptionThrower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {

        ExceptionThrower obj = new ExceptionThrower();

        RuntimeException exception =
                assertThrows(RuntimeException.class, () -> {
                    obj.throwException();
                });

        assertEquals("Exception occurred", exception.getMessage());
    }
}