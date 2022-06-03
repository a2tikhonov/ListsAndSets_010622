package ru.atikhonov.listsandsets.services;

import org.springframework.stereotype.Service;
import ru.atikhonov.listsandsets.model.Employee;
import ru.atikhonov.listsandsets.exceptions.EmployeeAlreadyAddedException;
import ru.atikhonov.listsandsets.exceptions.EmployeeNotFoundException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final LinkedList<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new LinkedList<>();
    }

    @Override
    public List<Employee> print() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
            return employees.getLast();
        }
    }

    @Override
    public Employee rm(String firstName, String lastName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.remove(employee)) {
            return employee;
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.contains(employee)) {
            return employee;
        } else throw new EmployeeNotFoundException();
    }
}
