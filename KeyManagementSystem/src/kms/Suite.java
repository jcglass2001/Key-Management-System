package kms;

import java.util.ArrayList;

public class Suite extends Building{
	
	//Vars
	private String name;
	private String suiteCode;
	private String buildingCode;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	//Constructors
	public Suite(String name, String buildingCode, String suiteCode) {
		
		if(name.length() == 0) {
			throw new IllegalArgumentException("Name can't be empty");
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
	
	public Suite(String suiteCode) {
	}
	
	public Suite() {
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public String getBuildingCode() {
		return buildingCode;
	}
	
	public String getSuiteCode() {
		return suiteCode;
	}
	
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public void addRoom(Room r){
		rooms.add(r);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Suite) {
			Suite s = (Suite)o;
			if(this.suiteCode.equals(s.suiteCode)) {
				return true;
			}
		}
		return false;
	}

}
