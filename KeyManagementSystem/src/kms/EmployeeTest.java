package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	@DisplayName("Constructor: Empty string")
	@Test
	void testConstructorEmptyString() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("",5432);});
	}
	@DisplayName("Constructor: id = 0")
	@Test
	void testConstructorPayrateLess0() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus",0);});
	}

	@DisplayName("Constructor: id < 1000")
	@Test
	void testConstructorIdLessThan1000() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus",999);});
	}
	
	@DisplayName("Constructor: id > 9999")
	@Test
	void testConstructorPayrateGreaterThan9999() {
		Assertions.assertThrows(RuntimeException.class, () -> {new Employee("Markus",10000);});
	}

	@DisplayName("Constructor: saves instance vars")
	@Test
	void testConstructorNormal() {
		Employee e = new Employee("Markus", 5432);
		assertEquals("Markus",e.getName());
		assertEquals(5432,e.getId());	
	}


}
