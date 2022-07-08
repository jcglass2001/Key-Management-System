package kms;

public class Employee {
	
	String name;
	String id;
	
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
	
	public void getAccess() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
