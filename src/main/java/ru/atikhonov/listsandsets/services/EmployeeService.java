package ru.atikhonov.listsandsets.services;

import ru.atikhonov.listsandsets.model.Employee;
import java.util.Map;

public interface EmployeeService {

    Employee add(String lastName, String firstName, String middleName, int department, int salary);

    Employee rm(String lastName, String firstName, String middleName);

    Employee find(String lastName, String firstName, String middleName);

    Map<String, Employee> print();

}
