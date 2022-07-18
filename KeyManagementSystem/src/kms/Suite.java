package kms;

import java.util.ArrayList;

public class Suite extends Building{
	
	//Vars
	private String name;
	private String suiteCode;
	private String buildingCode;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	//Constructor
	public Suite(String name, String suiteCode, String buildingCode) {
		
		if(name.length() == 0 || suiteCode.length() == 0 || suiteCode.length() == 0) {
			throw new IllegalArgumentException("Name must have length > 0");
		}
			
		if (buildingCode.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Building code must contain digits only");
		}
		
		if(buildingCode.length() != 2)
			throw new IllegalArgumentException("Building code must contain 2 digits");
		
		if (suiteCode.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Suite code must contain digits only");
		}
		
		if(suiteCode.length() != 2)
			throw new IllegalArgumentException("Suite code must contain 2 digits");
		
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
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public static void main(String[] args) {

	}

}
