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

import webappcarrito.commons.validators.RoleValidator;
import webappcarrito.dtos.RoleDTO;
import webappcarrito.entities.Role;
import webappcarrito.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Role create(@RequestBody RoleDTO newRole) {
		
		try {
			RoleValidator.roleDTOValidator(newRole);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
		
		Role response = roleService.create(newRole); 
		
		return response;
		
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Role read(@RequestParam(value = "id") Integer id) {
		
		Role response = roleService.findByID(id);
		
		return response;
		
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public List<Role> findAll(){
		
		List<Role> response = roleService.findAll();
		
		return response;
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public Role update(@RequestParam(value = "id") Integer id, @RequestBody RoleDTO updatedRole) {
		
		try {
			RoleValidator.roleDTOValidator(updatedRole);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
		
		Role response = roleService.update(id, updatedRole);
		
		return response;
	}

}
