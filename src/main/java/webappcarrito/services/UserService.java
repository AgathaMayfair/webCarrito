package webappcarrito.services;

import webappcarrito.dtos.UserDTO;
import webappcarrito.entities.User;

public interface UserService {
	
	public User create(UserDTO user);
	
	public User findByID(Integer id);
	

}
