package kms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

	//Lists
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Suite> suites = new ArrayList<Suite>();
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	//File Writer
	public static void WriteToFile() {
		try {
		      FileWriter myWriter = new FileWriter("Report.txt");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	public static void main(String[] args) {
		WriteToFile();

	}

}
