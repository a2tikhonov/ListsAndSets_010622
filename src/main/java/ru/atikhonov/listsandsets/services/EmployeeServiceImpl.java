package ru.atikhonov.listsandsets.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.atikhonov.listsandsets.exceptions.EmployeeAlreadyAddedException;
import ru.atikhonov.listsandsets.exceptions.EmployeeIncorrectDataException;
import ru.atikhonov.listsandsets.exceptions.EmployeeNotFoundException;
import ru.atikhonov.listsandsets.model.Employee;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Employee add(String lastName, String firstName, String middleName, int department, int salary) {
        if (!StringUtils.isAlpha(lastName + firstName + middleName)){ throw new EmployeeIncorrectDataException();}
        final Employee employee = new Employee(StringUtils.capitalize(StringUtils.lowerCase(lastName))
                , StringUtils.capitalize(StringUtils.lowerCase(firstName))
                , StringUtils.capitalize(StringUtils.lowerCase(middleName))
                , department, salary);
        if (!employees.containsKey(employee.toString())) {
            employees.put(employee.toString(), employee);
        } else {
            throw new EmployeeAlreadyAddedException();
        }
        return employee;
    }

    public Employee rm(String lastName, String firstName, String middleName) {
        final Employee employee = new Employee(lastName, firstName, middleName);
        if (employees.containsKey(employee.toString())) {
            return employees.remove(employee.toString());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee find(String lastName, String firstName, String middleName) {
        Employee employee = new Employee(lastName, firstName, middleName);
        if (employees.containsKey(employee.toString())) {
            return employees.get(employee.toString());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Map<String, Employee> print() {
        return Map.copyOf(employees);
    }

}
