package ru.atikhonov.listsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atikhonov.listsandsets.model.Employee;
import ru.atikhonov.listsandsets.services.EmployeeServiceImpl;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee showAddedEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                      @RequestParam String middleName, @RequestParam int department,
                                      @RequestParam int salary) {
        return employeeService.add(firstName, lastName, middleName, department, salary);
    }

    @GetMapping("/remove")
    public Employee showRemovedEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String middleName) {
        return employeeService.rm(firstName, lastName, middleName);
    }

    @GetMapping("/find")
    public Employee showFoundEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String middleName) {
        return employeeService.find(firstName, lastName, middleName);
    }

    @GetMapping("/print")
    public Map<String, Employee> showAllEmployees() {
        return employeeService.print();
    }

}
