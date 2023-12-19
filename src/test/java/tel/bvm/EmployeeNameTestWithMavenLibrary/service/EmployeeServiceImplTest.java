package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeAlreadyAddedException;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeNamesNotCorrect;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeNotFoundException;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    public WageDepartmentGenerator wageDepartmentGenerator;

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>(), wageDepartmentGenerator);
//        employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>(), new WageDepartmentGenerator());
    }

    @Test
    public void addEmployeeVerify() {
        when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(5);
        when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());

        assertEquals(excepted.size(), addedEmployee.size());
        assertEquals(excepted.keySet(), addedEmployee.keySet());
    }

    @Test
    public void addEmployeeVerifyCheckNameCorrect() {
        when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(5);
        when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());

        assertEquals(excepted, addedEmployee);
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
        when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(5);
        when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());

        assertEquals(excepted, addedEmployee);

        Employee employee = employeeService.find(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber()
        );
        assertEquals(FIRST_EMPLOYEE, employee);
    }

    @Test
    public void allEmployeeInfoVerify() {

        for (Map.Entry<String, Employee> entry : MAP_EMPLOYEE.entrySet()) {
            Employee employee = entry.getValue();
            employeeService.add(employee.getFirstName(), employee.getLastName(), employee.getPasswordNumber(), employee.getYearBirth());
        }

        Map<String, Employee> result = employeeService.allEmployeeInfo();
        assertNotNull(result);
    }

    @Test
    public void getMapVerify() {

        for (Map.Entry<String, Employee> entry : MAP_EMPLOYEE.entrySet()) {
            Employee employee = entry.getValue();
            employeeService.add(employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPasswordNumber(),
                    employee.getYearBirth());
        }

        Map<String, Employee> result = employeeService.getMap();
        assertEquals(MAP_EMPLOYEE.size(), result.size());
    }

    @Test
    public void addEmployeeAllReadyExceptionVerify() {
        when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(5);
        when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());

        assertEquals(excepted, addedEmployee);

        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth()));
    }

    @Test
    public void employeeNamesNotCorrectExceptionVerify() {
        Assertions.assertThrows(EmployeeNamesNotCorrect.class, () -> employeeService.add(
                "#",
                "1",
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth()));

        Assertions.assertThrows(EmployeeNamesNotCorrect.class, () -> employeeService.add(
                "1",
                "#",
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth()));
    }

    @Test
    public void employeeNotFoundException() {
        when(wageDepartmentGenerator.departmentNumberGenerator()).thenReturn(5);
        when(wageDepartmentGenerator.wageValueGenerator()).thenReturn(100000);

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());

        assertEquals(excepted, addedEmployee);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(
                SIX_EMPLOYEE.getFirstName(),
                SIX_EMPLOYEE.getLastName(),
                SIX_EMPLOYEE.getPasswordNumber()));
    }
}
