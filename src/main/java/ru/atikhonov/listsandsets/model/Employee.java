package ru.atikhonov.listsandsets.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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
