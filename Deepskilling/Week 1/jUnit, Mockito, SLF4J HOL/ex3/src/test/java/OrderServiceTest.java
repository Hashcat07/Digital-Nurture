import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.OrderApi;
import org.example.OrderService;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testArgumentMatching() {
        OrderApi mockApi = mock(OrderApi.class);

        when(mockApi.getOrder(anyInt())).thenReturn("ORDER-OK");

        OrderService service = new OrderService(mockApi);
        String result = service.process(100);

        assertEquals("ORDER-OK", result);

        verify(mockApi).getOrder(eq(100));
    }
}