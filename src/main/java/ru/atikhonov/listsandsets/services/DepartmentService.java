package ru.atikhonov.listsandsets.services;

import ru.atikhonov.listsandsets.model.Employee;

import java.util.List;

public interface DepartmentService {
    public Employee maxSalary(int department);

    public Employee minSalary(int department);

    public List<Employee> print(int department);

    public List<Employee> print();
}
