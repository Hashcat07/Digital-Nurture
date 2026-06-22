import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.example.GlobalExceptionHandler;
import org.example.UserController;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

@WebMvcTest(UserController.class)
@Import(GlobalExceptionHandler.class)   // register the advice in the slice
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testHandleNotFound() throws Exception {
        when(userService.getUserById(99L))
                .thenThrow(new NoSuchElementException("No user 99"));

        mockMvc.perform(get("/users/99"))
                .andExpect(status().isNotFound())          // 404 from the advice
                .andExpect(content().string("User not found"));
    }
}