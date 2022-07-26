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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
	/* Elements for the Access scene */
	protected Label lblEmpId_Access;
	protected Label lblRoomNum_Access;
	protected Label lblSuiteId_Access;
	protected Label lblBuildingId_Access;
	protected TextField txtEmpId_Access;
	protected TextField txtRoomNum_Access;
	protected TextField txtSuiteId_Access;
	protected TextField txtBuildingId_Access;
	protected TextArea statusMsg = new TextArea();
	protected RadioButton rBtnGiveAccess;
	protected RadioButton rBtnRemoveAccess;

	/* Elements for the Test scene */
	protected Label lblEmpId_Test;
	protected TextField txtEmpId_Test;

	/* Elements for the Report Scene */
	protected Label lblBuildingId_Report;
	protected Label lblSuiteId_Report;
	protected Label lblRoomId_Report;
	protected Label lblEmpId_Report;
	protected TextField txtBuildingId_Report;
	protected TextField txtSuiteId_Report;
	protected TextField txtRoomId_Report;
	protected TextField txtEmpId_Report;
	protected Button btnGenerate_Report;
	protected ChoiceBox cBoxList_Report;
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
		//add navigation button
		root.add(btnMenu, 0, 3);
		// add padding
		root.setPadding(new Insets(20, 20, 20, 20));
		//register event handlers
		btnMenu.setOnAction(e -> switchScene(menu));
		btnRemoveBuilding.setOnAction(new RemoveBuildingEventHandler());
		btnRemoveSuite.setOnAction(new RemoveSuiteEventHandler());
		btnRemoveRoom.setOnAction(new RemoveRoomEventHandler());
		//assign grid to scene
		remove = new Scene(root,800,500);
		//return scene
		return remove;
		
	}
	
	//INCOMPLETE
	private Scene buildAccessMenu() {
		// assign pane elements
		txtEmpId_Access = new TextField();
		txtEmpId_Access.setPromptText("Enter Employee ID.");
		
		txtRoomNum_Access = new TextField();
		txtRoomNum_Access.setPromptText("Enter Room Number.");
		
		
		txtSuiteId_Access = new TextField();
		txtSuiteId_Access.setPromptText("Enter Suite ID.");
		
		txtBuildingId_Access = new TextField();
		txtBuildingId_Access.setPromptText("Enter BUilding ID.");
		
		rBtnGiveAccess = new RadioButton("Give Access");
		rBtnRemoveAccess = new RadioButton("Remove Access");
		Button btnMenu = new Button("Back to Menu");
		//create arraylist of access buttons
		ArrayList<RadioButton> accessButtons = new ArrayList<>(Arrays.asList(rBtnGiveAccess,rBtnRemoveAccess));
		//create arraylist of textfields
		ArrayList<TextField> tFields = new ArrayList<>(Arrays.asList(txtEmpId_Access,txtRoomNum_Access,txtSuiteId_Access,txtBuildingId_Access));
		//create toggle group and populate with access buttons
		ToggleGroup accessOption = buildRadioGroup(accessButtons);
		//create container populated with textfields
		VBox vBoxAccessEntry = buildTextContainer(tFields);
		//combine container with nav button
		vBoxAccessEntry.getChildren().add(btnMenu);
		// add padding to positioning
		vBoxAccessEntry.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		//rBtnGiveAccess.setOnAction(GiveAccessEventHandler());
		btnMenu.setOnAction(e -> switchToMenu());
		// set combined container to scene
		accessMenu = new Scene(vBoxAccessEntry, 500, 500);
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
		
		txtEmpId_Test = new TextField();
		txtEmpId_Test.setPromptText("Enter Employee ID.");
		Button btnMenu = new Button("Back to Menu");
		// create input container
		VBox testInfo = new VBox();
		testInfo.getChildren().add(txtEmpId_Test);
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
		txtSuiteId_Suite = new TextField();
		txtSuiteId_Suite.setPromptText("Enter Suite ID.");
		
		txtSuiteName_Suite = new TextField();
		txtSuiteName_Suite.setPromptText("Enter Suite Name.");
		
		txtBuildingId_Suite = new TextField();
		txtBuildingId_Suite.setPromptText("Enter Building ID.");
		
		btnAddSuite = new Button("Add Suite");
		
		//create arraylist of textfield elements
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtSuiteId_Suite,txtSuiteName_Suite,txtBuildingId_Suite));
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
		ArrayList<TextField>tFields = new ArrayList<>(Arrays.asList(txtRoomNum_Room,txtSuiteId_Room,txtBuildingId_Room));
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
		buildAccessMenu();
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
			companyController.addSuite(suiteName, buildingId, suiteId);
		}
	}
	
	private class AddRoomEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab user input from text fields
			String buildingId = txtBuildingId_Room.getText();
			String suiteId= txtSuiteId_Room.getText();
			String roomNum = txtRoomNum_Room.getText();
			companyController.addRoom(buildingId, suiteId, roomNum);
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
			//remove suite from company
			companyController.removeSuite(suiteName, suiteId, buildingId);
		}
	}
	private class RemoveRoomEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab  user input from textfields
			String roomNum = txtRoomNum_Room_Remove.getText();
			String suiteId = txtSuiteId_Room_Remove.getText();
			String buildingId = txtBuildingId_Room_Remove.getText();
			//remove room from company
			companyController.removeRoom(roomNum, suiteId, buildingId);
		}
	}
	
	private class GenerateReportEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab selected choice from choicebox
			Character selectedOption = (Character)cBoxList_Report.getValue();
			companyController.printReports(selectedOption);
		}
	}
	
	//INCOMPLETE
	private class GiveAccessEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//
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
