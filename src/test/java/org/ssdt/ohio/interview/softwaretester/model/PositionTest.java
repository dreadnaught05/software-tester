package org.ssdt.ohio.interview.softwaretester.model;

import org.junit.jupiter.api.Test;
import org.ssdt.ohio.interview.softwaretester.constants.JobStatus;
import org.ssdt.ohio.interview.softwaretester.employee.Employee;
import org.ssdt.ohio.interview.softwaretester.position.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void testPositionFactoryWithNoArgs() {
        Position position = Position.create();

        assertFalse(position.isEligibleForSickLeave(), "eligible for sick leave should be defaulted to false");
        assertFalse(position.isEligibleForPersonalLeave(), "eligible for personal leave should be defaulted to false");
        assertFalse(position.isEligibleForVacationLeave(), "eligible for vacation leave should be defaulted to false");
        assertEquals(position.getJobStatus(), JobStatus.Active, "job status should default to Active");
        assertEquals(0, (int) position.getNumber(), "number should default to zero");
    }

    @Test
    void testPositionFactoryWithArgs() {
        Employee employee = Employee.create("ANON101", "Test", "Emp");
        Position position = Position.create(employee, 1, JobStatus.Active, true, false, true);

        assertEquals(position.getEmployee(), employee);
        assertEquals(1, (int) position.getNumber());
        assertEquals(position.getJobStatus(), JobStatus.Active);

        assertTrue(position.isEligibleForSickLeave());
        assertTrue(position.isEligibleForVacationLeave());

        assertFalse(position.isEligibleForPersonalLeave());
    }

    @Test
    void testPositionIsEligibleForLeaveReturnsFalseForArchivedEmployee() {
        //TODO: Write unit tests to verify the Position isEligibleForLeave(AttendanceItemCategory) returns false for an archived employee
        fail();
    }

    @Test
    void testPositionIsEligibleForLeaveReturnsFalseForTerminatedPosition() {
        //TODO: Write unit tests to verify the Position isEligibleForLeave(AttendanceItemCategory) returns false for a Terminated Position
        fail();
    }

    @Test
    void testPositionIsEligibleForLeaveReturnsFalseForDeceasedPosition() {
        //TODO: Write unit tests to verify the Position isEligibleForLeave(AttendanceItemCategory) returns false for a Deceased Position
        fail();
    }

    @Test
    void testPositionIsEligibleForLeaveReturnsFalseForInvalidLeaveEligibility() {
        //TODO: Write unit tests to verify the Position isEligibleForLeave(AttendanceItemCategory) returns false for Positions not eligible for leave
        fail();
    }

    @Test
    void testPositionIsEligibleForLeaveReturnsTrueForLeaveEligibility() {
        //TODO: Write unit tests to verify the Position isEligibleForLeave(AttendanceItemCategory) returns true for Positions eligible for leave
        fail();
    }


}
