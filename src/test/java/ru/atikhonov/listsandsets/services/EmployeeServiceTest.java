package ru.atikhonov.listsandsets.services;

import org.junit.jupiter.api.Test;
import ru.atikhonov.listsandsets.exceptions.EmployeeAlreadyAddedException;
import ru.atikhonov.listsandsets.exceptions.EmployeeNotFoundException;
import ru.atikhonov.listsandsets.model.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.atikhonov.listsandsets.constants.ConstantsForEmployeeAndDepartmentServicesTests.*;

class EmployeeServiceTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();


    @Test
    void shouldReturnAddedEmployee() {
        assertEquals(EMPLOYEE1, out.add(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()
                , EMPLOYEE1.getDepartment()
                , EMPLOYEE1.getSalary()));
    }

    @Test
    void shouldReturnEmployeeAlreadyAddedExceptionWhenAttemptToAdd() {
        out.add(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()
                , EMPLOYEE1.getDepartment()
                , EMPLOYEE1.getSalary());
        assertThrows(EmployeeAlreadyAddedException.class
                , () -> out.add(EMPLOYEE1.getLastName()
                        , EMPLOYEE1.getFirstName()
                        , EMPLOYEE1.getMiddleName()
                        , EMPLOYEE1.getDepartment()
                        , EMPLOYEE1.getSalary()));
    }

    @Test
    void shouldReturnRemovedEmployee() {
        out.add(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()
                , EMPLOYEE1.getDepartment()
                , EMPLOYEE1.getSalary());
        assertEquals(EMPLOYEE1, out.rm(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()));
    }

    @Test
    void shouldReturnEmployeeNotFoundExceptionWhenAttemptToRemove() {
        assertThrows(EmployeeNotFoundException.class
                , () -> out.rm(EMPLOYEE1.getLastName()
                        , EMPLOYEE1.getFirstName()
                        , EMPLOYEE1.getMiddleName()));
    }

    @Test
    void shouldReturnFoundEmployee() {
        out.add(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()
                , EMPLOYEE1.getDepartment()
                , EMPLOYEE1.getSalary());
        assertEquals(EMPLOYEE1, out.find(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()));
    }

    @Test
    void shouldReturnEmployeeNotFoundExceptionWhenAttemptToFind() {
        assertThrows(EmployeeNotFoundException.class
                , () -> out.find(EMPLOYEE1.getLastName()
                        , EMPLOYEE1.getFirstName()
                        , EMPLOYEE1.getMiddleName()));
    }

    @Test
    void shouldReturnMapWhenPrint() {
        Map<String, Employee> expectedEmployeeMap = new HashMap<>();
        expectedEmployeeMap.put(EMPLOYEE1.toString(), EMPLOYEE1);
        out.add(EMPLOYEE1.getLastName()
                , EMPLOYEE1.getFirstName()
                , EMPLOYEE1.getMiddleName()
                , EMPLOYEE1.getDepartment()
                , EMPLOYEE1.getSalary());
        assertEquals(expectedEmployeeMap, out.print());
    }


}