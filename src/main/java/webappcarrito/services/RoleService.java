package webappcarrito.services;

import java.util.List;

import webappcarrito.dtos.RoleDTO;
import webappcarrito.entities.Role;

public interface RoleService {
	
	public Role create(RoleDTO roleDTO);
	
	public Role findByID(Integer id);
	
	public List<Role> findAll();
	
	public Role update(Integer id, RoleDTO updatedRole);

}
