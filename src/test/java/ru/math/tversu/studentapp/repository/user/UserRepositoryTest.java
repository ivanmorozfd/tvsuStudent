package ru.math.tversu.studentapp.repository.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.math.tversu.studentapp.model.user.User;
import ru.math.tversu.studentapp.repository.user.UserRepository;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll() {
        List<User> all = userRepository.findAll();
    }
}