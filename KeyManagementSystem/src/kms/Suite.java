package kms;

public class Suite extends Building{
	
	//Vars
	String name;
	String suiteCode;
	String buildingCode;
	
	//Constructor
	public Suite(String name, String suiteCode, String buildingCode) {
		
		if(name.length() == 0 || suiteCode.length() == 0 || suiteCode.length() == 0) {
			throw new RuntimeException("Name must have length > 0");
		}
			
		if (buildingCode.matches("[0-9]+") == false) {
			throw new RuntimeException("Building code must contain digits only");
		}
		
		if(buildingCode.length() != 2)
			throw new RuntimeException("Building code must contain 2 digits");
		
		if (suiteCode.matches("[0-9]+") == false) {
			throw new RuntimeException("Suite code must contain digits only");
		}
		
		if(suiteCode.length() != 2)
			throw new RuntimeException("Suite code must contain 2 digits");
		
		this.name = name;
		this.buildingCode = buildingCode;
		this.suiteCode = suiteCode;
		
	}
	
	public Suite() {
	}
	
	//Methods
	public String getName() {
		return name;
	}
	
	public String getSuiteCode() {
		return suiteCode;
	}
	
	public String getBuildingCode() {
		return buildingCode;
	}
	
	public static void main(String[] args) {

	}

}
