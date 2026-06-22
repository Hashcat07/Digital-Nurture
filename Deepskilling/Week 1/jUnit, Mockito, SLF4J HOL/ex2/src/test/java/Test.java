import org.example.EvenChecker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    private EvenChecker obj1;
    @BeforeEach
    public void setup(){
        obj1=new EvenChecker();
    }

    @AfterEach
    public void tearDown(){
        obj1=null;
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    public void test(int num){
        boolean result=obj1.isEven(num);
        boolean expected=true;

        assertTrue(expected==result);


    }
}
