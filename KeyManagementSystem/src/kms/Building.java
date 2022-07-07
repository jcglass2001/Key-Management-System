package kms;

public class Building {
	
	private String name;
	private String code;
	
	public Building(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	//Code must be only 2 digits
	public String getCode() {
		
		if (code.matches("[0-9]+") == false) {
			return "Building code must only contain digits";
		}
		else if (code.length() != 2) {
			return "Building code must be exactly 2 digits";
		}
		return code;
	}
	
}
