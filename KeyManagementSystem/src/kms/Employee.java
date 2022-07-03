package kms;

public class Employee {
	
	String name;
	int id;
	
	//constructor 
	public Employee(String name, int id){
		if(name.length()==0)
			throw new RuntimeException("Name must have length >0");
		if(id < 1000 || id > 9999)
			throw new RuntimeException("ID must be inbetween 1000-9999");
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
