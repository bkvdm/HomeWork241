package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
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
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::departmentNumberGenerator).thenReturn(1);
        }
        try (MockedStatic<WageDepartmentGenerator> theMock = Mockito.mockStatic(WageDepartmentGenerator.class)) {
            theMock.when(WageDepartmentGenerator::wageValueGenerator).thenReturn(100000);
        }

//        Mockito.when(FIRST_EMPLOYEE.getDepartmentNumber()).thenReturn(1);
//        Mockito.when(FIRST_EMPLOYEE.getDepartmentNumber()).thenReturn(100000);
        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
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
