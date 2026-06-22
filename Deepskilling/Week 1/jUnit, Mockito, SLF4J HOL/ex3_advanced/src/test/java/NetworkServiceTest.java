import org.example.NetworkClient;
import org.example.NetworkService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NetworkServiceTest {
    @Test
    public void testServiceWithMockNetworkClient(){
        NetworkClient networkClient=mock(NetworkClient.class);
        when(networkClient.connect()).thenReturn("Mock Connection");

        NetworkService networkService=new NetworkService();
        String result=networkService.connectToServer();

        assertEquals("Connected to Mock Connection",result);
    }
}
