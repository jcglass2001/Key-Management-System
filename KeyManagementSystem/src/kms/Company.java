package kms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

	private String compName;
	
	// Lists
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Suite> suites = new ArrayList<Suite>();
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Employee> employees = new ArrayList<Employee>();

	// Constructors
	public Company() {

	}

	public Company(String name) {
		this.compName = name;
	}

	// File Writer
	public void writeToFile() {
		try {
			FileWriter myWriter = new FileWriter("Report.txt");
			//buildings
			for (int i = 0; i < buildings.size(); i++)
				myWriter.write("#" + buildings.get(i).getName() + "." + buildings.get(i).getCode() + "\n");

			//suites
			for (int i = 0; i < suites.size(); i++)
				myWriter.write("%" + suites.get(i).getName() + "." + suites.get(i).getSuiteCode()
						+ "," + suites.get(i).getBuildingCode() + "\n");

			//rooms
			for (int i = 0; i < rooms.size(); i++)
				myWriter.write("!" + rooms.get(i).getRoomNumber() + "."
						+ rooms.get(i).getSuiteCode() + "," + rooms.get(i).getBuildingCode() + "\n");

			//employees
			for (int i = 0; i < employees.size(); i++)
				myWriter.write("$" + employees.get(i).getName() + "." + employees.get(i).getId() + "\n");

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
  
  //File Reader
	public void buildFromFile(File file) {
		try {
			FileReader myReader = new FileReader(file);
			BufferedReader br = new BufferedReader(myReader);
			String currentLine = br.readLine();
			while (currentLine != null){
				//loop through characters in string
				for(int i = 0; i < currentLine.length(); i++) {
					
					//# represents new building
					if(currentLine.charAt(i) == '#') {
						String tempName = "";
						String tempCode = "";

						for(int j = i+1; j < currentLine.length(); j++) {
							char ch = currentLine.charAt(j);
							boolean periodEncountered = false;
							
							while(ch != '#' && ch != '%' && ch != '!' && ch != '$'  ) {
								if(ch == '.') periodEncountered = true;
								
								if(periodEncountered == true) {
									tempCode = tempCode + ch;
								}
								
								else tempName = tempName + ch;
							}
						}
						Building tempBuild = new Building(tempName, tempCode);
						buildings.add(tempBuild);
					}
					
					//% represents new suite
					if(currentLine.charAt(i) == '%') {
						String tempName = "";
						String tempCode = "";
						String tempBuild = "";
						
						for(int j = i+1; j < currentLine.length(); j++) {
							char ch = currentLine.charAt(j);
							boolean periodEncountered = false;
							boolean commaEncountered = false;
							
							while(ch != '#' && ch != '%' && ch != '!' && ch != '$'  ) {
								if(ch == '.') periodEncountered = true;
								if(ch == ',') commaEncountered = true;
								
								if(periodEncountered == true && commaEncountered == false) {
									tempCode = tempCode + ch;
								}
								
								if(periodEncountered == true && commaEncountered == true) {
									tempBuild = tempBuild + ch;
								}
								
								else tempName = tempName + ch;		
							}
						}
						Suite tempSuite = new Suite(tempName, tempCode, tempBuild);
						suites.add(tempSuite);
					}
					
					//! represents new room
					if(currentLine.charAt(i) == '!') {
						String tempNum = "";
						String tempSuite = "";
						String tempBuild = "";
						
						for(int j = i+1; j < currentLine.length(); j++) {
							char ch = currentLine.charAt(j);
							boolean periodEncountered = false;
							boolean commaEncountered = false;
							
							while(ch != '#' && ch != '%' && ch != '!' && ch != '$'  ) {
								if(ch == '.') periodEncountered = true;
								if(ch == ',') commaEncountered = true;
								
								if(periodEncountered == true && commaEncountered == false) {
									tempSuite = tempSuite + ch;
								}
								
								if(periodEncountered == true && commaEncountered == true) {
									tempBuild = tempBuild + ch;
								}
								
								else tempNum = tempNum + ch;
							}
						}
						Room tempRoom = new Room(tempBuild, tempSuite, tempNum);
						rooms.add(tempRoom);
					}
					
					//$ represents new employee
					if(currentLine.charAt(i) == '$') {
						String tempName = "";
						String tempID = "";
						
						for(int j = i+1; j < currentLine.length(); j++) {
							char ch = currentLine.charAt(j);
							boolean periodEncountered = false;
							
							while(ch != '#' && ch != '%' && ch != '!' && ch != '$'  ) {
								if(ch == '.') periodEncountered = true;
								
								if(periodEncountered == true) {
									tempID = tempID + ch;
								}
								
								else tempName = tempName + ch;
							}
						}
						Employee tempEmp = new Employee(tempName, tempID);
						employees.add(tempEmp);
					}
					
				}
				
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		
	}

	// Getters
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

	public String printReportA() {
		String report = "";
		for (int i = 0; i < employees.size(); i++) {
			String addition = (employees.get(i).getName() + ", ID= " + employees.get(i).getId() + "\n");
			report += addition;
		}
		return report;
	}

	public String printReportD() {
		String report = "";
		for (int i = 0; i < buildings.size(); i++) {
			String addition = (buildings.get(i).getName() + " Building (" + buildings.get(i).getCode() + ")\n");
			report += addition;
		}
		return report;
	}

}
