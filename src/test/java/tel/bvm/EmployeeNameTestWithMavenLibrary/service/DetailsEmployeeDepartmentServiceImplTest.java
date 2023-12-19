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

    private DetailsEmployeeDepartmentServiceImpl serviceMockDetailsDepartment;
    public WageDepartmentGenerator wageDepartmentGenerator;
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new HashMap<String, Employee>(), wageDepartmentGenerator);



    @BeforeEach
    void setUp() {
        DetailsEmployeeDepartmentService out = new DetailsEmployeeDepartmentServiceImpl(serviceMockEmployee);
    }

    @Test
    public void maxWageDepartmentVerify() {

        for (Map.Entry<String, Employee> entry : MAP_EMPLOYEE.entrySet()) {
            Employee employee = entry.getValue();
            employeeService.add(employee.getFirstName(), employee.getLastName(), employee.getPasswordNumber(), employee.getYearBirth());
        }

//        Employee employeeWithMaxWageDepartment =

    }
}
