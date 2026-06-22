import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.EmailApi;
import org.example.NotificationService;
import org.junit.jupiter.api.Test;

public class NotificationServiceExceptionTest {

    @Test
    public void testVoidMethodThrows() {
        EmailApi mockEmail = mock(EmailApi.class);

        doThrow(new RuntimeException("Email server down")).when(mockEmail).sendEmail(anyString());

        NotificationService service = new NotificationService(mockEmail);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.notifyUser("ray@example.com"));

        assertEquals("Email server down", ex.getMessage());

        verify(mockEmail).sendEmail("ray@example.com");
    }
}