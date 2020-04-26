package webappcarrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webappcarrito.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role findByCode(String code);

}
