package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingTest {

	@Test
	void testGetName() {
		Building b = new Building("Nevins", "02");
		String expected = "Nevins";
		String actual = b.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCode_case01() {
		//This case is what we expect; a 2 digit code
		Building b = new Building("Nevins", "02");
		String expected = "02";
		String actual = b.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCode_case02() {
		//This case is if the code is longer than the expected format
		Building b = new Building("Nevins", "022");
		String expected = "Building code must be exactly 2 digits";
		String actual = b.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCode_case03() {
		//This case is if the code is shorter that the expected format
		Building b = new Building("Nevins", "2");
		String expected = "Building code must be exactly 2 digits";
		String actual = b.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCode_case04() {
		//This case is if the code contains letters instead of numbers
		Building b = new Building("Nevins", "foo");
		String expected = "Building code must only contain digits";
		String actual = b.getBuildingCode();
		assertEquals(expected, actual);
	}

}
