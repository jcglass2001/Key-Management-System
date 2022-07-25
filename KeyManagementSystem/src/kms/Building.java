package kms;

import java.util.ArrayList;

public class Building {
	
	//Vars
	private String name;
	private String buildingCode;
	private ArrayList<Suite> suites = new ArrayList<Suite>();
	
	//Constructors
	public Building(String name, String buildingCode) {
		if(name.length() == 0) {
			throw new IllegalArgumentException("Name can't be empty");
		}
		
		if (buildingCode.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Building code must contain digits only");
		}
		
		if(buildingCode.length() != 2)
			throw new IllegalArgumentException("Building code must contain 2 digits");
		
		this.name = name;
		this.buildingCode = buildingCode;
	}
	
	public Building(String buildingCode) {
	}
	
	public Building() {
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public String getBuildingCode() {
		return buildingCode;
	}
	
	public ArrayList<Suite> getSuites(){
		return suites;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Building) {
			Building b = (Building)o;
			if(this.buildingCode.equals(b.buildingCode)) {
				return true;
			}
		}
		return false;
	}
	
}
