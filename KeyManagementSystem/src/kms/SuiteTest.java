package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SuiteTest {
	
	@DisplayName("Empty constructor")
	@Test
	void testConstructorEmpty() {
		//This case tests for empty strings
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("", "02", "01");});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "", "01");});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "02", "");});
	}
	
	@DisplayName("Normal constructor")
	@Test
	void testConstructorNormal() {
		//This case test for constructor creation
		Suite s = new Suite("Sales Suite", "02", "01");
		assertEquals("Sales Suite",s.getName());
		assertEquals("01",s.getSuiteCode());
		assertEquals("02",s.getBuildingCode());
		
	}
	
	@DisplayName("Get suite name")
	@Test
	void testGetName() {
		//This case tests if name can be retrieved
		Suite s = new Suite("Sales Suite", "02", "01");
		String expected = "Sales Suite";
		String actual = s.getName();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Correct suite code")
	@Test
	void testGetSuiteCode_correct() {
		//This case is what we expect; a 2 digit code
		Suite s = new Suite("Sales Suite", "01", "02");
		String expected = "02";
		String actual = s.getSuiteCode();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Suite code long")
	@Test
	void testGetSuiteCode_long() {
		//This case is if the code is longer than the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "01", "200");});
	}
	
	@DisplayName("Suite code short")
	@Test
	void testGetSuiteCode_short() {
		//This case is if the code is shorter that the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "01", "1");});
	}
	
	@DisplayName("Suite code letters")
	@Test
	void testGetSuiteCode_letters() {
		//This case is if the code contains letters instead of numbers
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "01", "ab");});
	}
	
	@DisplayName("Correct building code")
	@Test
	void testGetBuildingCode_correct() {
		//This case is what we expect; a 2 digit code
		Suite s = new Suite("Sales Suite", "01", "02");
		String expected = "01";
		String actual = s.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Building code long")
	@Test
	void testGetBuildingCode_long() {
		//This case is if the code is longer than the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "100", "02");});
	}
	
	@DisplayName("Building code short")
	@Test
	void testGetBuildingCode_short() {
		//This case is if the code is shorter that the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "1", "02");});
	}
	
	@DisplayName("Building code letters")
	@Test
	void testGetBuildingCode_letters() {
		//This case is if the code contains letters instead of numbers
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Suite("Sales Suite", "cd", "02");});
	}

}
