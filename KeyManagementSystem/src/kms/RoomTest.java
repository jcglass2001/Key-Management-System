package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoomTest {
	
	@DisplayName("Missing building code")
	@Test
	void testMissingBuilding() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("","12", "123");});
	}
	
	@DisplayName("Missing suite code")
	@Test
	void testMissingSuite() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","", "123");});
	}
	
	@DisplayName("Missing room number")
	@Test
	void testMissingRoom() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","12", "");});
	}
	
	@DisplayName("Too many digits in building code")
	@Test
	void testTooManyDigitsBuilding() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12345","12", "123");});
	}
	
	@DisplayName("Too many digits in suite code")
	@Test
	void testTooManyDigitsSuite() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","12345", "123");});
	}
	
	@DisplayName("Too many digits in room number")
	@Test
	void testTooManyDigitsRoom() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","12", "12345");});
	}
	
	@DisplayName("Not enough digits in building code")
	@Test
	void testNotEnoughDigitsBuilding() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("1","12", "123");});
	}
	
	@DisplayName("Not enough digits in suite code")
	@Test
	void testNotEnoughDigitsSuite() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","1", "123");});
	}
	
	@DisplayName("Not enough digits in room number")
	@Test
	void testNotEnoughDigitsRoom() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Room("12","12", "1");});
	}
	
	@DisplayName("Constructor: saves instance vars")
	@Test
	void testConstructorNormal() {
		Room r = new Room("12", "21", "123");
		assertEquals("12", r.getBuildingCode());
		assertEquals("21", r.getSuiteCode());
		assertEquals("123", r.getRoomNumber());
	}

}
