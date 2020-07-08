package webappcarrito.commons.validators;

import webappcarrito.dtos.RoleDTO;

public class RoleValidator {
	
	public static void roleDTOValidator(RoleDTO roleDTO) throws Exception{
		
		if(roleDTO.getNameOfRole()==null || roleDTO.getNameOfRole().length()<1 || roleDTO.getNameOfRole().length()>30
				|| !roleDTO.getNameOfRole().matches("^[ A-Za-z0-9]*$")) {
			
			throw new Exception("Invalid name");
			
		}
		
		if(roleDTO.getCode()==null || roleDTO.getCode().length()!=3 || !roleDTO.getCode().matches("^[A-Za-z0-9]*$")) {
			
			throw new Exception("Invalid code");
			
		}
		
	}

}
