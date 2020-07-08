package webappcarrito.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webappcarrito.dtos.RoleDTO;
import webappcarrito.entities.Role;
import webappcarrito.repositories.RoleRepository;
import webappcarrito.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role create(RoleDTO roleDTO) {
		
		Role role = new Role();
		
		role.setNameOfRole(roleDTO.getNameOfRole());
		role.setCode(roleDTO.getCode());
		role.setDescription(roleDTO.getDescription());
		
		Role roleCreated = roleRepository.save(role);
		
		return roleCreated;
	}

	@Override
	public Role findByID(Integer id) {
		
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role update(Integer id, RoleDTO updatedRole) {
		
		Role role = findByID(id);
		
		role.setNameOfRole(updatedRole.getNameOfRole());
		role.setCode(updatedRole.getCode());
		role.setDescription(updatedRole.getDescription());
		
		return roleRepository.save(role);

	}

}
