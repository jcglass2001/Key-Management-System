package kms;

public class Room extends Suite{
	
	//Vars
	private String buildingCode;
	private String suiteCode;
	private String roomNumber;
	
	//Constructors
	public Room(String buildingCode, String suiteCode, String roomNumber) {
		if(buildingCode.length() != 2)
			throw new RuntimeException("Building code must contain 2 digits");
		
		if (buildingCode.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Building code must contain digits only");
		}
		
		if(suiteCode.length() != 2)
			throw new RuntimeException("Suite code must contain 2 digits");
		
		if (suiteCode.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Building code must contain digits only");
		}
		
		if (roomNumber.matches("[0-9]+") == false) {
			throw new IllegalArgumentException("Room number must contain digits only");
		}
		
		if(roomNumber.length() != 3)
			throw new RuntimeException("Roomn number must contain 3 digits");
		
		this.buildingCode = buildingCode;
		this.suiteCode = suiteCode;
		this.roomNumber = roomNumber;
	}
	
	public Room(String roomNumber) {
	}
	
	public Room() {
	}
	
	//Getters
	public String getBuildingCode() {
		return buildingCode;
	}
	
	public String getSuiteCode() {
		return suiteCode;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Room) {
			Room r = (Room)o;
			if(this.roomNumber.equals(r.roomNumber)) {
				return true;
			}
		}
		return false;
	}

}
