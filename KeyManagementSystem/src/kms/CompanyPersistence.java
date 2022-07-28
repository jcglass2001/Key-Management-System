package kms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompanyPersistence {
	public static CompanyManager buildCompanyManager() {
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
				myWriter.write("%" + companyManager.suites.get(i).getName() + "-" + companyManager.suites.get(i).getBuildingCode()
						+ "-" + companyManager.suites.get(i).getSuiteCode() + "\n");

			//rooms
			for (int i = 0; i < companyManager.rooms.size(); i++)
				myWriter.write("!" + companyManager.rooms.get(i).getBuildingCode() + "-"
						+ companyManager.rooms.get(i).getSuiteCode() + "-" + companyManager.rooms.get(i).getRoomNumber() +"\n");

			//employees
			for (int i = 0; i < companyManager.employees.size(); i++) {
				myWriter.write("$" + companyManager.employees.get(i).getName() + "-" + companyManager.employees.get(i).getId());
				ArrayList<Room> employeeAccess = companyManager.employees.get(i).getFullAccess();
				for(int j = 0; j < employeeAccess.size(); j++)
					myWriter.write("-" + employeeAccess.get(j).getRoomNumber());
				myWriter.write("\n");
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	//build company from file
	public void buildFromFile(File file, CompanyManager companyManager) {
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()){
				String currentLine = scan.nextLine();
				
				//# represents new building
				if(currentLine.charAt(0) == '#') {
					//split line into components for class construction
					String lineData = currentLine.substring(1);
					String[] components = lineData.split("-");
					String tempName = components[0];
					String tempCode = components[1];
						
					Building tempBuild = new Building(tempName, tempCode);
					companyManager.addBuilding(tempBuild);;
				}
						
				//% represents new suite
				if(currentLine.charAt(0) == '%') {
					//split line into components for class construction
					String lineData = currentLine.substring(1);
					String[] components = lineData.split("-");
					String tempName = components[0];
					String tempBuild = components[1];
					String tempSuiteCode = components[2];
							
					Suite tempSuite = new Suite(tempName, tempBuild, tempSuiteCode);
					companyManager.addSuite(tempSuite);;
				}
						
				//! represents new room
				if(currentLine.charAt(0) == '!') {
					//split line into components for class construction
					String lineData = currentLine.substring(1);
					String[] components = lineData.split("-");
					String tempBuild = components[0];
					String tempSuite = components[1];
					String tempNum = components[2];
								
					Room tempRoom = new Room(tempBuild, tempSuite, tempNum);
					companyManager.addRoom(tempRoom);
				}
						
				//$ represents new employee
				if(currentLine.charAt(0) == '$') {
					//split line into components for class construction
					String lineData = currentLine.substring(1);
					String[] components = lineData.split("-");
					String tempName = components[0];
					String tempID = components[1];
					
					Employee tempEmp = new Employee(tempName, tempID);
					
					//any extra components are related to room access
					if(components.length > 2) {
						//loop through leftover components and add them as room access
						for(int i = 2; i < components.length; i++) {
							Room tempRoom = companyManager.getRoomByNum(components[i]);
							tempEmp.addRoomAccess(tempRoom);
						}
					}
					companyManager.addEmployee(tempEmp);
				}	
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}	
	}
	
	//Record employee access attempts
	public void accessRecords(CompanyManager companyManager) {
		try {
			//date time set up
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			
			//document writing
			FileWriter myWriter = new FileWriter("AccessRecords.txt");
			
			//document header
			myWriter.write("List of Attempted Access Attempts: \n");
			myWriter.write("Current Date and Time: " + formatter.format(date) + "\n");
			
			//doc data
			for(int i = 0; i < companyManager.getAccessAttempts().size(); i++)
				myWriter.write(companyManager.getAccessAttempts().get(i) + "\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
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
        for (int i = 0; i < companyManager.employees.size(); i++) {
            report += (companyManager.employees.get(i).getName() + ", ID= " + companyManager.employees.get(i).getId() + "\n");
            for(int j = 0; j < companyManager.employees.get(i).buildingAccess.size(); j++) {
                    for(int k = 0; k < companyManager.employees.get(i).getBuildingAccess().get(j).getSuites().size(); k++) {
                        //loop through and print all rooms in suite
                        for(int l = 0; l  < companyManager.employees.get(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().size(); l++) {
                            //print rooms
                            report += String.format("Room " + companyManager.getEmployee(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().get(l).getRoomNumber()) + ", " +
                            		companyManager.getBuildingByCode(companyManager.getEmployee(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().get(l).getBuildingCode()).getName() + " Building (" +
                            		companyManager.getEmployee(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().get(l).getBuildingCode() + "), " + 
                            		companyManager.getSuiteByCode(companyManager.getEmployee(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().get(l).getSuiteCode()).getName() + " Suite (" + 
                            		companyManager.getEmployee(i).getBuildingAccess().get(j).getSuites().get(k).getRooms().get(l).getSuiteCode() + ")\n";
                        }
                    }
                
            }
            report += "\n";
        }
        return report;
	}
	
	public static String printReportC(CompanyManager companyManager) {
        String report = "";

        // loop through employees
        for (int i = 0; i < companyManager.employees.size(); i++) {
            // grab employee and add details to message
            Employee dummy = companyManager.employees.get(i);
            report += String.format("%s,ID=%s\n", dummy.getName(), dummy.getId());
            // loop through employee room access list
            for (int j = 0; j < dummy.getRoomAccess().size(); j++) {
                Room rDummy = dummy.getRoomAccess().get(j);
                report += String.format("\tRoom Access: %s, %s Building (%s), %s Suite (%s)\n", rDummy.getRoomNumber(),
                        "[building type]", rDummy.getBuildingCode(), "[suite type]", rDummy.getSuiteCode());
            }
            // loop through employee suite access list
            for (int k = 0; k < dummy.getSuiteAccess().size(); k++) {
                Suite sDummy = dummy.getSuiteAccess().get(k);
                report += String.format("\tSuite Access: %s Building (%s), %s Suite (%s)", "[building type]\n",
                        sDummy.getBuildingCode(), sDummy.getName(), sDummy.getSuiteCode());
            }
            // loop through employee building access list
            for (int l = 0; l < dummy.getBuildingAccess().size(); l++) {
                Building bDummy = dummy.getBuildingAccess().get(l);
                report += String.format("\tBuilding Access: %s Building (%s)\n", bDummy.getName(),
                        bDummy.getBuildingCode());
            }
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
	
	public static String printReportE(CompanyManager companyManager, String buildingCode) {
		String report = "";
        //grab building
		for(int i = 0; i < companyManager.buildings.size(); i++) {
				if(companyManager.getBuilding(i).getBuildingCode().equals(buildingCode)) {
					//print building
			        report += String.format("Building: %s - %s", companyManager.getBuilding(i).getName(), companyManager.getBuilding(i).getBuildingCode());
			        //loop through suites list in building
			        for(int j = 0; j < companyManager.getBuilding(i).getSuites().size(); j++) {
			            //print suites
			            report += String.format("\n\tSuite: %s - %s", companyManager.getBuilding(i).getSuites().get(j).getName(), companyManager.getBuilding(i).getSuites().get(j).getSuiteCode());
			            //loop through and print all rooms in suite
			            for(int k = 0; k < companyManager.getBuilding(i).getSuites().get(j).getRooms().size(); k++) {
			                //print rooms
			                report += String.format("\n\t\tRoom: %s", companyManager.getBuilding(i).getSuites().get(j).getRooms().get(k).getRoomNumber());
			            }
			        }
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
	
	public static String printReportG(CompanyManager companyManager, String buildingCode, String roomNum) {
		String report = "";
		for (int i = 0; i < companyManager.employees.size(); i++) {
			//grab employee
			Employee dummy = companyManager.employees.get(i);
			for(int j = 0; j < dummy.getRoomAccess().size(); j++) {
				//grab room
				Room rDummy = dummy.getRoomAccess().get(j);
				//add employee details if room's building code & room number matches parameters
				if(rDummy.getBuildingCode().equals(buildingCode) && rDummy.getRoomNumber().equals(roomNum)) {
					report += (dummy.getName() + ", ID= " + dummy.getId() + "\n");
	            }
			}
		}
		
		return report;
	}
	
	public static String printReportH(CompanyManager companyManager, String eId) {
		String report = "Report H: \n";
		ArrayList<String> reverseOrder = companyManager.getAccessAttempts();
		Collections.reverse(reverseOrder);
		for(int i = 0; i < reverseOrder.size(); i++) {
			String currentLine = reverseOrder.get(i);
			if(currentLine.substring(11,15).equals(eId)) {
				if(currentLine.substring(94).equals("Success")) {
					Employee currentEmp = companyManager.getEmployee(companyManager.getEmployeeById(eId));
					String roomNum = currentLine.substring(43,46);
					Room currentRoom = companyManager.getRoomByNum(roomNum);
					report += (currentEmp.getName() + " employee #" + currentEmp.getId() + " succesfully accessed room #" + currentRoom.getRoomNumber()
							+ " in suite #" + currentRoom.getSuiteCode() + " in building #" + currentRoom.getBuildingCode() + currentLine.substring(61,77) + "\n");
				}
			}
		}
		
		return report;
	}
	
	public static String printReportI(CompanyManager companyManager, String eId) {
		String report = "Report I: \n";
		ArrayList<String> reverseOrder = companyManager.getAccessAttempts();
		Collections.reverse(reverseOrder);
		for(int i = 0; i < reverseOrder.size(); i++) {
			String currentLine = reverseOrder.get(i);
			if(currentLine.substring(11,15).equals(eId)) {
				if(currentLine.substring(94).equals("Failure")) {
					Employee currentEmp = companyManager.getEmployee(companyManager.getEmployeeById(eId));
					String roomNum = currentLine.substring(43,46);
					Room currentRoom = companyManager.getRoomByNum(roomNum);
					report += (currentEmp.getName() + " employee #" + currentEmp.getId() + " failed to access room #" + currentRoom.getRoomNumber()
							+ " in suite #" + currentRoom.getSuiteCode() + " in building #" + currentRoom.getBuildingCode() + currentLine.substring(61,77) + "\n");
				}
			}
		}
		
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
	
}
