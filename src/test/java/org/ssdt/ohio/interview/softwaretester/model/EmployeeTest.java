package org.ssdt.ohio.interview.softwaretester.model;

import org.junit.jupiter.api.Test;
import org.ssdt.ohio.interview.softwaretester.employee.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void testEmployeeFactoryWithNoArgs() {
        Employee employee = Employee.create();

        assertFalse(employee.isArchived());
    }

    @Test
    void testEmployeeFactoryWithArgs() {
        Employee employee = Employee.create("ANON1000",  "Test", "Emp");

        assertFalse(employee.isArchived());
        assertEquals(employee.getNumber(), "ANON1000");
        assertEquals(employee.getFirstName(), "Test");
        assertEquals(employee.getLastName(), "Emp");
    }

    @Test
    void testArchiveEmployee() {
        Employee employee = Employee.create("ANON1000",  "Test", "Emp");

        assertFalse(employee.isArchived());
        assertEquals(employee.getNumber(), "ANON1000");
        assertEquals(employee.getFirstName(), "Test");
        assertEquals(employee.getLastName(), "Emp");

        employee.archive();

        assertTrue(employee.isArchived());
    }
}
