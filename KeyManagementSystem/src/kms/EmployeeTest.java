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
	
	@DisplayName("Add building access // get building access")
	@Test
	void testAddBuildingAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Building b = new Building("Offices", "12");
		e.addBuildingAccess(b);
		assertEquals(e.getBuildingAccess().get(0), b);
	}
	
	@DisplayName("Add suite access // get suite access")
	@Test
	void testAddSuiteAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Suite s = new Suite("Lobby", "12", "14");
		e.addSuiteAccess(s);
		assertEquals(e.getSuiteAccess().get(0), s);
	}
	
	@DisplayName("Add room access // get room access")
	@Test
	void testAddRoomAccessCodeGreaterThan3() {
		Employee e = new Employee("Markus", "5432");
		Room r = new Room("12", "12", "123");
		e.addRoomAccess(r);
		assertEquals(e.getRoomAccess().get(0), r);
	}
	
}
