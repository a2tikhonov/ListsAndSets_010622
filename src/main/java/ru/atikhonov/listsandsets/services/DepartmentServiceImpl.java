package ru.atikhonov.listsandsets.services;

import org.springframework.stereotype.Service;
import ru.atikhonov.listsandsets.exceptions.EmployeeNotFoundException;
import ru.atikhonov.listsandsets.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int department) {
        return employeeService.print().entrySet().stream().map(p -> p.getValue())
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(c -> c.getSalary())).orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee minSalary(int department) {
        return employeeService.print().entrySet().stream().map(p -> p.getValue())
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(c -> c.getSalary())).orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> print(int department) {
        return employeeService.print().entrySet().stream().map(p -> p.getValue())
                .filter(e -> e.getDepartment() == department).collect(Collectors.toList());
    }

    public List<Employee> print() {
        return employeeService.print().entrySet().stream().map(p -> p.getValue())
                .sorted(Comparator.comparing(c -> c.getDepartment())).collect(Collectors.toList());
    }

}
