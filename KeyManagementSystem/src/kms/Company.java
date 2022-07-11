package kms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

	private String compName;
	//Lists
	static ArrayList<Building> buildings = new ArrayList<Building>();
	static ArrayList<Suite> suites = new ArrayList<Suite>();
	static ArrayList<Room> rooms = new ArrayList<Room>();
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	//Constructors
	public Company() {
		
	}
	public Company(String name) {
		this.compName = name;
	}
	
	//File Writer
	public static void WriteToFile() {
		try {
		      FileWriter myWriter = new FileWriter("Report.txt");
		      myWriter.write("Buildings: \n");
		      for(int i = 0; i < buildings.size(); i++)
		    	  myWriter.write("Building #" + buildings.get(i).getCode() + ": " + buildings.get(i).getName() + "\n");
		      
		      myWriter.write("\nSuites: \n");
		      for(int i = 0; i < suites.size(); i++)
		    	  myWriter.write("Suite #" + suites.get(i).getSuiteCode() + ": " + suites.get(i).getName() + 
		    			  " belongs to building: #" + suites.get(i).getBuildingCode() + "\n");
		      
		      myWriter.write("\nRooms: \n");
		      for(int i = 0; i < rooms.size(); i++)
		    	  myWriter.write("Room #" + rooms.get(i).getRoomNumber() + 
		    			  " found in suite: #" + rooms.get(i).getSuiteCode() + "\n");
		      
		      myWriter.write("\nEmployees: \n");
		      for(int i = 0; i < employees.size(); i++)
		    	  myWriter.write("Employee #" + employees.get(i).getId() + ": " + employees.get(i).getName() + "\n");
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	//Getters
	public ArrayList<Building> getBuildings() {
	    return buildings;
	}
	public ArrayList<Suite> getSuites() {
	    return suites;
	}
	public ArrayList<Room> getRooms() {
	    return rooms;
	}
	public ArrayList<Employee> getEmployees() {
	    return employees;
	}
	
	public static void main(String[] args) {

	}

}
