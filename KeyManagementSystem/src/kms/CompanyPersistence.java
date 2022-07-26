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
	

	//Save to text file
	public static void saveCompany(CompanyManager companyManager) {
		try {
			FileWriter myWriter = new FileWriter("Report.txt");

			//buildings
			for (int i = 0; i < companyManager.buildings.size(); i++)
				myWriter.write("#" + companyManager.buildings.get(i).getName() + "-" + companyManager.buildings.get(i).getBuildingCode() + "\n");

			//suites
			for (int i = 0; i < companyManager.suites.size(); i++)
				myWriter.write("%" + companyManager.suites.get(i).getName() + "-" + companyManager.suites.get(i).getSuiteCode()
						+ "-" + companyManager.suites.get(i).getBuildingCode() + "\n");

			//rooms
			for (int i = 0; i < companyManager.rooms.size(); i++)
				myWriter.write("!" + companyManager.rooms.get(i).getRoomNumber() + "-"
						+ companyManager.rooms.get(i).getSuiteCode() + "-" + companyManager.rooms.get(i).getBuildingCode() +"\n");

			//employees
			for (int i = 0; i < companyManager.employees.size(); i++)
				myWriter.write("$" + companyManager.employees.get(i).getName() + "-" + companyManager.employees.get(i).getId() + "\n");

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
				
					//# represents new building
					if(currentLine.charAt(0) == '#') {
						String lineData = currentLine.substring(1);
						String[] components = lineData.split("-");
						String tempName = components[0];
						String tempCode = components[1];
							
						Building tempBuild = new Building(tempName, tempCode);
						companyManager.addBuilding(tempBuild);;
					}
						
					//% represents new suite
					if(currentLine.charAt(0) == '%') {
						String lineData = currentLine.substring(1);
						String[] components = lineData.split("-");
						String tempName = components[0];
						String tempCode = components[1];
						String tempBuild = components[2];
							
						Suite tempSuite = new Suite(tempName, tempCode, tempBuild);
						companyManager.addSuite(tempSuite);;
					}
						
					//! represents new room
					if(currentLine.charAt(0) == '!') {
						String lineData = currentLine.substring(1);
						String[] components = lineData.split("-");
						String tempNum = components[0];
						String tempSuite = components[1];
						String tempBuild = components[2];
								
						Room tempRoom = new Room(tempBuild, tempSuite, tempNum);
						companyManager.addRoom(tempRoom);
					}
						
					//$ represents new employee
					if(currentLine.charAt(0) == '$') {
						String lineData = currentLine.substring(1);
						String[] components = lineData.split("-");
						String tempName = components[0];
						String tempID = components[1];

						Employee tempEmp = new Employee(tempName, tempID);
						companyManager.addEmployee(tempEmp);
					}	
				}
				scan.close();
			} catch (IOException e) {
				System.out.println("An error occured.");
				e.printStackTrace();
			}
			
		}
	
  
  //Reports
	public static String printReportA(CompanyManager companyManager) {
		String report = "";
		for (int i = 0; i < companyManager.employees.size(); i++) {
			String addition = (companyManager.employees.get(i).getName() + ", ID= " + companyManager.employees.get(i).getId() + "\n");
			report += addition;
		}
		return report;
	}
	
	public static String printReportB(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportC(CompanyManager companyManager) {
		String report = "";
		
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
	
	public static String printReportE(CompanyManager companyManager, String buildingCode) {
		String report = "";
        //grab building
        Building b = companyManager.getBuildingByCode(buildingCode);
        //print building
        report += String.format("Building: %s(%s)", b.getName(),b.getBuildingCode());
        //loop through suites list in building
        for(Suite s: b.getSuites()) {
            //print suites
            report += String.format("\t\tSuite: %s(%s)", s.getName(),s.getSuiteCode());
            //loop through and print all rooms in suite
            for(Room r: s.getRooms()) {
                //print rooms
                report += String.format("\t\t\tRoom: %s", r.getRoomNumber());
            }
        }
		
        return report;
	}
	
	public static String printReportF(CompanyManager companyManager, String buildingCode, String suiteCode) {
		String report = "";
		for(int i = 0; i < companyManager.rooms.size(); i++) {
			if(companyManager.getRoom(i).getBuildingCode().equals(buildingCode) && companyManager.getRoom(i).getSuiteCode().equals(suiteCode)) {
				String addition = ("Room Number: " + companyManager.rooms.get(i).getRoomNumber() + "\n");
				report += addition;
			}
		}
		return report;
	}
	
	public static String printReportG(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportH(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportI(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportJ(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportK(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportL(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportM(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportN(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportO(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
}
