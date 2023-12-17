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

//    private EmployeeServiceImpl employeeServiceImpl;

    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>(), wageDepartmentGenerator);

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>(), wageDepartmentGenerator);
    }

    //        assertFalse(employeeService.findAll().contains(FIRST_EMPLOYEE));

//    void lookMomICanMockStaticMethods() {
//        assertThat(Buddy.name()).isEqualTo("John");
//
//        try (MockedStatic<Buddy> theMock = Mockito.mockStatic(Buddy.class)) {
//            theMock.when(Buddy::name).thenReturn("Rafael");
//            assertThat(Buddy.name()).isEqualTo("Rafael");
//        }
//
//        assertThat(Buddy.name()).isEqualTo("John");
//    }

    @Test
    public void addEmployeeVerify() {

//        Mockito.when(FIRST_EMPLOYEE.getDepartmentNumber()).thenReturn(1);
//        Mockito.when(FIRST_EMPLOYEE.getDepartmentNumber()).thenReturn(100000);
        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(5);
        }
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);
        }

        assertEquals(excepted.size(), addedEmployee.size());
        assertEquals(excepted.keySet(), addedEmployee.keySet());
//        assertEquals(excepted.values(), addedEmployee.values());
    }

    @Test
    public void addEmployeeVerifyCheckNameCorrect() {
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(5);
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);

            Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
            Map<String, Employee> addedEmployee = employeeService.add(
                    FIRST_EMPLOYEE.getFirstName(),
                    FIRST_EMPLOYEE.getLastName(),
                    FIRST_EMPLOYEE.getPasswordNumber(),
                    FIRST_EMPLOYEE.getYearBirth());

            assertEquals(excepted, addedEmployee);
        }
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
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(5);
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);

            Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
            Map<String, Employee> addedEmployee = employeeService.add(
                    FIRST_EMPLOYEE.getFirstName(),
                    FIRST_EMPLOYEE.getLastName(),
                    FIRST_EMPLOYEE.getPasswordNumber(),
                    FIRST_EMPLOYEE.getYearBirth());

            assertEquals(excepted, addedEmployee);
        }

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
//        assertIterableEquals(MAP_EMPLOYEE.values(), result.values());
    }

    @Test
    public void addEmployeeAllReadyExceptionVerify() {
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(5);
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);

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
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(5);
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);

            Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
            Map<String, Employee> addedEmployee = employeeService.add(
                    FIRST_EMPLOYEE.getFirstName(),
                    FIRST_EMPLOYEE.getLastName(),
                    FIRST_EMPLOYEE.getPasswordNumber(),
                    FIRST_EMPLOYEE.getYearBirth());

            assertEquals(excepted, addedEmployee);
        }

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(
                SIX_EMPLOYEE.getFirstName(),
                SIX_EMPLOYEE.getLastName(),
                SIX_EMPLOYEE.getPasswordNumber()));
    }
}
