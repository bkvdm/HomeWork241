package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)

public class DetailsEmployeeDepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl serviceMockEmployee;

    @InjectMocks
    private DetailsEmployeeDepartmentServiceImpl out;

    @BeforeEach
    void initOut() {
        when(serviceMockEmployee.getMap()).thenReturn(MAP_EMPLOYEE);
    }

    @Test
    void maxWageDepartmentVerify() {
        Employee actual = out.maxWageDepartment(null);
        assertEquals(actual, SIX_EMPLOYEE);

        actual = out.maxWageDepartment(6);
        assertEquals(actual, SIX_EMPLOYEE);

        actual = out.maxWageDepartment(5);
        assertEquals(actual, FIVE_EMPLOYEE);

        assertThrows(NoSuchElementException.class, () -> out.maxWageDepartment(8));
    }

    @Test
    void allEmployeeInfoVerify() {
        assertEquals(MAP_EMPLOYEE, out.allEmployeeInfo());
    }

    @Test
    void minWageDepartmentVerify() {

        Employee actual = out.minWageDepartment(null);
        assertEquals(actual, FIRST_EMPLOYEE);

        actual = out.minWageDepartment(3);
        assertEquals(actual, THREE_EMPLOYEE);

        actual = out.minWageDepartment(5);
        assertEquals(actual, FIRST_EMPLOYEE);

        assertThrows(NoSuchElementException.class, () -> out.minWageDepartment(8));
    }

    @Test
    void allEmployeeGroupVerify() {
//        String expected = "{2=[Employee{firstName='Владимиров', lastName='Владимир', passwordNumber='02020202', yearBirth=1990, wage=400000, departmentNumber=2}], 3=[Employee{firstName='Смирнов', lastName='Семён', passwordNumber='20202020', yearBirth=1985, wage=300000, departmentNumber=3}], 4=[Employee{firstName='Петров', lastName='Пётр', passwordNumber='01010101', yearBirth=1980, wage=200000, departmentNumber=4}], 5=[Employee{firstName='Иван', lastName='Иванов', passwordNumber='10101010', yearBirth=1975, wage=100000, departmentNumber=5}, Employee{firstName='Тимофеев', lastName='Тимофей', passwordNumber='303030303', yearBirth=1995, wage=500000, departmentNumber=5}], 6=[Employee{firstName='Маруся', lastName='Смирнова', passwordNumber='123', yearBirth=2000, wage=600000, departmentNumber=6}]}";
        String expected = "{2=[Employee{firstName='Владимиров', lastName='Владимир', passwordNumber='02020202', yearBirth=1990, wage=400000, departmentNumber=2}], 3=[Employee{firstName='Смирнов', lastName='Семён', passwordNumber='20202020', yearBirth=1985, wage=300000, departmentNumber=3}], 4=[Employee{firstName='Петров', lastName='Пётр', passwordNumber='01010101', yearBirth=1980, wage=200000, departmentNumber=4}], 5=[Employee{firstName='Иван', lastName='Иванов', passwordNumber='10101010', yearBirth=1975, wage=100000, departmentNumber=5}, Employee{firstName='Тимофеев', lastName='Тимофей', passwordNumber='303030303', yearBirth=1995, wage=500000, departmentNumber=5}], 6=[Employee{firstName='Маруся', lastName='Смирнова', passwordNumber='123', yearBirth=2000, wage=600000, departmentNumber=6}]}";
        assertEquals(expected, out.allEmployeeGroup(null));
        expected = "[Employee{firstName='Иван', lastName='Иванов', passwordNumber='10101010', yearBirth=1975, wage=100000, departmentNumber=5}, Employee{firstName='Тимофеев', lastName='Тимофей', passwordNumber='303030303', yearBirth=1995, wage=500000, departmentNumber=5}]";
//        System.out.println(out.allEmployeeGroup(5));
        assertEquals(expected, out.allEmployeeGroup(5));
//        System.out.println(out.allEmployeeGroup(null));
    }
}
