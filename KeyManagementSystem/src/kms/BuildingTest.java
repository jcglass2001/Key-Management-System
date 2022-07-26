package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuildingTest {
	
	@DisplayName("Get building name")
	@Test
	void testGetName() {
		Building b = new Building("Nevins", "02");
		String expected = "Nevins";
		String actual = b.getName();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Correct building code")
	@Test
	void testGetCode_case01() {
		//This case is what we expect; a 2 digit code
		Building b = new Building("Nevins", "02");
		String expected = "02";
		String actual = b.getBuildingCode();
		assertEquals(expected, actual);
	}
	
	@DisplayName("Building code long")
	@Test
	void testGetCode_case02() {
		//This case is if the code is longer than the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Building("Nevins", "022");});
	}
	
	@DisplayName("Building code short")
	@Test
	void testGetCode_case03() {
		//This case is if the code is shorter that the expected format
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Building("Nevins", "2");});
	}
	
	@DisplayName("Building code letters")
	@Test
	void testGetCode_case04() {
		//This case is if the code contains letters instead of numbers
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Building("Nevins", "foo");});
	}

}
