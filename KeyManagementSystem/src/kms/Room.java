package kms;

public class Room extends Suite{
	
	//Vars
	String buildingCode;
	String suiteCode;
	String roomNumber;
	
	//Constructor
	public Room(String buildingCode, String suiteCode, String roomNumber) {
		
		if(buildingCode.length() != 2)
			throw new RuntimeException("buildingCode must contain 2 digits");
		this.buildingCode = buildingCode;
		
		if(suiteCode.length() != 2)
			throw new RuntimeException("suiteCode must contain 2 digits");
		this.suiteCode = suiteCode;
		
		if(roomNumber.length() != 3)
			throw new RuntimeException("roomNumber must contain 3 digits");
		this.roomNumber = roomNumber;
	}
	
	//Methods
	public String getBuildingCode() {
		return buildingCode;
	}
	
	public String getSuiteCode() {
		return suiteCode;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
