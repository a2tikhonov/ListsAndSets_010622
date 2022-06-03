package ru.atikhonov.listsandsets.services;

import ru.atikhonov.listsandsets.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee rm(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> print();

}
