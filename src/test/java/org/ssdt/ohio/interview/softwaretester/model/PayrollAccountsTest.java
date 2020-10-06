package org.ssdt.ohio.interview.softwaretester.model;

import org.junit.jupiter.api.Test;
import org.ssdt.ohio.interview.softwaretester.constants.JobStatus;
import org.ssdt.ohio.interview.softwaretester.employee.Employee;
import org.ssdt.ohio.interview.softwaretester.position.Position;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PayrollAccountsTest {

    @Test
    void testPositionFactoryWithNoArgs() {
        Position position = Position.create();

        assertFalse(position.isEligibleForSickLeave(), "eligible for sick leave should be defaulted to false");
        assertFalse(position.isEligibleForPersonalLeave(), "eligible for personal leave should be defaulted to false");
        assertFalse(position.isEligibleForVacationLeave(), "eligible for vacation leave should be defaulted to false");
        assertSame(position.getJobStatus(), JobStatus.Active, "job status should default to Active");
        assertEquals(0, (int) position.getNumber(), "number should default to zero");
    }

    @Test
    void testPositionFactoryWithArgs() {
        Employee employee = Employee.create("ANON101", "Test", "Emp");
        Position position = Position.create(employee, 1, JobStatus.Active, true, false, true);

        assertEquals(position.getEmployee(), employee);
        assertEquals(1, (int) position.getNumber());

        assertTrue(position.isEligibleForSickLeave());
        assertTrue(position.isEligibleForVacationLeave());

        assertFalse(position.isEligibleForPersonalLeave());

        assertSame(position.getJobStatus(), JobStatus.Active);
    }

    //TODO: Write unit test to verify findActiveAccounts filters different account sets correctly
    @Test
    void testFindActiveAccounts() {
        fail();
    }

    //TODO: Write unit tests to verify validate accounts method
    @Test
    void testValidateAccounts() {
        fail();
    }
}
