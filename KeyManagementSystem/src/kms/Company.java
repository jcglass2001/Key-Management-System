package kms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

	//Lists
	static ArrayList<Building> buildings = new ArrayList<Building>();
	static ArrayList<Suite> suites = new ArrayList<Suite>();
	static ArrayList<Room> rooms = new ArrayList<Room>();
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	
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
	
	public static void main(String[] args) {
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "12", "01");
		Suite s2 = new Suite("Lounge", "05", "01");
		Room r1 = new Room("01", "12", "432");
		Room r2 = new Room("01", "05", "387");
		Room r3 = new Room("01", "12", "947");
		Room r4 = new Room("01", "05", "327");
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Markus", "5678");
		Employee e3 = new Employee("Sarah", "1278");
		buildings.add(b);
		suites.add(s1);
		suites.add(s2);
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		WriteToFile();

	}

}
