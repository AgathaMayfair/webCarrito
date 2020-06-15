package webappcarrito.controllers;

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

}
