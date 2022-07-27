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
	
	@DisplayName("Remove building access")
	@Test
	void testRemoveBuildingAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Building b1 = new Building("Offices", "12");
		Building b2 = new Building("Bathrooms", "13");
		e.addBuildingAccess(b1);
		e.addBuildingAccess(b2);
		e.removeBuildingAccess(b1);
		assertEquals(e.getBuildingAccess().get(0), b2);
	}
	
	@DisplayName("Remove suite access")
	@Test
	void testRemoveSuiteAccessCodeLessThan2() {
		Employee e = new Employee("Markus", "5432");
		Suite s1 = new Suite("Lobby", "12", "14");
		Suite s2 = new Suite("Kitchen", "12", "13");
		e.addSuiteAccess(s1);
		e.addSuiteAccess(s2);
		e.removeSuiteAccess(s1);
		assertEquals(e.getSuiteAccess().get(0), s2);
	}
	
	@DisplayName("Remove room access")
	@Test
	void testRemoveRoomAccessCodeGreaterThan3() {
		Employee e = new Employee("Markus", "5432");
		Room r1 = new Room("12", "12", "123");
		Room r2 = new Room("12", "12", "124");
		e.addRoomAccess(r1);
		e.addRoomAccess(r2);
		e.removeRoomAccess(r1);
		assertEquals(e.getRoomAccess().get(0), r2);
	}
}