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

import static org.mockito.Mockito.when;
import static tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)

public class DetailsEmployeeDepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl serviceMockEmployee;

    @BeforeEach
    void initOut() {
        when(serviceMockEmployee.getMap()).thenReturn(MAP_EMPLOYEE);
        DetailsEmployeeDepartmentServiceImpl out = new DetailsEmployeeDepartmentServiceImpl(serviceMockEmployee);
}

    @Test
    void maxWageDepartmentVerify() {
    }

    @Test
    void allEmployeeInfoVerify() {
    }

    @Test
    void minWageDepartmentVerify() {
    }

    @Test
    void allEmployeeGroupVerify() {
    }
}
//    @Test
//    public void maxWageDepartmentVerify() {
//
//        for (Map.Entry<String, Employee> entry : MAP_EMPLOYEE.entrySet()) {
//            Employee employee = entry.getValue();
//            serviceMockEmployee.add(employee.getFirstName(),
//                    employee.getLastName(),
//                    employee.getPasswordNumber(),
//                    employee.getYearBirth());
//        }

//        Employee employeeWithMaxWageDepartment =

//    }
//    @Test
//    public void maxWageDepartmentVerify() {
//
//        for (Map.Entry<String, Employee> entry : MAP_EMPLOYEE.entrySet()) {
//            Employee employee = entry.getValue();
//            serviceMockEmployee.add(employee.getFirstName(),
//                    employee.getLastName(),
//                    employee.getPasswordNumber(),
//                    employee.getYearBirth());
//        }
//
////        Employee employeeWithMaxWageDepartment =
//
//    }
        //        DetailsEmployeeDepartmentServiceImpl detailsEmployeeDepartmentService = new DetailsEmployeeDepartmentServiceImpl(new HashMap<String, Employee>);
//    }


////
//    EmployeeService employeeService;
//    //
//
//    private DetailsEmployeeDepartmentServiceImpl serviceMockDetailsDepartment;
////    public WageDepartmentGenerator wageDepartmentGenerator;
////    private final EmployeeServiceImpl employeeService;
//
//    @BeforeEach
//    void setUp() {
//
//        EmployeeServiceImpl new employeeServiceImpl;

//        serviceMockDetailsDepartment = new DetailsEmployeeDepartmentServiceImpl(serviceMockEmployee);
