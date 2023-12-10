package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.*;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.service.WageDepartmentGenerator.*;

@ExtendWith(MockitoExtension.class)

public class EmployeeServiceImplTest {

    @Mock
    public WageDepartmentGenerator wageDepartmentGenerator;

    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>());
    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>());
    }

//        assertFalse(employeeService.findAll().contains(FIRST_EMPLOYEE));
    @Test
    public void addEmployeeVerify() {
        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
        Mockito.when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(1);
        Mockito.when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);
        assertEquals(excepted.size(), addedEmployee.size());
        assertEquals(excepted.keySet(), addedEmployee.keySet());
        assertEquals(excepted.values(), addedEmployee.values());
    }

    @Test
    public void removeEmployeeVerify() {
        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
        assertEquals(excepted.size(), addedEmployee.size());
        employeeService.remove(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber()
        );
        assertEquals(0, employeeService.getMap().size());
    }

    @Test
    public void findEmployeeVerify() {
        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
        assertEquals(excepted.size(), addedEmployee.size());

        Employee actual = employeeService.find(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber());
        String idFirstActual = actual.getFirstName() + actual.getLastName() + actual.getPasswordNumber();
        assertEquals(idFirst, idFirstActual);
    }

    @Test
    public void allEmployeeInfo() {

    }

    @Test
    public void getMap() {

    }
}

