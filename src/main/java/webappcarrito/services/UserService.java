package webappcarrito.services;

import java.util.List;

import webappcarrito.dtos.UserDTO;
import webappcarrito.entities.User;

public interface UserService {
	
	public User create(UserDTO user);
	
	public User findByID(Integer id);
	
	public List<User> findAll();
	
	public User update(Integer id, UserDTO updatedUser);

}
