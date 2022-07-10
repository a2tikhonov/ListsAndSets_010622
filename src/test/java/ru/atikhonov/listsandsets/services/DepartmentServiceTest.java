package ru.atikhonov.listsandsets.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.atikhonov.listsandsets.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ru.atikhonov.listsandsets.constants.ConstantsForEmployeeAndDepartmentServicesTests.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private static final Map<String, Employee> expectedMap = new HashMap<>();


    @Mock
    private  EmployeeServiceImpl employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void initEmployeesMap() {
        expectedMap.put(EMPLOYEE1.toString(), EMPLOYEE1);
        expectedMap.put(EMPLOYEE2.toString(), EMPLOYEE2);
        expectedMap.put(EMPLOYEE3.toString(), EMPLOYEE3);
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        when(employeeServiceMock.print())
                .thenReturn(expectedMap);
        assertEquals(EMPLOYEE1, out.maxSalary(employees7Department));
    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        when(employeeServiceMock.print())
                .thenReturn(expectedMap);
        assertEquals(EMPLOYEE2, out.minSalary(employees7Department));
    }

    @Test
    void shouldPrintAllEmployeesByDepartmentAsList() {
        List<Employee> expectedEmployees = expectedMap.entrySet().stream()
                .map(p -> p.getValue())
                .filter(e -> e.getDepartment() == employees7Department).collect(Collectors.toList());
        when(employeeServiceMock.print())
                .thenReturn(expectedMap);
        assertThat(expectedEmployees).hasSameElementsAs(out.print(employees7Department));
    }

    @Test
    void shouldPrintAllEmployeesAsList() {
        List<Employee> expectedEmployees = expectedMap.entrySet().stream()
                .map(p -> p.getValue())
                .collect(Collectors.toList());
        when(employeeServiceMock.print())
                .thenReturn(expectedMap);
        assertThat(expectedEmployees).hasSameElementsAs(out.print());
    }

}