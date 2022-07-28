package kms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyPersistenceTest {

	@DisplayName("FileWriter: create file")
	@Test
	void FileWriterTest() {
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "01", "02");
		Room r1 = new Room("01", "02", "432");
		Employee e1 = new Employee("Joseph", "1234");
		c1.addBuilding(b);
		c1.addSuite(s1);
		c1.addRoom(r1);
		c1.addEmployee(e1);
		e1.addRoomAccess(r1);
		p1.saveCompany(c1);
		File testFile = new File("Report.txt");
		assertEquals(testFile.exists(), true);
	}
	
	@DisplayName("FileReader: build from file")
	@Test
	void FileReaderTest() throws IOException {
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		CompanyManager c2 = new CompanyManager();
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "01", "02");
		Room r1 = new Room("01", "02", "432");
		Employee e1 = new Employee("Joseph", "1234");
		c2.addBuilding(b);
		c2.addSuite(s1);
		c2.addRoom(r1);
		c2.addEmployee(e1);
		
		File testFile = new File("Report.txt");
		p1.buildFromFile(testFile, c1);
		assertEquals(c1.getBuilding(0), c2.getBuilding(0));
		assertEquals(c1.getSuite(0), c2.getSuite(0));
		assertEquals(c1.getRoom(0), c2.getRoom(0));
		assertEquals(c1.getEmployee(0), c2.getEmployee(0));
		assertEquals(c1.getEmployee(0).getFullAccess().get(0).getRoomNumber(), "432" );
	}
	
	@DisplayName("FileWriter: build access report")
	@Test
	void AccessReportTest() throws IOException {
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		p1.accessRecords(c1);
		File testFile = new File("AccessRecords.txt");
		assertEquals(testFile.exists(), true);
		
	}
	
	@DisplayName("Report H test")
	@Test
	void ReportH() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected = ("Report H: \n" + "Joseph employee #1234 succesfully accessed room #432 in suite #12 in building #01 at: " 
		+ formatter.format(date) + "\n");
		assertEquals(p1.printReportH(c1, "1234"), expected);
	}
	
	@DisplayName("Report I test")
	@Test
	void ReportI() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected = ("Report I: \n" + "Jack employee #1245 failed to access room #432 in suite #12 in building #01 at: "
				+ formatter.format(date) + "\n");
		assertEquals(p1.printReportI(c1, "1245"), expected);
	}
	
	@DisplayName("Report J test")
	@Test
	void ReportJ() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected =  ("Report J: \n" + "Successful Access Attempts to Building #01 Room #432:\n" 
		+ "Joseph employee #1234 at: " + formatter.format(date) + "\n");
		assertEquals(p1.printReportJ(c1, "01", "432"), expected);
	}
	
	@DisplayName("Report K test")
	@Test
	void ReportK() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected = ("Report K: \n" + "Failed Access Attempts to Building #01 Room #432:\n"
				+ "Jack employee #1245 at: " + formatter.format(date) + "\n");
		assertEquals(p1.printReportK(c1, "01", "432"), expected);
	}
	
	@DisplayName("Report L test")
	@Test
	void ReportL() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected = ("Report L: \n" + "Security Alert Break In Attempts to Building #01 Room #432:\n"
				+ "Employee #1244 at: " + formatter.format(date) + "\n");
		assertEquals(p1.printReportL(c1, "01", "432"), expected);
	}
	
	@DisplayName("Report M test")
	@Test
	void ReportM() {	
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		CompanyPersistence p1 = new CompanyPersistence();
		CompanyManager c1 = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1245");
		Building b1 = new Building("VSU", "01");
		Suite s1 = new Suite("ClassRoom", "01", "12");
		Room r1 = new Room("01", "12", "432");
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addBuilding(b1);
		c1.addSuite(s1);
		c1.addRoom(r1);
		e1.addRoomAccess(r1);
		c1.testAccess("1234", "432");
		c1.testAccess("1245", "432");
		c1.testAccess("1244", "432");
		String expected = ("Report M: \n" + "Access Attempts to Building #01 Room #432:\n" + "Employee #1244 at: " + formatter.format(date) + " Security Alert\n"
				+ "Jack employee #1245 at: " + formatter.format(date) + " Failure\n" + "Joseph employee #1234 at: " + formatter.format(date) + " Success\n");
		assertEquals(p1.printReportM(c1, "01", "432"), expected);
	}

}