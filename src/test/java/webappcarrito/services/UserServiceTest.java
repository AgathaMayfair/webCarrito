package webappcarrito.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import webappcarrito.dtos.UserDTO;
import webappcarrito.entities.Role;
import webappcarrito.entities.User;
import webappcarrito.repositories.RoleRepository;
import webappcarrito.repositories.UserRepository;
import webappcarrito.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
//	@Before
//	public void createMocks() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void existingUserTest() {
		
		User user = new User("Fulano", "DeTal", "51222333", null, "Av.1, 1-a", "fulanito@hotmail.com", "12345678");
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(anyInt())).thenReturn(optionalUser);
		
		User responseUser = userService.findByID(5);
		assertEquals("Fulano", responseUser.getName());
		
	}
	
	@Test
	public void createUserTest() {
		
		Role role = new Role("Administrative", "ADM", null);
		when(roleRepository.findByCode("ADM")).thenReturn(role);
		User user = new User("Fulano", "DeTal", "51222333", null, "Av.1, 1-a", "fulanito@hotmail.com", "12345678");
		when(userRepository.save(Mockito.any())).thenReturn(user); 
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Fulano");
		userDTO.setSurname("DeTal");
		userDTO.setCi("51222333");
		userDTO.setPhone(null);
		userDTO.setAddress("Av.1, 1-a");
		userDTO.setMail("fulanito@hotmail.com");
		userDTO.setPassword("12345678");
		userDTO.setRoleCode("ADM");

		User responseUser = userService.create(userDTO);
		assertEquals("Fulano", responseUser.getName());
		
	}

}
