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
				if(!companyManager.containsBuilding(name, buildingCode)) {
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
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Building with that code already exists!");
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
	
	public void addSuite(String name, String buildingCode, String suiteCode) {
		//Calling validators
		CompanyCodeStatus companyNameMessage = CompanyValidator.isNameValid(name);
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		CompanyCodeStatus companySuiteMessage = CompanyValidator.isSuiteValid(suiteCode);
		
		if(companyNameMessage.isValid()) {
			if(companyBuildingMessage.isValid()) {
				if(companySuiteMessage.isValid()) {
					if(!companyManager.containsSuite(name, buildingCode, suiteCode)) {
						//create building instance
						Suite s = new Suite(name, buildingCode, suiteCode);
						companyManager.addSuite(s);
						
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Suite Added Successfully");
						//show alert
						a.show();
						
						//clear textfields
						gui.txtSuiteName_Suite.clear();
						gui.txtBuildingId_Suite.clear();
						gui.txtSuiteId_Suite.clear();
					}
					else {
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Suite with that code already exists!");
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
					if(!companyManager.containsRoom(buildingCode, suiteCode, roomNumber)) {
						//creates room instance
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
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Room with that number already exists!");
						//show alert
						a.show();
					}
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
		//Create full name
		String fullName = String.format("%s %s. %s", first, middle, last);
		
		if(companyEmployeeMessage.isValid()) {
			if(!companyManager.containsEmployee(fullName, id)) {
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
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Employee with that id already exists!");
				//show alert
				a.show();
			}
		}
		else {
			//set alert and content text
			a.setAlertType(AlertType.ERROR);
			a.setContentText(companyEmployeeMessage.getErrorMessage());
			//show alert
			a.show();
		}
	}
	
	public void removeBuilding(String name, String buildingCode) {
		//Calling validators
		CompanyCodeStatus companyNameMessage = CompanyValidator.isNameValid(name);
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		
		if(companyNameMessage.isValid()) {
			if(companyBuildingMessage.isValid()) {
				if(companyManager.containsBuilding(name, buildingCode)) {
					//create building instance
					Building b = new Building(name, buildingCode);
					companyManager.remBuilding(b);
					
					//set alert and content text
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Building Removed Successfully");
					//show alert
					a.show();
					
					//clear textfields
					gui.txtBuildingId_Remove.clear();
					gui.txtBuildingName_Remove.clear();
				}
				else {
					//set alert and content text
					a.setAlertType(AlertType.INFORMATION);
					a.setContentText("Building with that code doesn't exist!");
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
	
	public void removeSuite(String name, String suiteCode, String buildingCode) {
		//Calling validators
		CompanyCodeStatus companyNameMessage = CompanyValidator.isNameValid(name);
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		CompanyCodeStatus companySuiteMessage = CompanyValidator.isSuiteValid(suiteCode);
		
		if(companyNameMessage.isValid()) {
			if(companyBuildingMessage.isValid()) {
				if(companySuiteMessage.isValid()) {
					if(companyManager.containsSuite(name, buildingCode, suiteCode)) {
						//create building instance
						Suite s = new Suite(name, buildingCode, suiteCode);
						companyManager.addSuite(s);
						
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Suite Removed Successfully");
						//show alert
						a.show();
						
						//clear textfields
						gui.txtSuiteName_Suite_Remove.clear();
						gui.txtBuildingId_Suite_Remove.clear();
						gui.txtSuiteId_Suite_Remove.clear();
					}
					else {
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Suite with that code doesn't exist!");
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
		else {
				//set alert and content text
				a.setAlertType(AlertType.ERROR);
				a.setContentText(companyNameMessage.getErrorMessage());
				//show alert
				a.show();
		}
	}
	public void removeRoom(String roomNumber, String suiteCode, String buildingCode) {
		//Calling validators
		CompanyCodeStatus companyBuildingMessage = CompanyValidator.isBuildingValid(buildingCode);
		CompanyCodeStatus companySuiteMessage = CompanyValidator.isSuiteValid(suiteCode);
		CompanyCodeStatus companyRoomMessage = CompanyValidator.isRoomValid(roomNumber);
	
		if(companyBuildingMessage.isValid()) {
			if(companySuiteMessage.isValid()) {
				if(companyRoomMessage.isValid()) {
					if(companyManager.containsRoom(buildingCode, suiteCode, roomNumber)) {
						//creates room instance
						Room r = new Room(buildingCode, suiteCode, roomNumber);
						companyManager.addRoom(r);
						
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Room Removed Successfully");
						//show alert
						a.show();
						
						//clear textfields
						gui.txtBuildingId_Room_Remove.clear();
						gui.txtSuiteId_Room_Remove.clear();
						gui.txtRoomNum_Room_Remove.clear();
					}
					else {
						//set alert and content text
						a.setAlertType(AlertType.INFORMATION);
						a.setContentText("Room with that number doesn't exist!");
						//show alert
						a.show();
					}
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
	
	public void removeEmployee(String first, String middle, String last, String id) {
		//Calling validators
		CompanyCodeStatus companyEmployeeMessage = CompanyValidator.isEmployeeValid(first, middle, last, id);
		//Create full name
		String fullName = String.format("%s %s. %s", first, middle, last);
		
		if(companyEmployeeMessage.isValid()) {
			if(companyManager.containsEmployee(fullName, id)) {
				//create Employee instance
				Employee e = new Employee(fullName, id);
				companyManager.remEmployee(e);
				
				//set alert and content text
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Employee Removed Successfully");
				//show alert
				a.show();
				
				//clear textfields
				gui.txtFName_Remove.clear();
				gui.txtMInitial_Remove.clear();
				gui.txtLName_Remove.clear();
				gui.txtEmpId_Remove.clear();
			}
			else {
				//set alert and content text
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Employee with that id doesn't exist!");
				//show alert
				a.show();
			}
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
			 switch (selected) {
			 case 'A':
				 String msgA = CompanyPersistence.printReportA(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgA);
				 break;
			 case 'B':
				 String msgB = CompanyPersistence.printReportB(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgB);
				 break;
			 case 'C':
				 String msgC = CompanyPersistence.printReportC(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgC);
				 break;
			 case 'D':
				 String msgD = CompanyPersistence.printReportD(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgD);
				 break;
			 case 'E':
				 String msgE = CompanyPersistence.printReportE(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgE);
				 break;
			 case 'F':
				 String msgF = CompanyPersistence.printReportF(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgF);
				 break;
			 case 'G':
				 String msgG = CompanyPersistence.printReportG(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgG);
				 break;
			 case 'H':
				 String msgH = CompanyPersistence.printReportH(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgH);
				 break;
			 case 'I':
				 String msgI = CompanyPersistence.printReportI(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgI);
				 break;
			 case 'J':
				 String msgJ = CompanyPersistence.printReportJ(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgJ);
				 break;
			 case 'K':
				 String msgK = CompanyPersistence.printReportK(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgK);
				 break;
			 case 'L':
				 String msgL = CompanyPersistence.printReportL(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgL);
				 break;
			 case 'M':
				 String msgM = CompanyPersistence.printReportM(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgM);
				 break;
			 case 'N':
				 String msgN = CompanyPersistence.printReportN(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgN);
				 break;
			 case 'O':
				 String msgO = CompanyPersistence.printReportO(companyManager);
				 //display msg to text area
				 gui.displayInfo_Report.setText(msgO);
				 break;	 	 	 	 	 	 	 	 	 	 	 
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
