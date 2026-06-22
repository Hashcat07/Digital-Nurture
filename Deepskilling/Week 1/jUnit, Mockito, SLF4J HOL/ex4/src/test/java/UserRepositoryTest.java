import static org.assertj.core.api.Assertions.assertThat;

import org.example.User;
import org.example.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;   // helper to seed data

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        entityManager.persist(new User(1L, "Alice"));
        entityManager.persist(new User(2L, "Bob"));
        entityManager.persist(new User(3L, "Alice"));   // duplicate name
        entityManager.flush();

        List<User> result = userRepository.findByName("Alice");

        assertThat(result).hasSize(2);
        assertThat(result).extracting(User::getName)
                .containsOnly("Alice");
    }
}