package ru.atikhonov.listsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atikhonov.listsandsets.model.Employee;
import ru.atikhonov.listsandsets.services.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee showAddedEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee showRemovedEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.rm(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee showFoundEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/print")
    public List<Employee> showAllEmployees() {
        return employeeService.print();
    }

}
