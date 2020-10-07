package org.ssdt.ohio.interview.softwaretester.position;

import org.ssdt.ohio.interview.softwaretester.AbstractModelObject;
import org.ssdt.ohio.interview.softwaretester.constants.AttendanceItemCategory;
import org.ssdt.ohio.interview.softwaretester.constants.JobStatus;
import org.ssdt.ohio.interview.softwaretester.employee.Employee;

public class Position extends AbstractModelObject {

    private Employee employee;

    private Integer number;

    private boolean eligibleForSickLeave;

    private boolean eligibleForPersonalLeave;

    private boolean eligibleForVacationLeave;

    private JobStatus jobStatus;

    Position() {
        super();
        this.eligibleForSickLeave = false;
        this.eligibleForPersonalLeave = false;
        this.eligibleForVacationLeave = false;
        this.jobStatus = JobStatus.Active;
        this.number = 0;
    }

    /**
     * Validates if this Position is eligible for the passed Attendance Item Category.
     * An archived Employee and job status of either Terminated or Deceased will always be ineligible for leave.
     *
     * @param category The Attendance Item Category of leave used.
     * @return true if the position is eligible, false if ineligible.
     */
    boolean isEligibleForLeave(AttendanceItemCategory category) {
        if (getEmployee().isArchived() || getJobStatus() == JobStatus.Terminated || getJobStatus() == JobStatus.Deceased) {
            return false;
        }
        switch (category) {
            case Sick: return isEligibleForSickLeave();
            case Personal: return isEligibleForPersonalLeave();
            case Vacation: return isEligibleForVacationLeave();
            default: return true;
        }
    }

    //Factories
    public static Position create() {
        return new Position();
    }

    public static Position create(Employee emp, Integer number, JobStatus status,
                                  boolean eligibleForSickLeave, boolean eligibleForPersonalLeave,
                                  boolean eligibleForVacationLeave) {
        Position position = create();
        position.setEmployee(emp);
        position.setNumber(number);
        position.setJobStatus(status);
        position.setEligibleForSickLeave(eligibleForSickLeave);
        position.setEligibleForPersonalLeave(eligibleForPersonalLeave);
        position.setEligibleForVacationLeave(eligibleForVacationLeave);
        return position;
    }

    //Getters and Setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isEligibleForSickLeave() {
        return eligibleForSickLeave;
    }

    public void setEligibleForSickLeave(boolean eligibleForSickLeave) {
        this.eligibleForSickLeave = eligibleForSickLeave;
    }

    public boolean isEligibleForPersonalLeave() {
        return eligibleForPersonalLeave;
    }

    public void setEligibleForPersonalLeave(boolean eligibleForPersonalLeave) {
        this.eligibleForPersonalLeave = eligibleForPersonalLeave;
    }

    public boolean isEligibleForVacationLeave() {
        return eligibleForVacationLeave;
    }

    public void setEligibleForVacationLeave(boolean eligibleForVacationLeave) {
        this.eligibleForVacationLeave = eligibleForVacationLeave;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
}
