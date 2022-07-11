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
	
	@DisplayName("saves suites")
	@Test
	void AddSuites() {
		Company c1 = new Company();
		Suite s1 = new Suite("Offices", "12", "01");
		c1.getSuites().add(s1);
		assertEquals(c1.getSuites().get(0).getName(), "Offices");
	}
	
	@DisplayName("saves rooms")
	@Test
	void AddRooms() {
		Company c1 = new Company();
		Room r1 = new Room("01", "12", "432");
		c1.getRooms().add(r1);
		assertEquals(c1.getRooms().get(0).getRoomNumber(), "432");
	}
	
	@DisplayName("saves employees")
	@Test
	void AddEmployees() {
		Company c1 = new Company();
		Employee e1 = new Employee("Joseph", "1234");
		c1.getEmployees().add(e1);
		assertEquals(c1.getEmployees().get(0).getName(), "Joseph");
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
		Company.WriteToFile();
		File testFile = new File("Report.txt");
		assertEquals(testFile.exists(), true);
	}
	

}
