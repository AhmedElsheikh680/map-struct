package net.javaguides.springboot;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringbootCrudRestfulWebservicesApplicationTests {

	@Autowired
	private UserService userService;
//	@Test
//	void contextLoads() {
//	}


	@Test
	void findByEmailNotFoundTest(){
		Optional<User> user = userService.findByEmail("Email@a.com");
		Assertions.assertEquals(false, user.isPresent());
	}

	@Test
	void findByEmailFoundTest(){
		Optional<User> user = userService.findByEmail("a@a.com");
		Assertions.assertEquals(true, user.isPresent());
		Assertions.assertEquals("a@a.com", user.get().getEmail());
	}
}
