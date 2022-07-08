package kms;

import java.util.ArrayList;

public class Employee {
	
	String name;
	String id;
	ArrayList<String> buildingAccess = new ArrayList<String>();
	ArrayList<String> suiteAccess = new ArrayList<String>();
	ArrayList<String> roomAccess = new ArrayList<String>();
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
