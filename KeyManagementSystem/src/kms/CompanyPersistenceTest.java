package kms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyPersistenceTest {

	@DisplayName("FileWriter: create file")
	@Test
	void FileWriterTest() {
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "12", "01");
		Room r1 = new Room("01", "12", "432");
		Employee e1 = new Employee("Joseph", "1234");
		c1.addBuilding(b);
		c1.addSuite(s1);
		c1.addRoom(r1);
		c1.addEmployee(e1);
		p1.saveCompany(c1);
		File testFile = new File("Report.txt");
		assertEquals(testFile.exists(), true);
	}

}
