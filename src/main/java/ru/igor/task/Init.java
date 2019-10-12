package ru.igor.task;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.igor.task.model.User;
import ru.igor.task.repository.UserRepository;

import java.util.stream.IntStream;

@Component
public class Init implements InitializingBean {
    @Autowired
    UserRepository userRepository;

    private void generateUsers() {
        IntStream.range(1, 6).forEach(
                i -> userRepository.save(new User(i, "user" + i, new BCryptPasswordEncoder().encode("1"), "mail" + i + "@ya.ru", "Ivanov I." + i)));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        generateUsers();
    }
}
