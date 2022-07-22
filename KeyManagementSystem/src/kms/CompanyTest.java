package kms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyTest {

	@DisplayName("saves buildings")
	@Test
	void AddBuildings() {
		Company c1 = new Company();
		Building b = new Building("Google", "01");
		c1.getBuildings().add(b);
		assertEquals(c1.getBuildings().get(0).getName(), "Google");

	}
	
	@DisplayName("removes buildings")
	@Test
	void RemoveBuildings() {
		Company c1 = new Company();
		Building b1 = new Building("Google", "01");
		Building b2 = new Building("Microsoft", "02");
		c1.getBuildings().add(b1);
		c1.getBuildings().add(b2);
		c1.getBuildings().remove(b1);
		assertEquals(c1.getBuildings().get(0).getName(), "Microsoft");

	}
	
	@DisplayName("saves suites")
	@Test
	void AddSuites() {
		Company c1 = new Company();
		Suite s1 = new Suite("Offices", "12", "01");
		c1.getSuites().add(s1);
		assertEquals(c1.getSuites().get(0).getName(), "Offices");
	}
	
	@DisplayName("removes suites")
	@Test
	void RemovesSuites() {
		Company c1 = new Company();
		Suite s1 = new Suite("Offices", "12", "01");
		Suite s2 = new Suite("Lounge", "12", "02");
		c1.getSuites().add(s1);
		c1.getSuites().add(s2);
		c1.getSuites().remove(s1);
		assertEquals(c1.getSuites().get(0).getName(), "Lounge");
	}
	
	@DisplayName("saves rooms")
	@Test
	void AddRooms() {
		Company c1 = new Company();
		Room r1 = new Room("01", "12", "432");
		c1.getRooms().add(r1);
		assertEquals(c1.getRooms().get(0).getRoomNumber(), "432");
	}
	
	@DisplayName("removes rooms")
	@Test
	void RemoveRooms() {
		Company c1 = new Company();
		Room r1 = new Room("01", "12", "432");
		Room r2 = new Room("01", "12", "433");
		c1.getRooms().add(r1);
		c1.getRooms().add(r2);
		c1.getRooms().remove(r1);
		assertEquals(c1.getRooms().get(0).getRoomNumber(), "433");
	}
	
	@DisplayName("saves employees")
	@Test
	void AddEmployees() {
		Company c1 = new Company();
		Employee e1 = new Employee("Joseph", "1234");
		c1.getEmployees().add(e1);
		assertEquals(c1.getEmployees().get(0).getName(), "Joseph");
	}
	
	@DisplayName("removes employees")
	@Test
	void RemoveEmployees() {
		Company c1 = new Company();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("John", "4321");
		c1.getEmployees().add(e1);
		c1.getEmployees().add(e2);
		c1.getEmployees().remove(e1);
		assertEquals(c1.getEmployees().get(0).getName(), "John");
	}
	
	@DisplayName("FileWriter: create file")
	@Test
	void FileWriterTest() {
		Company c1 = new Company();
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "12", "01");
		Room r1 = new Room("01", "12", "432");
		Employee e1 = new Employee("Joseph", "1234");
		c1.getBuildings().add(b);
		c1.getSuites().add(s1);
		c1.getRooms().add(r1);
		c1.getEmployees().add(e1);
		c1.writeToFile();
		File testFile = new File("Report.txt");
		assertEquals(testFile.exists(), true);
	}
	
	/*
	@DisplayName("FileReader: build from file")
	@Test
	void FileReaderTest() {
		Company c1 = new Company();
		File testFile = new File("TestReport.txt");
		c1.buildFromFile(testFile);
		assertEquals(c1.getBuildings().get(0).getCode(), "Google");
	}
	*/

}
