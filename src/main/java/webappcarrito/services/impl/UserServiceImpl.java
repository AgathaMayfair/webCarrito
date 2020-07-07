package webappcarrito.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webappcarrito.dtos.UserDTO;
import webappcarrito.entities.Role;
import webappcarrito.entities.User;
import webappcarrito.repositories.RoleRepository;
import webappcarrito.repositories.UserRepository;
import webappcarrito.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User create(UserDTO userDTO) {
		
		User user = new User();
	
		Role role = roleRepository.findByCode(userDTO.getRoleCode());
		
		user.setRole(role);
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setCi(userDTO.getCi());
		user.setPhone(userDTO.getPhone());
		user.setAddress(userDTO.getAddress());
		user.setMail(userDTO.getMail());
		user.setPassword(userDTO.getPassword());
		
		User userCreated = userRepository.save(user);

		return userCreated;
	}

	@Override
	public User findByID(Integer id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User update(Integer id, UserDTO updatedUser) {
		
		User user = findByID(id);
		
		if(!(user.getRole().getCode().equals(updatedUser.getRoleCode()))) {
			Role role = roleRepository.findByCode(updatedUser.getRoleCode());
			user.setRole(role);			
		}
		
		user.setName(updatedUser.getName());
		user.setSurname(updatedUser.getSurname());
		user.setCi(updatedUser.getCi());
		user.setPhone(updatedUser.getPhone());
		user.setAddress(updatedUser.getAddress());
		user.setMail(updatedUser.getMail());
		user.setPassword(updatedUser.getPassword());
				
		return userRepository.save(user);
		
	}

}
