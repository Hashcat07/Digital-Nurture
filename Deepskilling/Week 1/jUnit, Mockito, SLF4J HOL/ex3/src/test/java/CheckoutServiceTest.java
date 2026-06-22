import static org.mockito.Mockito.*;

import org.example.CheckoutService;
import org.example.PaymentApi;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class CheckoutServiceTest {

    @Test
    public void testInteractionOrder() {
        PaymentApi mockPayment = mock(PaymentApi.class);

        CheckoutService service = new CheckoutService(mockPayment);
        service.checkout();

        InOrder inOrder = inOrder(mockPayment);
        inOrder.verify(mockPayment).validate(); 
        inOrder.verify(mockPayment).charge();
    }
}