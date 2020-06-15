package webappcarrito.commons.validators;

import webappcarrito.dtos.UserDTO;

public class UserValidator {
	
	public static void userDTOValidator(UserDTO userDTO) throws Exception{
		
		if(userDTO.getName()==null || userDTO.getName().length() < 1 || userDTO.getName().length() > 30
				|| !userDTO.getName().matches("^[A-Za-z]*$")) {
			
			throw new Exception("Invalid name");
			
		}
		
		if(userDTO.getSurname()==null || userDTO.getSurname().length() < 1 || userDTO.getSurname().length() > 30
				|| !userDTO.getSurname().matches("^[A-Za-z]*$")) {
			
			throw new Exception("Invalid surname");
			
		}
		
		if(userDTO.getRoleCode() == null || userDTO.getRoleCode().length() != 3) {
			
			throw new Exception("Role code doesn't exist");
			
		}
		
		if(userDTO.getCi()==null || userDTO.getCi().length() < 6 || userDTO.getCi().length() > 30 
				|| !userDTO.getCi().matches("^[0-9]*$")) {
			
			throw new Exception("Invalid c.i.");
			
		}
		
		if(userDTO.getPhone().length() < 10 || userDTO.getPhone().length() > 30) {
			
			throw new Exception("Invalid phone");
			
		}
		
		if(userDTO.getAddress()==null || userDTO.getAddress().length() < 5 || userDTO.getAddress().length() > 100) {
			
			throw new Exception("Invalid address");

		}
		
		if(userDTO.getMail()==null || 
				!userDTO.getMail().matches("^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
			
			throw new Exception("Invalid mail");
			
		}
		
		if(userDTO.getPassword()==null || userDTO.getPassword().length() < 8 || userDTO.getPassword().length() > 30) {
			
			throw new Exception("Invalid pasword");
			
		}

	}

}
