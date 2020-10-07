package org.ssdt.ohio.interview.softwaretester.employee;

import org.ssdt.ohio.interview.softwaretester.AbstractModelObject;

public class Employee extends AbstractModelObject {

    private String number;

    private String firstName;

    private String lastName;

    private boolean archived;

    public Employee() {
        super();
        this.archived = false;
    }

    public Employee archive() {
        this.setArchived(true);
        return this;
    }

    public static Employee create() {
        return new Employee();
    }

    public static Employee create(String number, String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setNumber(number);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
    }

    //Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

}
