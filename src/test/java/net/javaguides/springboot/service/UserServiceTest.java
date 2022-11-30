package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    UserRepository userRepository;


    @Test
    void findByEmailFoundTest(){
        Optional<User> userParam = Optional.of(new User("AHmed","Mohamed", "l@l.com" ));
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userParam);
        Optional<User> user = userService.findByEmail("a@a.com");
        Assertions.assertEquals(true, user.isPresent());
        Assertions.assertEquals("l@l.com", user.get().getEmail());

    }
}
