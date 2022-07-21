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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
	CompanyController companyController;
	
	//stage
	private Stage stage;
	// Scenes
	protected Scene menu;
	protected Scene add;
	protected Scene report;
	protected Scene access;
	protected Scene test;

	// menu elements
	protected Button btnAdd;
	protected Button btnAccess;
	protected Button btnReport;
	protected Button btnTest;

	/* Element for the Add scene */
	// addBuildingInfo
	protected TextField txtBuildingId;
	protected TextField txtBuildingName;
	protected Label lblBuildingId;
	protected Label lblBuildingName;
	protected Button btnAddBuilding;
	// addSuiteInfo
	protected Label lblSuiteName_Suite;
	protected Label lblSuiteId_Suite;
	protected Label lblBuildingId_Suite;
	protected TextField txtSuiteName_Suite;
	protected TextField txtSuiteId_Suite;
	protected TextField txtBuildingId_Suite;
	protected Button btnAddSuite;

	// addRoomInfo
	protected Label lblRoomNum_Room;
	protected Label lblSuiteId_Room;
	protected Label lblBuildingId_Room;
	protected TextField txtRoomNum_Room;
	protected TextField txtSuiteId_Room;
	protected TextField txtBuildingId_Room;
	protected Button btnAddRoom;

	// addEmployeeInfo
	protected Label lblFirstName;
	protected Label lblMiddleInitial;
	protected Label lblLastName;
	protected Label lblEmployeeId = new Label("Employee ID: ");
	protected TextField txtFirstName;
	protected TextField txtMiddleInitial;
	protected TextField txtLastName;
	protected TextField txtEmployeeId;
	protected Button btnAddEmployee;

	/* Elements for the Access scene */
	protected Label lblEmpId_Access;
	protected Label lblRoomNum_Access;
	protected Label lblSuiteId_Access;
	protected Label lblBuildingId_Access;
	protected TextField txtEmpId_Access;
	protected TextField txtRoomNum_Access;
	protected TextField txtSuiteId_Access;
	protected TextField txtBuildingId_Access;

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
		// create container
		VBox menuSelection = new VBox();
		menuSelection.getStyleClass().add("h_or_v_box");
		menuSelection.getChildren().addAll(btnAdd, btnAccess, btnReport, btnTest);
		// add padding
		menuSelection.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		btnAdd.setOnAction(e -> switchToAdd());
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

	private Scene buildAccess() {
		// assign pane elements
		lblEmpId_Access = new Label("Employee ID: ");
		lblRoomNum_Access = new Label("Room Number: ");
		lblSuiteId_Access = new Label("Suite ID: ");
		lblBuildingId_Access = new Label("Building ID: ");
		txtEmpId_Access = new TextField();
		txtRoomNum_Access = new TextField();
		txtSuiteId_Access = new TextField();
		txtBuildingId_Access = new TextField();
		Button btnMenu = new Button("Back to Menu");
		// create employee id container
		HBox empIDInfo = buildLabelTextContainer_H(lblEmpId_Access, txtEmpId_Access);
		// create room number container
		HBox roomNumInfo = buildLabelTextContainer_H(lblRoomNum_Access, txtRoomNum_Access);
		// create suite id container
		HBox suiteIdInfo = buildLabelTextContainer_H(lblSuiteId_Access, txtSuiteId_Access);
		// create building id container
		HBox buildingIdInfo = buildLabelTextContainer_H(lblBuildingId_Access, txtBuildingId_Access);
		// combine containers
		VBox vBoxAccessEntry = new VBox();
		vBoxAccessEntry.getStyleClass().add("h_or_v_box");
		vBoxAccessEntry.getChildren().addAll(empIDInfo, roomNumInfo, suiteIdInfo, buildingIdInfo, btnMenu);
		// add padding to positioning
		vBoxAccessEntry.setPadding(new Insets(20, 20, 20, 20));
		// register event handlers
		btnMenu.setOnAction(e -> switchToMenu());
		// set combined container to scene
		access = new Scene(vBoxAccessEntry, 500, 500);
		// return scene
		return access;
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
		lblEmpId_Test = new Label("Enter ID");
		txtEmpId_Test = new TextField();
		Button btnMenu = new Button("Back to Menu");
		// create input container
		VBox testInfo = buildLabelTextContainer_V(lblEmpId_Test, txtEmpId_Test);
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
		lblBuildingId_Report = new Label("Building Id: ");
		lblSuiteId_Report = new Label("Suite Id: ");
		lblRoomId_Report = new Label("Room Id: ");
		lblEmpId_Report = new Label("Employee Id: ");
		txtBuildingId_Report = new TextField();
		txtSuiteId_Report = new TextField();
		txtRoomId_Report = new TextField();
		txtEmpId_Report = new TextField();
		btnGenerate_Report = new Button("Generate");

		// create drop down list
		cBoxList_Report = populateChoiceBox();
		// create building id entry container
		HBox hBoxBuildingIdInfo = buildLabelTextContainer_H(lblBuildingId_Report, txtBuildingId_Report);
		// create suite id entry container
		HBox hBoxSuiteIdInfo = buildLabelTextContainer_H(lblSuiteId_Report, txtSuiteId_Report);
		// create room id entry container
		HBox hBoxRoomIdInfo = buildLabelTextContainer_H(lblRoomId_Report, txtRoomId_Report);
		// create Employee id entry container
		HBox hBoxEmpIdInfo = buildLabelTextContainer_H(lblEmpId_Report, txtEmpId_Report);

		// combine containers
		VBox vBoxReportEntry = new VBox();
		vBoxReportEntry.getStyleClass().add("h_or_v_box");
		vBoxReportEntry.getChildren().addAll(cBoxList_Report, hBoxBuildingIdInfo, hBoxSuiteIdInfo, hBoxRoomIdInfo, hBoxEmpIdInfo, btnGenerate_Report);

		return vBoxReportEntry;
	}

	/* constructs building entry pane section for add scene */
	private Pane buildBuildingEntry_Add() {
		// assign pane elements
		txtBuildingName = new TextField();
		txtBuildingId = new TextField();
		lblBuildingId = new Label("Building Id:");
		lblBuildingName = new Label("Building Name:");
		btnAddBuilding = new Button("Add Building");

		// create building name container
		HBox hBoxBuildingNameInfo = buildLabelTextContainer_H(lblBuildingName, txtBuildingName);
		// create building id container
		HBox hBoxBuildingIdInfo = buildLabelTextContainer_H(lblBuildingId, txtBuildingId);
		// combine containers
		VBox vBoxBuildingInfo = new VBox();
		vBoxBuildingInfo.getStyleClass().add("h_or_v_box");
		vBoxBuildingInfo.getChildren().addAll(hBoxBuildingNameInfo, hBoxBuildingIdInfo, btnAddBuilding);

		return vBoxBuildingInfo;
	}

	/* constructs suite entry pane section for add scene */
	private Pane buildSuiteEntry_Add() {
		// assign pane elements
		txtSuiteId_Suite = new TextField();
		txtSuiteName_Suite = new TextField();
		txtBuildingId_Suite = new TextField();
		lblSuiteId_Suite = new Label("Suite ID: ");
		lblSuiteName_Suite = new Label("Suite Name: ");
		lblBuildingId_Suite = new Label("Building ID: ");
		btnAddSuite = new Button("Add Suite");
		// create suite name container
		HBox hBoxSuiteNameInfo = buildLabelTextContainer_H(lblSuiteName_Suite, txtSuiteName_Suite);
		// create suite id container
		HBox hBoxSuiteIdInfo = buildLabelTextContainer_H(lblSuiteId_Suite, txtSuiteId_Suite);
		// create building id container
		HBox hBoxBuildingIdInfo = buildLabelTextContainer_H(lblBuildingId_Suite, txtBuildingId_Suite);
		// combine containers
		VBox vBoxSuiteInfo = new VBox();
		vBoxSuiteInfo.getStyleClass().add("h_or_v_box");
		vBoxSuiteInfo.getChildren().addAll(hBoxSuiteNameInfo, hBoxSuiteIdInfo, hBoxBuildingIdInfo, btnAddSuite);
		// return pane
		return vBoxSuiteInfo;
	}

	/* constructs room entry pane section for add scene */
	private Pane buildRoomEntry_Add() {
		// assign pane elements
		txtRoomNum_Room = new TextField();
		txtSuiteId_Room = new TextField();
		txtBuildingId_Room = new TextField();
		lblRoomNum_Room = new Label("Room Number");
		lblSuiteId_Room = new Label("Suite ID:");
		lblBuildingId_Room = new Label("Building ID:");
		btnAddRoom = new Button("Add Room");
		// create room number container
		HBox hBoxRoomNumInfo = buildLabelTextContainer_H(lblRoomNum_Room, txtRoomNum_Room);
		// create suite id container
		HBox hBoxSuiteIdInfo = buildLabelTextContainer_H(lblSuiteId_Room, txtSuiteId_Room);
		// create building id container
		HBox hBoxBuildingIdInfo = buildLabelTextContainer_H(lblBuildingId_Room, txtBuildingId_Room);
		// combine containers
		VBox vBoxRoomInfo = new VBox();
		vBoxRoomInfo.getStyleClass().add("h_or_v_box");
		vBoxRoomInfo.getChildren().addAll(hBoxRoomNumInfo, hBoxSuiteIdInfo, hBoxBuildingIdInfo, btnAddRoom);

		return vBoxRoomInfo;
	}

	/* constructs employee entry pane section for add scene */
	private Pane buildEmployeeEntry_Add() {
		// assign pane elements
		txtFirstName = new TextField();
		txtMiddleInitial = new TextField();
		txtLastName = new TextField();
		txtEmployeeId = new TextField();
		lblFirstName = new Label("First Name: ");
		lblMiddleInitial = new Label("Middile Initial: ");
		lblLastName = new Label("Last Name: ");
		lblEmployeeId = new Label("Employee ID: ");
		btnAddEmployee = new Button("Add Button");
		// create first name container
		HBox hBoxFirstNameInfo = buildLabelTextContainer_H(lblFirstName, txtFirstName);
		// create middle initial container
		HBox hBoxMiddleInitInfo = buildLabelTextContainer_H(lblMiddleInitial, txtMiddleInitial);
		// create last name container
		HBox hboxLastNameInfo = buildLabelTextContainer_H(lblLastName, txtLastName);
		// create employee id container
		HBox hBoxEmpIdInfo = buildLabelTextContainer_H(lblEmployeeId, txtEmployeeId);
		// combine containers
		VBox vBoxEmpInfo = new VBox();
		vBoxEmpInfo.getStyleClass().add("h_or_v_box");
		vBoxEmpInfo.getChildren().addAll(hBoxFirstNameInfo, hBoxMiddleInitInfo, hboxLastNameInfo, hBoxEmpIdInfo, btnAddEmployee);
		// return pane
		return vBoxEmpInfo;
	}
	

	/* 
	 * Navigation Helper Methods 
	 */
	private void switchToAdd() {
		switchScene(add);
		stage.setTitle("Add Scene");
	}

	private void switchToAccess() {
		switchScene(access);
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
		ChoiceBox<Character> cb = new ChoiceBox();
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

	

	/* helper method that generates an hbox containing a label and a textfield */
	private HBox buildLabelTextContainer_H(Label lbl, TextField txt) {
		HBox container = new HBox();
		container.getStyleClass().add("h_or_v_box");
		container.getChildren().addAll(lbl, txt);

		return container;
	}

	/* helper method that generates an vbox containing a label and a textfield */
	private VBox buildLabelTextContainer_V(Label lbl, TextField txt) {
		VBox container = new VBox();
		container.getStyleClass().add("h_or_v_box");
		container.getChildren().addAll(lbl, txt);

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
	
	private class GenerateReportEventHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//grab selected choice from choicebox
			Character selectedOption = (Character)cBoxList_Report.getValue();
			companyController.printReports(selectedOption);
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
