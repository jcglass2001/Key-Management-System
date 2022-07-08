package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("Constructor: Empty string")
	@Test
	void testConstructorEmptyString() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("","5432");});
	}
	@DisplayName("Constructor: id = \"\"")
	@Test
	void testConstructorIdSetToNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus","");});
	}

	@DisplayName("Constructor: id < 4 digits")
	@Test
	void testConstructorIdLessThan4Digits() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus","999");});
	}
	
	@DisplayName("Constructor: id > 4 digits")
	@Test
	void testConstructorIdGreaterThan4Digits() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus","10000");});
	}

	@DisplayName("Constructor: saves instance vars")
	@Test
	void testConstructorNormal() {
		Employee e = new Employee("Markus", "5432");
		assertEquals("Markus",e.getName());
		assertEquals("5432",e.getId());	
	}
	
	@DisplayName("add building access: code < 2")
	@Test
	void testAddBuildingAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("building", "1");});
	}
	
	@DisplayName("add building access: code > 2")
	@Test
	void testAddBuildingAccessCodeGreaterThan2() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("building", "123");});
	}
	
	@DisplayName("add suite access: code < 2")
	@Test
	void testAddSuiteAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("suite", "1");});
	}
	
	@DisplayName("add suite access: code > 2")
	@Test
	void testAddSuiteAccessCodeGreaterThan2() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("suite", "123");});
	}
	
	@DisplayName("add room access: code < 3")
	@Test
	void testAddRoomAccessCodeLessThan3() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("room", "12");});
	}
	
	@DisplayName("add room access: code > 3")
	@Test
	void testAddRoomAccessCodeGreaterThan3() {
		Employee e = new Employee("Markus", "5432");
		Assertions.assertThrows(RuntimeException.class, () -> {e.addAccess("room", "1234");});
	}
	
	@DisplayName("getAccess: Buildings Only")
	@Test
	void testBuildingsOnly(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("building", "12");
		e.addAccess("building", "21");
		e.addAccess("building", "02");
		String[][] accessList = e.getAccess();
		assertEquals("12", accessList[0][0]);
		assertEquals("21", accessList[0][1]);
		assertEquals("02", accessList[0][2]);
	}
	
	@DisplayName("getAccess: Suites Only")
	@Test
	void testSuitesOnly(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("suite", "12");
		e.addAccess("suite", "21");
		e.addAccess("suite", "02");
		String[][] accessList = e.getAccess();
		assertEquals("12", accessList[1][0]);
		assertEquals("21", accessList[1][1]);
		assertEquals("02", accessList[1][2]);
	}
	
	@DisplayName("getAccess: Rooms Only")
	@Test
	void testRoomsOnly(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("room", "123");
		e.addAccess("room", "213");
		e.addAccess("room", "023");
		String[][] accessList = e.getAccess();
		assertEquals("123", accessList[2][0]);
		assertEquals("213", accessList[2][1]);
		assertEquals("023", accessList[2][2]);
	}
	
	@DisplayName("getAccess: Buildings and Suites")
	@Test
	void testBuildingsAndSuites(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("building", "12");
		e.addAccess("suite", "21");
		e.addAccess("building", "02");
		String[][] accessList = e.getAccess();
		assertEquals("12", accessList[0][0]);
		assertEquals("21", accessList[1][0]);
		assertEquals("02", accessList[0][1]);
	}
	
	@DisplayName("getAccess: Buildings and Rooms")
	@Test
	void testBuildingsAndRooms(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("room", "123");
		e.addAccess("building", "21");
		e.addAccess("building", "02");
		String[][] accessList = e.getAccess();
		assertEquals("123", accessList[2][0]);
		assertEquals("21", accessList[0][0]);
		assertEquals("02", accessList[0][1]);
	}
	
	@DisplayName("getAccess: Suites and Rooms")
	@Test
	void testSuitesAndRooms(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("room", "123");
		e.addAccess("suite", "21");
		e.addAccess("suite", "02");
		String[][] accessList = e.getAccess();
		assertEquals("123", accessList[2][0]);
		assertEquals("21", accessList[1][0]);
		assertEquals("02", accessList[1][1]);
	}
	
	@DisplayName("getAccess: Buildings, Suites, and Rooms")
	@Test
	void testBuildingsSuitessAndRooms(){
		Employee e = new Employee("Markus", "5432");
		e.addAccess("room", "123");
		e.addAccess("suite", "21");
		e.addAccess("building", "02");
		String[][] accessList = e.getAccess();
		assertEquals("123", accessList[2][0]);
		assertEquals("21", accessList[1][0]);
		assertEquals("02", accessList[0][0]);
	}


}
