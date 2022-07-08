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
	
	@DisplayName("getAccess: Buildings Only")
	@Test
	void testBuildingsOnly(){
		
	}
	
	@DisplayName("getAccess: Suites Only")
	@Test
	void testSuitesOnly(){
		
	}
	
	@DisplayName("getAccess: Rooms Only")
	@Test
	void testRoomsOnly(){
		
	}
	
	@DisplayName("getAccess: Buildings and Suites")
	@Test
	void testBuildingsAndSuites(){
		
	}
	
	@DisplayName("getAccess: Buildings and Rooms")
	@Test
	void testBuildingsAndRooms(){
		
	}
	
	@DisplayName("getAccess: Suites and Rooms")
	@Test
	void testSuitesAndRooms(){
		
	}
	
	@DisplayName("getAccess: Buildings, Suites, and Rooms")
	@Test
	void testBuildingsSuitessAndRooms(){
		
	}


}
