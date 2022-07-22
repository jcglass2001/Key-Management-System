package kms;

public class CompanyValidator {
	public static CompanyCodeStatus isNameValid(String name) {	
		//Checks for correct length of name
		if(name.length() == 0) {
			return new CompanyCodeStatus(name, false, "Name length must be greater than 0");
		}
		
		return new CompanyCodeStatus(name, true);
	}
	
	public static CompanyCodeStatus isBuildingValid(String code) {	
		//Checks for correct length of code
		if(code.length() != 2) {
			return new CompanyCodeStatus(code, false, "Building Code length must be 2");
		}
		
		// Check for all digits
		for(int i = 0; i < code.length(); i++) {
			if(!Character.isDigit(code.charAt(i))) {
				return new CompanyCodeStatus(code, false, "Building Code must only contain digits");
			}
		}
		return new CompanyCodeStatus(code, true);
	}
	
	public static CompanyCodeStatus isSuiteValid(String code) {
		//Checks for correct length of code
		if(code.length() != 2) {
			return new CompanyCodeStatus(code, false, "Suite Code length must be 2");
		}
		
		// Check for all digits
		for(int i = 0; i < code.length(); i++) {
			if(!Character.isDigit(code.charAt(i))) {
				return new CompanyCodeStatus(code, false, "Suite Code must only contain digits");
			}
		}
		return new CompanyCodeStatus(code, true);
	}
	
	public static CompanyCodeStatus isRoomValid(String code) {
		//Checks for correct length of code
		if(code.length() != 3) {
			return new CompanyCodeStatus(code, false, "Room Number length must be 3");
		}
		
		// Check for all digits
		for(int i = 0; i < code.length(); i++) {
			if(!Character.isDigit(code.charAt(i))) {
				return new CompanyCodeStatus(code, false, "Number must only contain digits");
			}
		}
		return new CompanyCodeStatus(code, true);
	}
	
	public static CompanyCodeStatus isEmployeeValid(String first, String middle, String last, String code) {
		//Checks for correct length of name
		if(first.length() == 0) {
			return new CompanyCodeStatus(first, false, "First name length must be greater than 0");
		}
		
		if(middle.length() == 0) {
			return new CompanyCodeStatus(middle, false, "Middle name length must be greater than 0");
		}
		
		if(last.length() == 0) {
			return new CompanyCodeStatus(last, false, "Last name length must be greater than 0");
		}
		
		//Checks for correct length of code
		if(code.length() != 4) {
			return new CompanyCodeStatus(code, false, "ID length must be 4");
		}
		
		// Check for all digits
		for(int i = 0; i < code.length(); i++) {
			if(!Character.isDigit(code.charAt(i))) {
				return new CompanyCodeStatus(code, false, "Number must only contain digits");
			}
		}
		return new CompanyCodeStatus(code, true);
	}	

}
