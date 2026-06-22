import static org.mockito.Mockito.*;

import org.example.EmailApi;
import org.example.NotificationService;
import org.junit.jupiter.api.Test;

public class NotificationServiceTest {

    @Test
    public void testVoidMethod() {
        EmailApi mockEmail = mock(EmailApi.class);

        doNothing().when(mockEmail).sendEmail(anyString());

        NotificationService service = new NotificationService(mockEmail);
        service.notifyUser("ray@example.com");

        verify(mockEmail).sendEmail("ray@example.com");
    }
}