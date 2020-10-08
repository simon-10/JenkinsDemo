package com.jenkins.demojenkins;

import com.jenkins.demojenkins.domain.User;
import com.jenkins.demojenkins.repository.UserRepository;
import com.jenkins.demojenkins.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoJenkinsApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest(){
		when(userRepository.findAll()).thenReturn(Arrays.asList(
				new User(9,"TestName",9, "TestAddress1"),
				new User(99,"TestName",99, "TestAddress2")
		));

		assertEquals(2,userService.getUsers().size());
	}





	@Test
	void contextLoads() {
	}

}
