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
import static org.mockito.Mockito.*;

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
	public void getUserByAddressTest() {
		String address="Mendefera";
		when(userRepository.findByAddress(address)).thenReturn(Arrays.asList(
				new User(99,"TestName",99, "TestMendefera"))
		);

		assertEquals(1, userService.getUserByAddress(address).size());

	}

	@Test
	public void addUserTest(){
		User user=new User(999, "TestName", 999, "TestAddressAdd");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.addUser(user));
		verify(userRepository).save(user);
	}

	@Test
	public void deleteUserTest(){
		User user=new User(9999, "TestName", 9999, "TestAddressDelete");
		userService.deleteUser(user);
		verify(userRepository, times(1)).delete(user);
		//verify(userRepository,times(2)).delete(user);
	}

}
