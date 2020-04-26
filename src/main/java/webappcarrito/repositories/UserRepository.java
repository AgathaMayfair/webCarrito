package webappcarrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webappcarrito.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	


}
