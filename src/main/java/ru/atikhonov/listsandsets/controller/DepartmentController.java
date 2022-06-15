package ru.atikhonov.listsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atikhonov.listsandsets.model.Employee;
import ru.atikhonov.listsandsets.services.DepartmentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/allByDepartment")
    public List<Employee> print(@RequestParam int departmentId) {
        return departmentService.print(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> print() {
        return departmentService.print();
    }

}
