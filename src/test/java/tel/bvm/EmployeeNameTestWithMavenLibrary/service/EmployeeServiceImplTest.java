package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.Before;
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
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.FIRST_EMPLOYEE;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.idFirst;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.service.WageDepartmentGenerator.*;

@ExtendWith(MockitoExtension.class)

//@Override
//public Map addAcceptedEmployees(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
//        String idEmployeeInfo = firstName + lastName + passwordNumber;
//        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, WageDepartmentGenerator.wageValueGenerator(), WageDepartmentGenerator.departmentNumberGenerator());
//        employeeMap.put(idEmployeeInfo, employee);
//        return employeeMap;
//        }

public class EmployeeServiceImplTest {

//    private EmployeeService out;
//
//    @BeforeEach
//    void setUp() {
//        out = new EmployeeServiceImpl();
//    }

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

//        assertFalse(employeeService.findAll().contains(FIRST_EMPLOYEE));
    @Test
    public void addEmployeeVerify() {

        Map<String, Employee> excepted = Map.of(idFirst, FIRST_EMPLOYEE);
        Map<String, Employee> addedEmployee = employeeService.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
        assertEquals(excepted, addedEmployee);
    }

//        assertTrue(employeeService.findAll().contains(employee));
//        assertEquals(1, employeeService.findAll().size());
//    @Test
//    public void shouldThrowEmployeeAlreadyAddedException() {
//        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
//        assertTrue(employeeService.findAll().contains(addedEmployee));
//        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID));
//    }

    @Test
    public void remove() {

    }

    @Test
    public void find() {

    }

    @Test
    public void allEmployeeInfo() {

    }

    @Test
    public void getMap() {

    }
}


//        }
//
//
//                }
//
////        String id = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
////        Map<String, Employee> employeeMap = new HashMap<>();
////        employeeMap.put(id, FIRST_EMPLOYEE);
////        out = new EmployeeServiceImpl(employeeMap);
//
////        String id = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
////        Map<String, Employee> employeeMap = new HashMap<>();
////        employeeMap.put(id, FIRST_EMPLOYEE);
////        out = new EmployeeServiceImpl(employeeMap);
//                }
////    private final EmployeeService employeeService = new EmployeeServiceImpl(1);
////
////    //    private final CalculatorService calculatorService = new CalculatorServiceImpl();
////    @Mock
////    private EmployeeService employeeServiceMock;
////
////    @InjectMocks
////    private EmployeeService out;
////    @BeforeEach
////    public void setUp() {
////        out = new EmployeeServiceImpl() {
