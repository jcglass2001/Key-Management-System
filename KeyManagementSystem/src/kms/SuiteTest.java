package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuiteTest {
	
	@Test
	void testConstructorEmpty() {
		//This case tests for empty strings
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("", "02", "01");});
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "", "01");});
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "02", "");});
	}
	
	@Test
	void testConstructorNormal() {
		//This case test for constructor creation
		Suite s = new Suite("Sales Suite", "02", "01");
		assertEquals("Sales Suite",s.getName());
		assertEquals("02",s.getSuiteCode());
		assertEquals("01",s.getBuildingCode());
		
	}
	
	@Test
	void testGetName() {
		//This case tests if name can be retrieved
		Suite s = new Suite("Sales Suite", "02", "01");
		String expected = "Sales Suite";
		String actual = s.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSuiteCode_correct() {
		//This case is what we expect; a 2 digit code
		Suite s = new Suite("Sales Suite", "02", "01");
		String expected = "02";
		String actual = s.getSuiteCode();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSuiteCode_long() {
		//This case is if the code is longer than the expected format
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "200", "01");});
	}
	
	@Test
	void testGetSuiteCode_short() {
		//This case is if the code is shorter that the expected format
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "1", "01");});
	}
	
	@Test
	void testGetSuiteCode_letters() {
		//This case is if the code contains letters instead of numbers
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "ab", "01");});
	}
	
	@Test
	void testGetBuildingCode_correct() {
		//This case is what we expect; a 2 digit code
		Suite s = new Suite("Sales Suite", "02", "01");
		String expected = "01";
		String actual = s.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetBuildingCode_long() {
		//This case is if the code is longer than the expected format
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "02", "100");});
	}
	
	@Test
	void testGetBuildingCode_short() {
		//This case is if the code is shorter that the expected format
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "02", "1");});
	}
	
	@Test
	void testGetBuildingCode_letters() {
		//This case is if the code contains letters instead of numbers
		Assertions.assertThrows(RuntimeException.class, () -> {new Suite("Sales Suite", "02", "cd");});
	}

}
