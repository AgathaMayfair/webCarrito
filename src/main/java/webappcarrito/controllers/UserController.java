package webappcarrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import webappcarrito.commons.validators.UserValidator;
import webappcarrito.dtos.UserDTO;
import webappcarrito.entities.User;
import webappcarrito.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User create(@RequestBody UserDTO newUser) {
		
		try {
			UserValidator.userDTOValidator(newUser);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
		
		User response = userService.create(newUser);
		
		return response;
		
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public User read(@RequestParam(value = "id") Integer id) {
		
		User response = userService.findByID(id);
		
		return response;
		
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<User> findAll(){
		
		List<User> response = userService.findAll();
		
		return response;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User update(@RequestParam(value = "id") Integer id, @RequestBody UserDTO updatedUser) {
		
		try {
			UserValidator.userDTOValidator(updatedUser);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
		
		User response = userService.update(id, updatedUser);
		
		return response;
	}

}
