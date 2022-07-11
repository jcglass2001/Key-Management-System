package kms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyTest {

	@DisplayName("saves instance vars")
	@Test
	void test() {
		Company c1 = new Company();
		Building b = new Building("Google", "01");
		Suite s1 = new Suite("Offices", "12", "01");
		Room r1 = new Room("01", "12", "432");
		Employee e1 = new Employee("Joseph", "1234");
		c1.getBuildings().add(b);
		c1.getSuites().add(s1);
		c1.getRooms().add(r1);
		c1.getEmployees().add(e1);
		assertEquals(c1.getBuildings().get(0).getName(), "Google");
		assertEquals(c1.getSuites().get(0).getName(), "Offices");
		assertEquals(c1.getRooms().get(0).getRoomNumber(), "432");
		assertEquals(c1.getEmployees().get(0).getName(), "Joseph");

	}

}
