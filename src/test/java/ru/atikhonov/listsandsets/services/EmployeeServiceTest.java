package ru.atikhonov.listsandsets.services;

import org.junit.jupiter.api.Test;
import ru.atikhonov.listsandsets.exceptions.EmployeeAlreadyAddedException;
import ru.atikhonov.listsandsets.exceptions.EmployeeNotFoundException;
import ru.atikhonov.listsandsets.model.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    static final String FIRST_NAME = "Александр";
    static final String MIDDLE_NAME = "Александрович";
    static final String LAST_NAME = "Тихонов";
    static final int DEPARTMENT = 7;
    static final int SALARY = 150_000;

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    private final Employee expectedEmployee = new Employee(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);


    @Test
    void shouldReturnAddedEmployee() {
        assertEquals(expectedEmployee, out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldReturnEmployeeAlreadyAddedExceptionWhenAttemptToAdd() {
        out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldReturnRemovedEmployee() {
        out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        assertEquals(expectedEmployee, out.rm(LAST_NAME, FIRST_NAME, MIDDLE_NAME));
    }

    @Test
    void shouldReturnEmployeeNotFoundExceptionWhenAttemptToRemove() {
        assertThrows(EmployeeNotFoundException.class, () -> out.rm(LAST_NAME, FIRST_NAME, MIDDLE_NAME));
    }

    @Test
    void shouldReturnFoundEmployee() {
        out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        assertEquals(expectedEmployee, out.find(LAST_NAME, FIRST_NAME, MIDDLE_NAME));
    }

    @Test
    void shouldReturnEmployeeNotFoundExceptionWhenAttemptToFind() {
        assertThrows(EmployeeNotFoundException.class, () -> out.find(LAST_NAME, FIRST_NAME, MIDDLE_NAME));
    }

    @Test
    void shouldReturnMapWhenPrint() {
        Map<String, Employee> expectedEmployeeMap = new HashMap<>();
        expectedEmployeeMap.put(expectedEmployee.toString(), expectedEmployee);
        out.add(LAST_NAME, FIRST_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        assertEquals(expectedEmployeeMap, out.print());
    }


}