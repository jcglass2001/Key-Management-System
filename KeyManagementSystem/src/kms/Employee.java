package kms;

public class Employee {
	
	//Vars
	String name;
	String id;
	
	//Constructor 
	public Employee(String name, String id){
		if(name.length()==0)
			throw new RuntimeException("Name must have length > 0");
		if(id.length() != 4)
			throw new RuntimeException("ID must be contain 4 digits");
		
		this.name = name;
		this.id = id;
	}
	
	public Employee(String id){
	}
	
	public String getName(){
		return name;
	}
	
	public String getId() {
		return id;
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
