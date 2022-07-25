package kms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CompanyPersistence {
	public static CompanyManager buildCompanyManager() {
		// Code to read Blobs from text file and create BlobManager
		// ...
		return new CompanyManager();
	}
	
	public void saveCompany(CompanyManager companyManager) {
		try {
			FileWriter myWriter = new FileWriter("Report.txt");
			myWriter.write("Buildings: \n");
			for (int i = 0; i < companyManager.buildings.size(); i++)
				myWriter.write("Building #" + companyManager.buildings.get(i).getBuildingCode() + ": " + companyManager.buildings.get(i).getName() + "\n");

			myWriter.write("\nSuites: \n");
			for (int i = 0; i < companyManager.suites.size(); i++)
				myWriter.write("Suite #" + companyManager.suites.get(i).getSuiteCode() + ": " + companyManager.suites.get(i).getName()
						+ " belongs to building: #" + companyManager.suites.get(i).getBuildingCode() + "\n");

			myWriter.write("\nRooms: \n");
			for (int i = 0; i < companyManager.rooms.size(); i++)
				myWriter.write("Room #" + companyManager.rooms.get(i).getRoomNumber() + " found in suite: #"
						+ companyManager.rooms.get(i).getSuiteCode() + "\n");

			myWriter.write("\nEmployees: \n");
			for (int i = 0; i < companyManager.employees.size(); i++)
				myWriter.write("Employee #" + companyManager.employees.get(i).getId() + ": " + companyManager.employees.get(i).getName() + "\n");

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	//File Reader
		public void buildFromFile(File file, CompanyManager companyManager) {
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()){
					String currentLine = scan.nextLine();
					//loop through characters in string
					for(int i = 0; i < currentLine.length(); i++) {
						
						//# represents new building
						if(currentLine.charAt(i) == '#') {
							String tempName = "";
							String tempCode = "";

							for(int j = i+1; j < currentLine.length(); j++) {
								char ch = currentLine.charAt(j);
								boolean periodEncountered = false;
								if(ch == '.') periodEncountered = true;
									
								if(periodEncountered == true) {
									tempCode = tempCode + ch;
								}
									
								else tempName = tempName + ch;
							}
							Building tempBuild = new Building(tempName, tempCode);
							companyManager.buildings.add(tempBuild);
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
							Suite tempSuite = new Suite(tempName, tempCode, tempBuild);
							companyManager.suites.add(tempSuite);
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
							Room tempRoom = new Room(tempBuild, tempSuite, tempNum);
							companyManager.rooms.add(tempRoom);
						}
						
						//$ represents new employee
						if(currentLine.charAt(i) == '$') {
							String tempName = "";
							String tempID = "";
							
							for(int j = i+1; j < currentLine.length(); j++) {
								char ch = currentLine.charAt(j);
								boolean periodEncountered = false;
								
								if(ch == '.') periodEncountered = true;
									
								if(periodEncountered == true) {
									tempID = tempID + ch;
								}
									
								else tempName = tempName + ch;
							}
							Employee tempEmp = new Employee(tempName, tempID);
							companyManager.employees.add(tempEmp);
						}	
					}
				}
				scan.close();
			} catch (IOException e) {
				System.out.println("An error occured.");
				e.printStackTrace();
			}
			
		}
	
	public static String printReportA(CompanyManager companyManager) {
		String report = "";
		for (int i = 0; i < companyManager.employees.size(); i++) {
			String addition = (companyManager.employees.get(i).getName() + ", ID= " + companyManager.employees.get(i).getId() + "\n");
			report += addition;
		}
		return report;
	}

	public static String printReportD(CompanyManager companyManager) {
		String report = "";
		for (int i = 0; i < companyManager.buildings.size(); i++) {
			String addition = (companyManager.buildings.get(i).getName() + " Building (" + companyManager.buildings.get(i).getBuildingCode() + ")\n");
			report += addition;
		}
		return report;
	}
}
