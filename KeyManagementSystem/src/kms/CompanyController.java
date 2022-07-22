package kms;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CompanyController {

	private Main gui;
	private CompanyManager companyManager;
	
	Alert a = new Alert(AlertType.NONE);
	
	public CompanyController(Main gui) {
		this.gui = gui;
		this.companyManager = CompanyPersistence.buildCompanyManager();
	}
	
	public void addBuilding(String name, String buildingCode) {
		//Calling validators
		CompanyCodeStatus companyNameMessage = CompanyValidator.isNameValid(name);
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		
		if(companyNameMessage.isValid()) {
			if(companyBuildingMessage.isValid()) {
				//create building instance
				Building b = new Building(name, buildingCode);
				companyManager.addBuilding(b);
				
				//set alert and content text
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Building Added Successfully");
				//show alert
				a.show();
				
				//clear textfields
				gui.txtBuildingId.clear();
				gui.txtBuildingName.clear();
			}
			else {
				//set alert and content text
				a.setAlertType(AlertType.ERROR);
				a.setContentText(companyBuildingMessage.getErrorMessage());
				//show alert
				a.show();
			}
		}
		else {
			//set alert and content text
			a.setAlertType(AlertType.ERROR);
			a.setContentText(companyNameMessage.getErrorMessage());
			//show alert
			a.show();
		}
		
	}
	
	public void addSuite(String name, String buildingCode, String suiteCode) {
		//Calling validators
		CompanyCodeStatus companyNameMessage = CompanyValidator.isNameValid(name);
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		CompanyCodeStatus companySuiteMessage = CompanyValidator.isSuiteValid(suiteCode);
		
		if(companyNameMessage.isValid()) {
			if(companyBuildingMessage.isValid()) {
				if(companySuiteMessage.isValid()) {
					//create building instance
					Suite s = new Suite(name, buildingCode, suiteCode);
					companyManager.addSuite(s);
					
					//set alert and content text
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Building Added Successfully");
					//show alert
					a.show();
					
					//clear textfields
					gui.txtSuiteName_Suite.clear();
					gui.txtBuildingId_Suite.clear();
					gui.txtSuiteId_Suite.clear();
				}
				else {
					//set alert and content text
					a.setAlertType(AlertType.ERROR);
					a.setContentText(companySuiteMessage.getErrorMessage());
					//show alert
					a.show();
				}
			}
			else {
				//set alert and content text
				a.setAlertType(AlertType.ERROR);
				a.setContentText(companyBuildingMessage.getErrorMessage());
				//show alert
				a.show();
			}
		}
		else {
				//set alert and content text
				a.setAlertType(AlertType.ERROR);
				a.setContentText(companyNameMessage.getErrorMessage());
				//show alert
				a.show();
		}
	}
	
	public void addRoom(String buildingCode, String suiteCode, String roomNumber) {
		//Calling validators
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		CompanyCodeStatus companySuiteMessage = CompanyValidator.isSuiteValid(suiteCode);
		CompanyCodeStatus companyRoomMessage = CompanyValidator.isRoomValid(roomNumber);
	
		if(companyBuildingMessage.isValid()) {
			
			if(companySuiteMessage.isValid()) {
				
				if(companyRoomMessage.isValid()) {
					//create building instance
					Room r = new Room(buildingCode, suiteCode, roomNumber);
					companyManager.addRoom(r);
					
					//set alert and content text
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Room Added Successfully");
					//show alert
					a.show();
					
					//clear textfields
					gui.txtBuildingId_Room.clear();
					gui.txtSuiteId_Room.clear();
					gui.txtRoomNum_Room.clear();
				}
				else {
					//set alert and content text
					a.setAlertType(AlertType.ERROR);
					a.setContentText(companyRoomMessage.getErrorMessage());
					//show alert
					a.show();
				}
				
			}
			else {
				//set alert and content text
				a.setAlertType(AlertType.ERROR);
				a.setContentText(companySuiteMessage.getErrorMessage());
				//show alert
				a.show();
			}
		}
		else {
			//set alert and content text
			a.setAlertType(AlertType.ERROR);
			a.setContentText(companyBuildingMessage.getErrorMessage());
			//show alert
			a.show();
		}
		
	}
	
	public void addEmployee(String first, String middle, String last, String id) {
		//Calling validators
		CompanyCodeStatus companyEmployeeMessage = CompanyValidator.isEmployeeValid(first, middle, last, id);
		
		if(companyEmployeeMessage.isValid()) {
			//Create full name
			String fullName = String.format("%s %s. %s", first, middle, last);
			//create Employee instance
			Employee e = new Employee(fullName, id);
			companyManager.addEmployee(e);
			
			//set alert and content text
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("Employee Added Successfully");
			//show alert
			a.show();
			
			//clear textfields
			gui.txtFirstName.clear();
			gui.txtMiddleInitial.clear();
			gui.txtLastName.clear();
			gui.txtEmployeeId.clear();
		}
		else {
			//set alert and content text
			a.setAlertType(AlertType.ERROR);
			a.setContentText(companyEmployeeMessage.getErrorMessage());
			//show alert
			a.show();
		}
	}
	
	public void printReports(Character selected) {
		//Calling printers
		try {
			 //call printReport methods depending on which option was selected
			 if(selected == 'A') {
				 String msg = CompanyPersistence.printReportA(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msg);
			 }else if(selected == 'D') {
				 String msg = CompanyPersistence.printReportD(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msg);
			 }
		}catch(Exception e) {}
	}
	

	public void save() {
		//Calling saver
		CompanyPersistence.saveCompany(companyManager);
		//set alert and content text
		a.setAlertType(AlertType.ERROR);
		a.setContentText("Report saved to file");
		//show alert
		a.show();
	}

}
