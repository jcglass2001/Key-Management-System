package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyManagerTest {

	@DisplayName("Adds buildings // getBuilding")
	@Test
	void AddBuildings() {
		CompanyManager cp = new CompanyManager();
		Building b = new Building("Google", "01");
		cp.getBuildings().add(b);
		assertEquals(cp.getBuilding(0).getName(), "Google");

	}
	
	@DisplayName("Adds suites // getSuite")
	@Test
	void AddSuites() {
		CompanyManager cp = new CompanyManager();
		Suite s = new Suite("Offices", "12", "01");
		cp.getSuites().add(s);
		assertEquals(cp.getSuite(0).getName(), "Offices");
	}
	
	@DisplayName("Adds rooms // getSuite")
	@Test
	void AddRooms() {
		CompanyManager cp = new CompanyManager();
		Room r = new Room("01", "12", "432");
		cp.getRooms().add(r);
		assertEquals(cp.getRoom(0).getRoomNumber(), "432");
	}
	
	@DisplayName("Adds employees // getEmployee")
	@Test
	void AddEmployees() {
		CompanyManager cp = new CompanyManager();
		Employee e = new Employee("Joseph", "1234");
		cp.getEmployees().add(e);
		assertEquals(cp.getEmployee(0).getName(), "Joseph");
	}
	
	@DisplayName("Removes buildings // getNumBuildings")
	@Test
	void RemBuildings() {
		CompanyManager cp = new CompanyManager();
		Building b1 = new Building("Google", "01");
		Building b2 = new Building("Facebook", "02");
		cp.getBuildings().add(b1);
		cp.getBuildings().add(b2);
		cp.getBuildings().remove(b2);
		assertEquals(cp.getNumBuildings(), 1);

	}
	
	@DisplayName("Removes suites // getNumSuites")
	@Test
	void RemSuites() {
		CompanyManager cp = new CompanyManager();
		Suite s1 = new Suite("Offices", "12", "01");
		Suite s2 = new Suite("Execs", "12", "02");
		cp.getSuites().add(s1);
		cp.getSuites().add(s2);
		cp.getSuites().remove(s2);
		assertEquals(cp.getNumSuites(), 1);
	}
	
	@DisplayName("Removes rooms // getNumRooms")
	@Test
	void RemRooms() {
		CompanyManager cp = new CompanyManager();
		Room r1 = new Room("01", "12", "432");
		Room r2 = new Room("01", "12", "433");
		cp.getRooms().add(r1);
		cp.getRooms().add(r2);
		cp.getRooms().remove(r2);
		assertEquals(cp.getNumRooms(), 1);
	}
	
	@DisplayName("Removes employees // getNumEmployees")
	@Test
	void RemEmployees() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1235");
		cp.getEmployees().add(e1);
		cp.getEmployees().add(e2);
		cp.getEmployees().remove(e2);
		assertEquals(cp.getNumEmployees(), 1);
	}
	
	@DisplayName("Clears lists")
	@Test
	void Clear() {
		CompanyManager cp = new CompanyManager();
		Building b1 = new Building("Google", "01");
		Building b2 = new Building("Facebook", "02");
		Suite s1 = new Suite("Offices", "12", "01");
		Suite s2 = new Suite("Execs", "12", "02");
		Room r1 = new Room("01", "12", "432");
		Room r2 = new Room("01", "12", "433");
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1235");
		cp.getBuildings().add(b1);
		cp.getBuildings().add(b2);
		cp.getSuites().add(s1);
		cp.getSuites().add(s2);
		cp.getRooms().add(r1);
		cp.getRooms().add(r2);
		cp.getEmployees().add(e1);
		cp.getEmployees().add(e2);
		cp.clear();
		assertEquals(cp.getNumBuildings(), 0);
		assertEquals(cp.getNumSuites(), 0);
		assertEquals(cp.getNumRooms(), 0);
		assertEquals(cp.getNumEmployees(), 0);
	}
	
	@DisplayName("Contains building")
	@Test
	void ConBuilding() {
		CompanyManager cp = new CompanyManager();
		Building b1 = new Building("Google", "01");
		Building b2 = new Building("Facebook", "02");
		cp.getBuildings().add(b1);
		cp.getBuildings().add(b2);
		assertEquals(cp.containsBuilding(b1.getName(), b1.getBuildingCode()), true);
	}
	
	@DisplayName("Contains suite")
	@Test
	void ConSuite() {
		CompanyManager cp = new CompanyManager();
		Suite s1 = new Suite("Offices", "12", "01");
		Suite s2 = new Suite("Execs", "12", "02");
		cp.getSuites().add(s1);
		cp.getSuites().add(s2);
		assertEquals(cp.containsSuite(s1.getName(), s1.getBuildingCode(), s1.getSuiteCode()), true);
	}
	
	@DisplayName("Contains room")
	@Test
	void ConRoom() {
		CompanyManager cp = new CompanyManager();
		Room r1 = new Room("01", "12", "432");
		Room r2 = new Room("01", "12", "433");
		cp.getRooms().add(r1);
		cp.getRooms().add(r2);
		assertEquals(cp.containsRoom(r1.getBuildingCode(), r1.getSuiteCode(), r1.getRoomNumber()), true);
	}
	
	@DisplayName("Contains employee")
	@Test
	void ConEmployee() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1235");
		cp.getEmployees().add(e1);
		cp.getEmployees().add(e2);
		assertEquals(cp.containsEmployee(e1.getName(), e1.getId()), true);
	}
	
	@DisplayName("Search for employee with ID: employee exists")
	@Test
	void searchEmployeeExists() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1235");
		Employee e3 = new Employee("Edward", "0225");
		cp.getEmployees().add(e1);
		cp.getEmployees().add(e2);
		cp.getEmployees().add(e3);
		assertEquals(cp.getEmployeeById("0225"), 2);
	}
	
	@DisplayName("Search for employee with ID: employee does not exists")
	@Test
	void searchEmployeeDoesNotExist() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Employee e2 = new Employee("Jack", "1235");
		Employee e3 = new Employee("Edward", "0225");
		cp.getEmployees().add(e1);
		cp.getEmployees().add(e2);
		cp.getEmployees().add(e3);
		assertEquals(cp.getEmployeeById("6549"), -1);
	}
	
	@DisplayName("Test Employee Access: Pass")
	@Test
	void testEmployeePass() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Room r = new Room("12", "12", "123");
		cp.getEmployees().add(e1);
		e1.addRoomAccess(r);
		assertEquals(cp.testAccess("1234", "123"), "Success");
	}
	
	@DisplayName("Test Employee Access: Fail")
	@Test
	void testEmployeeFail() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Room r = new Room("12", "12", "123");
		cp.getEmployees().add(e1);
		e1.addRoomAccess(r);
		assertEquals(cp.testAccess("1234", "122"), "Failure");
		
	}
	
	@DisplayName("Test Employee Access: Security Alert")
	@Test
	void testEmployeeNotFound() {
		CompanyManager cp = new CompanyManager();
		Employee e1 = new Employee("Joseph", "1234");
		Room r = new Room("12", "12", "123");
		assertEquals(cp.testAccess("1234", "123"), "Security Alert: employee ID not recognized");
		
	}
	
}
