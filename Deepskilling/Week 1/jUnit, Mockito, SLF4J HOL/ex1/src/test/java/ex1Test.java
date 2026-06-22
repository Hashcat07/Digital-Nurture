import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ex1Test {

    private Main obj1;

    @Before
    public void setUp() {
        obj1 = new Main();
        System.out.println("Setting up test...");
    }

    @After
    public void tearDown() {
        obj1 = null;
        System.out.println("Cleaning up after test...");
    }

    @Test
    public void TestCalculator() {

        // Arrange
        int expected = 12;

        // Act
        int actual = obj1.addNoParam();

        // Assert
        assertEquals(expected, actual);
    }
}