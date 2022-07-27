package kms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	//Vars
	String name;
	String id;
	
	//Lists
	ArrayList<Building> buildingAccess = new ArrayList<Building>();
	ArrayList<Suite> suiteAccess = new ArrayList<Suite>();
	ArrayList<Room> roomAccess = new ArrayList<Room>();
	
	//constructor 
	public Employee(String name, String id){
		if(name.length()==0)
			throw new RuntimeException("Name must have length >0");
		if(id.length() != 4)
			throw new RuntimeException("ID must be contain 4 digits");
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	
	//add access methods
	public void addBuildingAccess(Building building) {
		buildingAccess.add(building);
	}
	
	public void addSuiteAccess(Suite suite) {
		suiteAccess.add(suite);
	}

	public void addRoomAccess(Room room) {
		roomAccess.add(room);
	}
	
	//remove access methods
	public void removeBuildingAccess(Building building) {
		buildingAccess.remove(building);
	}
	
	public void removeSuiteAccess(Suite suite) {
		suiteAccess.remove(suite);
	}

	public void removeRoomAccess(Room room) {
		roomAccess.remove(room);
	}
	
	//get access methods
	public ArrayList<Building> getBuildingAccess() {
		return buildingAccess;
	}
	
	public ArrayList<Suite> getSuiteAccess() {
		return suiteAccess;
	}
	
	public ArrayList<Room> getRoomAccess() {
		return roomAccess;
	}
	
	public ArrayList<Room> getFullAccess(){
		Set<Room> fullAccessSet = new HashSet<Room>();
		
		//adding from building access
		for(int i = 0; i < buildingAccess.size(); i++) {
			for(int j = 0; j < buildingAccess.get(i).getSuites().size(); i++) {
				for(int k = 0; k < buildingAccess.get(i).getSuites().get(j).getRooms().size(); k++) {
					fullAccessSet.add(buildingAccess.get(i).getSuites().get(j).getRooms().get(k));
				}
			}
		}
		
		//adding from suite access
		for(int i = 0; i <suiteAccess.size(); i++) {
			for(int j = 0; j < suiteAccess.get(i).getRooms().size(); j++) {
				fullAccessSet.add(suiteAccess.get(i).getRooms().get(j));
			}
		}
		
		//adding from room access
		for(int i = 0; i < roomAccess.size(); i++) {
			fullAccessSet.add(roomAccess.get(i));
		}
		
		ArrayList<Room> fullAccessList = new ArrayList<Room>(fullAccessSet); 
		return fullAccessList;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee) {
			Employee e = (Employee)o;
			if(this.id.equals(e.id)) {
				return true;
			}
		}
		return false;
	}
}


