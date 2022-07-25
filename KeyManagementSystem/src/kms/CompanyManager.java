package kms;

import java.util.ArrayList;

public class CompanyManager {
	
	//Lists
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Suite> suites = new ArrayList<Suite>();
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	//Access Lists
	ArrayList<String> buildingAccess = new ArrayList<String>();
	ArrayList<String> suiteAccess = new ArrayList<String>();
	ArrayList<String> roomAccess = new ArrayList<String>();
	
	//Constructor
	public CompanyManager() {}
	
	//Adders
	public void addBuilding(Building b) {
		buildings.add(b);
	}
	
	public void addSuite(Suite s) {
		suites.add(s);
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public void addAccess(String type, String code) {
		if(type.equals("building")) {
			buildingAccess.add(code);
		}
		if(type.equals("suite")) {
			suiteAccess.add(code);
		}
		if(type.equals("room")) {
			roomAccess.add(code);
		}
	}
	
	//Removers
	public void remBuilding(Building b) {
		buildings.remove(b);
	}
	
	public void remSuite(Suite s) {
		suites.remove(s);
	}
	
	public void remRoom(Room r) {
		rooms.remove(r);
	}
	
	public void remEmployee(Employee e) {
		employees.remove(e);
	}
	
	//Getters
	public int getNumBuildings() {
		return buildings.size();
	}
	
	public int getNumSuites() {
		return suites.size();
	}
	
	public int getNumRooms() {
		return rooms.size();
	}
	
	public int getNumEmployees() {
		return employees.size();
	}
	
	public Building getBuilding(int i) {
		if(i>=0 && i<buildings.size()) {
			return buildings.get(i);
		}
		return null;
	}
	
	public Suite getSuite(int i) {
		if(i>=0 && i<suites.size()) {
			return suites.get(i);
		}
		return null;
	}
	
	public Room getRoom(int i) {
		if(i>=0 && i<rooms.size()) {
			return rooms.get(i);
		}
		return null;
	}
	
	public Employee getEmployee(int i) {
		if(i>=0 && i<employees.size()) {
			return employees.get(i);
		}
		return null;
	}
	
	public String[][] getAccess() {
		int buildings = buildingAccess.size();
		int suites = suiteAccess.size();
		int rooms = roomAccess.size();
		int listSize = Math.max(rooms, Math.max(suites, buildings));
		
		//building = [0][x] suites = [1][x] rooms = [2][x]
		String[][] accessList = new String[3][listSize];
		
		for(int i = 0; i < buildings; i++) {
			accessList[0][i] = buildingAccess.get(i);
		}
		for(int i = 0; i < suites; i++) {
			accessList[1][i] = suiteAccess.get(i);
		}
		for(int i = 0; i < rooms; i++) {
			accessList[2][i] = roomAccess.get(i);
		}
		return accessList;
	}
	
	
	//Clear and Contains
	public void clear() {
		buildings.clear();
		suites.clear();
		rooms.clear();
		employees.clear();
	}
	
	public boolean containsBuilding(String name, String buildingCode) {
		return buildings.contains(new Building(name, buildingCode));
	}
	
	public boolean containsSuite(String name, String buildingCode, String suiteCode) {
		return suites.contains(new Suite(name, buildingCode, suiteCode));
	}
	
	public boolean containsRoom(String buildingCode, String suiteCode, String roomNumber) {
		return rooms.contains(new Room(buildingCode, suiteCode, roomNumber));
	}
	
	public boolean containsEmployee(String name, String id) {
		return employees.contains(new Employee(name, id));
	}


}
