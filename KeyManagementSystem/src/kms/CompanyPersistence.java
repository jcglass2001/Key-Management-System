package kms;

import java.io.FileWriter;
import java.io.IOException;

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
	
	public static String printReportE(CompanyManager companyManager) {
		String report = "";
		
		return report;
	}
	
	public static String printReportF(CompanyManager companyManager) {
		String report = "";
		
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
