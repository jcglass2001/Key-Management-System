package kms;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.value.*;


public class Main extends Application {
	CompanyController companyController;
	
	//stage
	private Stage stage;
	// Scenes
	protected Scene menu;
	protected Scene add;
	protected Scene remove;
	protected Scene report;
	protected Scene accessMenu;
	protected Scene test;

	// menu elements
	protected Button btnAdd;
	protected Button btnRemove;
	protected Button btnAccess;
	protected Button btnReport;
	protected Button btnTest;
	protected Button btnSaveCompany;
	

	/* Element for the Add scene */
	// addBuildingInfo
	protected TextField txtBuildingId;
	protected TextField txtBuildingName;
	protected Button btnAddBuilding;
	// addSuiteInfo
	protected TextField txtSuiteName_Suite;
	protected TextField txtSuiteId_Suite;
	protected TextField txtBuildingId_Suite;
	protected Button btnAddSuite;

	// addRoomInfo
	protected TextField txtRoomNum_Room;
	protected TextField txtSuiteId_Room;
	protected TextField txtBuildingId_Room;
	protected Button btnAddRoom;

	// addEmployeeInfo
	protected TextField txtFirstName;
	protected TextField txtMiddleInitial;
	protected TextField txtLastName;
	protected TextField txtEmployeeId;
	protected Button btnAddEmployee;

	/*Elements for Remove Scene*/
	//removeBuildingInfo
	protected TextField txtBuildingId_Remove;
	protected TextField txtBuildingName_Remove;
	protected Button btnRemoveBuilding;
	//removeSuiteInfo
	protected TextField txtSuiteName_Suite_Remove;
	protected TextField txtSuiteId_Suite_Remove;
	protected TextField txtBuildingId_Suite_Remove;
	protected Button btnRemoveSuite;
	//removeRoomInfo
	protected TextField txtRoomNum_Room_Remove;
	protected TextField txtSuiteId_Room_Remove;
	protected TextField txtBuildingId_Room_Remove;
	protected Button btnRemoveRoom;
	//removeEmployeeInfo
	protected TextField txtFName_Remove;
	protected TextField txtMInitial_Remove;
	protected TextField txtLName_Remove;
	protected TextField txtEmpId_Remove;
	protected Button btnRemoveEmployee;
	/* Elements for the Access scene */
	protected TextField txtEmpId_Access;
	protected TextField txtRoomNum_Access;
	protected TextField txtSuiteId_Access;
	protected TextField txtBuildingId_Access;
	protected TextArea statusMsg = new TextArea();
	protected TabPane tPaneAccess = new TabPane();

	/* Elements for the Test scene */
	protected Label lblEmpId_Test;
	protected TextField txtEmpIdEntry_Test;
	protected TextArea accessStatus_Test;
	protected Button access_Test;

	/* Elements for the Report Scene */
	protected TextField txtBuildingId_Report;
	protected TextField txtSuiteId_Report;
	protected TextField txtRoomId_Report;
	protected TextField txtEmpId_Report;
	protected Button btnGenerate_Report;
	protected ChoiceBox<Character> cBoxList_Report;
	protected TextArea displayInfo_Report;

	/*
	 * Following methods build application scenes
	 * "Menu","Add","Access","Report","Test"
	 */

	private Scene buildMenu() {
		// assign scene elements
		btnAdd = new Button("Add");
		btnAccess = new Button("Access");
		btnReport = new Button("Report");
		btnTest = new Button("Test");
		btnRemove = new Button("Remove");
		btnSaveCompany = new Button("Save Company");
		// create container
		VBox menuSelection = new VBox();
		menuSelection.getStyleClass().add("h_or_v_box");
		menuSelection.getChildren().addAll(btnAdd, btnRemove, btnAccess, btnReport, btnTest);
		// add padding
		menuSelection.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		btnAdd.setOnAction(e -> switchToAdd());
		btnRemove.setOnAction(e -> switchToRemove());
		btnAccess.setOnAction(e -> switchToAccess());
		btnReport.setOnAction(e -> switchToReport());
		btnTest.setOnAction(e -> switchToTest());
		btnSaveCompany.setOnAction(new SaveCompanyEventHandler());
		// assign container to scene
		menu = new Scene(menuSelection, 300, 300);

		return menu;
	}

	private Scene buildAdd() {
		// assign scene elements
		Button btnMenu = new Button("Back to Menu");
		// create grid
		GridPane root = new GridPane();
		// place entry panels side by side
		root.add(buildBuildingEntry_Add(), 0, 0);
		root.add(buildSuiteEntry_Add(), 1, 0);
		root.add(buildRoomEntry_Add(), 2, 0);
		root.add(buildEmployeeEntry_Add(), 3, 0);
		// place navigation button
		root.add(btnMenu, 0, 3);
		// add padding
		root.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		btnMenu.setOnAction(e -> switchToMenu());
		btnAddBuilding.setOnAction(new AddBuildingEventHandler());
		btnAddSuite.setOnAction(new AddSuiteEventHandler());
		btnAddRoom.setOnAction(new AddRoomEventHandler());
		btnAddEmployee.setOnAction(new AddEmployeeEventHandler());
		// assign container to scene
		add = new Scene(root, 1000, 500);

		return add;
	}
	private Scene buildRemove() {
		Button btnMenu = new Button("Back to Menu");
		//create gridpane
		GridPane root = new GridPane();
		//place entry panels side by side
		root.add(buildBuildingEntry_Remove(), 0, 0);
		root.add(buildSuiteEntry_Remove(), 1, 0);
		root.add(buildRoomEntry_Remove(), 2, 0);
		root.add(buildEmployeeEntry_Remove(), 3, 0);
		//add navigation button
		root.add(btnMenu, 0, 3);
		// add padding
		root.setPadding(new Insets(20, 20, 20, 20));
		//register event handlers
		btnMenu.setOnAction(e -> switchScene(menu));
		btnRemoveBuilding.setOnAction(new RemoveBuildingEventHandler());
		btnRemoveSuite.setOnAction(new RemoveSuiteEventHandler());
		btnRemoveRoom.setOnAction(new RemoveRoomEventHandler());
		btnRemoveEmployee.setOnAction(new RemoveEmployeeHandler());
		//assign grid to scene
		remove = new Scene(root,800,500);
		//return scene
		return remove;
		
	}
	
	private Scene buildAccess() {
		
		// set combined container to scene
		accessMenu = new Scene(buildAccessTabs(), 500, 500);
		// return scene
		return accessMenu;
	}
	
	

	private Scene buildReport() {
		// assign elements
		Button btnMenu = new Button("Back to Menu");
		// create displayInfo area
		displayInfo_Report = new TextArea();
		displayInfo_Report.setPrefHeight(600);
		displayInfo_Report.setPrefWidth(200);
		// positioning
		GridPane root = new GridPane();
		root.add(buildReportEntry(), 0, 0);
		root.add(displayInfo_Report, 1, 0);
		root.add(btnMenu, 0, 2);
		// register event handlers
		btnMenu.setOnAction(e -> switchToMenu());
		btnGenerate_Report.setOnAction(new GenerateReportEventHandler());
		// add padding
		root.setPadding(new Insets(20, 20, 20, 20));
		// set grid to scene
		report = new Scene(root, 500, 500);

		return report;
	}

	private Scene buildTest() {
		// assign pane elements
		
		txtEmpIdEntry_Test = new TextField();
		txtEmpIdEntry_Test.setPromptText("Enter Employee ID.");
		Button btnMenu = new Button("Back to Menu");
		// create input container
		VBox testInfo = new VBox();
		testInfo.getChildren().add(txtEmpIdEntry_Test);
		// add nav button
		testInfo.getChildren().add(btnMenu);
		// position container in center and add padding
		testInfo.setAlignment(Pos.CENTER);
		testInfo.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		btnMenu.setOnAction(e -> switchScene(menu));
		// set container to scene
		test = new Scene(testInfo, 300, 300);
		// return scene
		return test;
	}

	/* 
	 * Following methods build panes for select scenes 
	 */

	/* constructs pane for report scene */
	private Pane buildReportEntry() {
		// assign pane elements
		txtBuildingId_Report = new TextField();
		txtBuildingId_Report.setPromptText("Enter Building ID.");
		
		txtSuiteId_Report = new TextField();
		txtSuiteId_Report.setPromptText("Enter Suite ID.");
		
		txtRoomId_Report = new TextField();
		txtRoomId_Report.setPromptText("Enter Room ID.");
		
		txtEmpId_Report = new TextField();
		txtEmpId_Report.setPromptText("Enter Employee ID.");
		
		btnGenerate_Report = new Button("Generate");

		// create and populate drop down list
		cBoxList_Report = populateChoiceBox();
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtBuildingId_Report,txtSuiteId_Report,txtRoomId_Report,txtEmpId_Report));
		//create container populated with textfields
		VBox vBoxReportEntry = buildTextContainer(tFields);
		// combine containers
		VBox vBoxReport = new VBox();
		vBoxReport.getStyleClass().add("h_or_v_box");
		vBoxReport.getChildren().addAll(cBoxList_Report, vBoxReportEntry, btnGenerate_Report);

		return vBoxReport;
	}

	/* constructs building entry pane section for add scene */
	private Pane buildBuildingEntry_Add() {
		// assign pane elements
		txtBuildingName = new TextField();
		txtBuildingName.setPromptText("Enter Building Name.");
		
		txtBuildingId = new TextField();
		txtBuildingId.setPromptText("Enter Building ID.");
		
		btnAddBuilding = new Button("Add Building");

		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtBuildingName,txtBuildingId));
		//create container populated with textfields
		VBox vBoxBuildingEntry = buildTextContainer(tFields);
		//combine container with button
		vBoxBuildingEntry.getChildren().add(btnAddBuilding);
		//return container
		return vBoxBuildingEntry;
	}

	/* constructs suite entry pane section for add scene */
	private Pane buildSuiteEntry_Add() {
		// assign pane elements
		txtSuiteName_Suite = new TextField();
		txtSuiteName_Suite.setPromptText("Enter Suite Name.");
		
		txtSuiteId_Suite = new TextField();
		txtSuiteId_Suite.setPromptText("Enter Suite ID.");
		
		txtBuildingId_Suite = new TextField();
		txtBuildingId_Suite.setPromptText("Enter Building ID.");
		
		btnAddSuite = new Button("Add Suite");
		
		//create arraylist of textfield elements
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtSuiteName_Suite,txtSuiteId_Suite,txtBuildingId_Suite));
		//create container populated with textfields
		VBox vBoxSuiteEntry = buildTextContainer(tFields);
		//combine container with button
		vBoxSuiteEntry.getChildren().add(btnAddSuite);
		// return container
		return vBoxSuiteEntry;
	}

	/* constructs room entry pane section for add scene */
	private Pane buildRoomEntry_Add() {
		// assign pane elements
		txtRoomNum_Room = new TextField();
		txtRoomNum_Room.setPromptText("Enter Room Number.");
		
		txtSuiteId_Room = new TextField();
		txtSuiteId_Room.setPromptText("Enter Suite ID.");
		
		txtBuildingId_Room = new TextField();
		txtBuildingId_Room.setPromptText("Enter Building ID.");
		
		btnAddRoom = new Button("Add Room");
		//create arraylist of textfield elements
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtRoomNum_Room,txtSuiteId_Room, txtBuildingId_Room));
		//create container populated with textfields
		VBox vBoxRoomEntry = buildTextContainer(tFields);
		//combine container with button
		vBoxRoomEntry.getChildren().add(btnAddRoom);
		//return container
		return vBoxRoomEntry;
	}

	/* constructs employee entry pane section for add scene */
	private Pane buildEmployeeEntry_Add() {
		// assign pane elements
		txtFirstName = new TextField();
		txtFirstName.setPromptText("Enter First Name.");
		
		txtMiddleInitial = new TextField();
		txtMiddleInitial.setPromptText("Enter Middle Initial.");
		
		txtLastName = new TextField();
		txtLastName.setPromptText("Enter Last Name.");
		
		txtEmployeeId = new TextField();
		txtEmployeeId.setPromptText("Enter Employee ID.");
		
		btnAddEmployee = new Button("Add Employee");
		
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtFirstName,txtMiddleInitial,txtLastName,txtEmployeeId));
		//create container populated with textfields
		VBox vBoxEmployeeEntry = buildTextContainer(tFields);
		// combine container with button
		vBoxEmployeeEntry.getChildren().add(btnAddEmployee);
		// return container
		return vBoxEmployeeEntry;
	}
	
	/* constructs building entry pane section for remove scene
	 */
	private Pane buildBuildingEntry_Remove() {
		//assign pane elements
		txtBuildingName_Remove = new TextField();
		txtBuildingName_Remove.setPromptText("Enter Building Name.");
		
		txtBuildingId_Remove = new TextField();
		txtBuildingId_Remove.setPromptText("Enter Building ID.");
		
		btnRemoveBuilding = new Button("Remove Building");
		
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtBuildingName_Remove,txtBuildingId_Remove));
		//create container populated with textfields
		VBox vBoxBuildingEntry = buildTextContainer(tFields);
		//add button to container
		vBoxBuildingEntry.getChildren().add(btnRemoveBuilding);
		//return container
		return vBoxBuildingEntry;
		
	}
	private Pane buildSuiteEntry_Remove() {
		//assign pane elements
		txtSuiteName_Suite_Remove = new TextField();
		txtSuiteName_Suite_Remove.setPromptText("Enter Suite Name.");
		
		txtSuiteId_Suite_Remove = new TextField();
		txtSuiteId_Suite_Remove.setPromptText("Enter Suite ID.");
		
		txtBuildingId_Suite_Remove = new TextField();
		txtBuildingId_Suite_Remove.setPromptText("Enter Building ID.");
		
		btnRemoveSuite = new Button("Remove Suite");
		
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtSuiteName_Suite_Remove,txtSuiteId_Suite_Remove,txtBuildingId_Suite_Remove));
		//create container populated with textfields
		VBox vBoxSuiteEntry = buildTextContainer(tFields);
		//add button to container
		vBoxSuiteEntry.getChildren().add(btnRemoveSuite);
		//return container
		return vBoxSuiteEntry;
	}
	private Pane buildRoomEntry_Remove() {
		//assign pane elements
		txtRoomNum_Room_Remove = new TextField();
		txtRoomNum_Room_Remove.setPromptText("Enter Room Number.");
		
		txtSuiteId_Room_Remove = new TextField();
		txtSuiteId_Room_Remove.setPromptText("Enter Suite ID.");
		
		txtBuildingId_Room_Remove = new TextField();
		txtBuildingId_Room_Remove.setPromptText("Enter Building ID.");
		
		btnRemoveRoom = new Button("Remove Room");
		
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtRoomNum_Room_Remove,txtSuiteId_Room_Remove,txtBuildingId_Room_Remove));
		//create container populated with textfields
		VBox vBoxRoomEntry = buildTextContainer(tFields);
		//add button to container
		vBoxRoomEntry.getChildren().add(btnRemoveRoom);
		//return container
		return vBoxRoomEntry;	
	}
	private Pane buildEmployeeEntry_Remove() {
		//assign pane elements
		txtFName_Remove = new TextField();
		txtFName_Remove.setPromptText("Enter First Name.");
		
		txtMInitial_Remove = new TextField();
		txtMInitial_Remove.setPromptText("Enter Middile Initial.");
		
		txtLName_Remove = new TextField();
		txtLName_Remove.setPromptText("Enter Last Name.");
		
		txtEmpId_Remove = new TextField();
		txtEmpId_Remove.setPromptText("Enter Employee ID.");
		
		btnRemoveEmployee = new Button("Remove Employee");
		
		//create arraylist of textfields
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtFName_Remove,txtMInitial_Remove,txtLName_Remove,txtEmpId_Remove));
		//crate container populated with textfields
		VBox vBoxEmployeeEntry = buildTextContainer(tFields);
		//add button to container
		vBoxEmployeeEntry.getChildren().add(btnRemoveEmployee);
		//return container
		return vBoxEmployeeEntry;
	}
private Pane buildAccessTabs() {
		
		BorderPane bPane = new BorderPane();
		tPaneAccess.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
		// assign pane elements
		txtEmpId_Access = new TextField();
		txtEmpId_Access.setPromptText("Enter Employee ID.");
		
		//Build tabs
		Tab buildingAccess = new Tab();
		buildingAccess.setText("Building");
		buildingAccess.setContent(buildTabBuildingAccess());
		
		Tab suiteAccess = new Tab();
		suiteAccess.setText("Suite");
		suiteAccess.setContent(buildTabSuiteAccess());
		
		Tab roomAccess = new Tab();
		roomAccess.setText("Room");
		roomAccess.setContent(buildTabRoomAccess());
		
		//add tabs to TabPane
		tPaneAccess.getTabs().addAll(buildingAccess,suiteAccess,roomAccess);

		bPane.setTop(txtEmpId_Access);
		bPane.setCenter(tPaneAccess);
		
		return bPane;
		
	}
	private Pane buildTabBuildingAccess() {
		GridPane root = new GridPane();
		//pane elements
		TextField txtBuildingEntry = new TextField();
		txtBuildingEntry.setPromptText("Enter Building Code.");
		Button addAccess = new Button("Add Access");
		Button removeAccess = new Button("Remove Access");
		//create container for user text entry
		VBox vBoxEntry = new VBox();
		vBoxEntry.getStyleClass().add("vbox");
		vBoxEntry.getChildren().addAll(new Label("Enter Building Code. Then select Access Option."), txtBuildingEntry);
		//create container for button selection
		HBox hBoxSelection = new HBox();
		hBoxSelection.getStyleClass().add("hbox");
		hBoxSelection.getChildren().addAll(addAccess,removeAccess);
		//register event handlers
		addAccess.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String buildingCode = txtBuildingEntry.getText();
				String employeeID = txtEmpId_Access.getText();
				companyController.addBuildingAccess(employeeID,buildingCode);
			}
		});
		//add containers to pane
		root.add(vBoxEntry, 0, 0);
		root.add(hBoxSelection, 0, 1);
		//return GridPane
		return root;
	}
	private Pane buildTabSuiteAccess() {
		GridPane root = new GridPane();
		//pane elements
		TextField txtBuildingEntry = new TextField();
		txtBuildingEntry.setPromptText("Enter Building Code.");
		TextField txtSuiteEntry = new TextField();
		txtSuiteEntry.setPromptText("Enter Suite Code.");
		Button addAccess = new Button("Add Access");
		Button removeAccess = new Button("Remove Access");
		//create container for user text entry
		VBox vBoxEntry = new VBox();
		vBoxEntry.getStyleClass().add("vbox");
		vBoxEntry.getChildren().addAll(new Label("Enter Suite & Building Codes. Then select Access Option."), txtBuildingEntry,txtSuiteEntry);
		//create container for button selection
		HBox hBoxSelection = new HBox();
		hBoxSelection.getStyleClass().add("hBox");
		hBoxSelection.getChildren().addAll(addAccess,removeAccess);
		//register event handlers
		addAccess.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String empCode = txtEmpId_Access.getText();
				String buildingCode = txtBuildingEntry.getText();
				String suiteCode = txtSuiteEntry.getText();
				companyController.addSuiteAccess(empCode, suiteCode, buildingCode);
			}
		});
		//add containers to pane
		root.add(vBoxEntry, 0, 0);
		root.add(hBoxSelection, 0, 1);
		//return GridPane
		return root;
		
	}
	private Pane buildTabRoomAccess() {
		GridPane root = new GridPane();
		//pane elements
		TextField txtBuildingEntry = new TextField();
		txtBuildingEntry.setPromptText("Enter Building Code.");
		TextField txtSuiteEntry = new TextField();
		txtSuiteEntry.setPromptText("Enter Suite Code.");
		TextField txtRoomEntry = new TextField();
		txtRoomEntry.setPromptText("Enter Room Code.");
		Button addAccess = new Button("Add Access");
		Button removeAccess = new Button("Remove Access");
		//create container for user text entry
		VBox vBoxEntry = new VBox();
		vBoxEntry.getStyleClass().add("vbox");
		vBoxEntry.getChildren().addAll(txtBuildingEntry,txtSuiteEntry,txtRoomEntry);
		//create container for button selection
		HBox hBoxSelection = new HBox();
		hBoxSelection.getStyleClass().add("hBox");
		hBoxSelection.getChildren().addAll(addAccess,removeAccess);
		//register event handlers
		addAccess.setOnAction();
		//add containers to pane
		root.add(vBoxEntry, 0, 0);
		root.add(hBoxSelection, 0, 1);
		//return GridPane
		return root;	
	}
	

	/* 
	 * Navigation Helper Methods 
	 */
	private void switchToAdd() {
		switchScene(add);
		stage.setTitle("Add Scene");
	}
	private void switchToRemove() {
		switchScene(remove);
		stage.setTitle("Remove Scene");
	}

	private void switchToAccess() {
		switchScene(accessMenu);
		stage.setTitle("Access Scene");
	}

	private void switchToReport() {
		switchScene(report);
		stage.setTitle("Report Scene");
	}

	private void switchToTest() {
		switchScene(test);
		stage.setTitle("Test Scene");
	}

	private void switchToMenu() {
		switchScene(menu);
		stage.setTitle("Main Menu");
	}
	
	/*Helper Methods*/

	/* helper method that builds choicebox with chars A-O */
	private ChoiceBox<Character> populateChoiceBox() {
		ChoiceBox<Character> cb = new ChoiceBox<>();
		// create char array to list with elements A-O
		char[] alphabet = "ABCDEFGHIJKLMNO".toCharArray();
		// populate letters in choiceBox
		for (int i = 0; i < alphabet.length; i++) {
			cb.getItems().add(alphabet[i]);
		}
		// display first option
		cb.getSelectionModel().selectFirst();

		return cb;
	}
	
	/*Helper method that creates group of radio buttons for access scene*/
	private ToggleGroup buildRadioGroup(ArrayList<RadioButton> buttons) {
		//create toggle group
		ToggleGroup options = new ToggleGroup();
		//loop through arraylist and add buttons to toggle group
		for(RadioButton b : buttons) {
			b.setToggleGroup(options);
		}
		//return toggle group
		return options;
	}

	private VBox buildTextContainer(ArrayList<TextField>tFields) {
		//create vBox
		VBox container = new VBox(10);
		//loop through arraylist and add textfields to vBox
		for(TextField txt: tFields) {
			container.getChildren().add(txt);
		}
		//return vBox
		return container;
	}
	
	

	/* helper method that switches inputted scene when called */
	private void switchScene(Scene scene) {
		stage.setScene(scene);
	}

	/* helper method that builds all scenes in application */
	private void buildScenes() {
		buildMenu();
		buildAdd();
		buildRemove();
		buildAccess();
		buildReport();
		buildTest();

	}
	
	//Event Handlers
	private class AddBuildingEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
				//grab user input from text fields
				String buildingId = txtBuildingId.getText();
				String buildingName = txtBuildingName.getText();
				companyController.addBuilding(buildingName, buildingId);
		}
	}
	
	
	
	private class AddSuiteEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from text fields
			String suiteName = txtSuiteName_Suite.getText();
			String buildingId = txtBuildingId_Suite.getText();
			String suiteId = txtSuiteId_Suite.getText();
			Building b = new Building(buildingId);
			companyController.addSuite(b, suiteName, buildingId, suiteId);
		}
	}
	
	private class AddRoomEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from text fields
			String buildingId = txtBuildingId_Room.getText();
			String suiteId= txtSuiteId_Room.getText();
			String roomNum = txtRoomNum_Room.getText();
			Suite s = new Suite(suiteId);
			companyController.addRoom(s, buildingId, suiteId, roomNum);
		}
	}
	
	private class AddEmployeeEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from textfields
			String first = txtFirstName.getText();
			String middle = txtMiddleInitial.getText();
			String last = txtLastName.getText();
			String id = txtEmployeeId.getText();
			companyController.addEmployee(first, middle, last, id);
		}
	}
	
	private class RemoveBuildingEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from textfields
			String buildingId = txtBuildingId_Remove.getText();
			String buildingName = txtBuildingName_Remove.getText();
			//remove building from company
			companyController.removeBuilding(buildingName, buildingId);
		}
	}
	
	private class RemoveSuiteEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from textfields
			String suiteName = txtSuiteName_Suite_Remove.getText();
			String buildingId = txtBuildingId_Suite_Remove.getText();
			String suiteId = txtSuiteId_Suite_Remove.getText();
			Building b = new Building(buildingId);
			//remove suite from company
			companyController.removeSuite(b, suiteName, buildingId, suiteId);
		}
	}
	
	private class RemoveRoomEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab  user input from textfields
			String roomNum = txtRoomNum_Room_Remove.getText();
			String suiteId = txtSuiteId_Room_Remove.getText();
			String buildingId = txtBuildingId_Room_Remove.getText();
			Suite s = new Suite(suiteId);
			//remove room from company
			companyController.removeRoom(s, roomNum, suiteId, buildingId);
		}
	}
	
	private class GenerateReportEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab selected choice from choicebox
			Character selectedOption = (Character)cBoxList_Report.getValue();
			companyController.printReports(selectedOption);
		}
	}
	private class RemoveEmployeeHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input
			String fName = txtFName_Remove.getText();
			String mInit = txtMInitial_Remove.getText();
			String lName = txtLName_Remove.getText();
			String empID = txtEmpId_Remove.getText();
			//remove employee from company
			companyController.removeEmployee(fName,mInit,lName,empID);
		}
	}
	private class SaveCompanyEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			companyController.saveCompany();
		}
	}
	
	
	

	@Override
	public void start(Stage primaryStage) {
		try {
			//Passing controller GUI
			companyController = new CompanyController(this);
					
			// build stage scenes
			buildScenes();
			// initiate stage
			stage = primaryStage;
			stage.setTitle("KMS Application");
			menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(menu);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
