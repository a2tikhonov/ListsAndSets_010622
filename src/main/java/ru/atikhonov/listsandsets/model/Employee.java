package ru.atikhonov.listsandsets.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private int salary;
    private int department;

    public Employee(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this(lastName, firstName, middleName);
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override
    public boolean equals(Object object) {
        if (this.getClass() != object.getClass()) return false;
        return lastName.equals(((Employee) object).lastName) && firstName.equals(((Employee) object).firstName);
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


}
