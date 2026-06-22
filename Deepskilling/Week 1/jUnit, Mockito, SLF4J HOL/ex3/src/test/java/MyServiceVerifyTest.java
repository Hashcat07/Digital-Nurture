import static org.mockito.Mockito.*;

import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();

    }
}