package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)

public class EmployeeServiceImplTest {
    private EmployeeService out;

    private final Employee FIRST_EMPLOYEE = new Employee("Иван", "Иванов", "10101010", 1975, 100100, 5);
    private final Employee SECOND_EMPLOYEE = new Employee("Петров", "Пётр", "01010101", 1980, 100200, 4);
    private final Employee THREE_EMPLOYEE = new Employee("Смирнов", "Семён", "20202020", 1985, 100300, 3);
    private final Employee FOUR_EMPLOYEE = new Employee("Владимиров", "Владимир", "02020202", 1990, 100400, 2);
    private final Employee FIVE_EMPLOYEE = new Employee("Тимофеев", "Тимофей", "303030303", 1995, 100500, 5);

    @BeforeEach
    void setUp() {
        String id = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put(id, FIRST_EMPLOYEE);
        out = new EmployeeServiceImpl(employeeMap);

    }

    @Test
    public void addEmployeeVerify() {
        Employee add = out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getPasswordNumber(),
                FIRST_EMPLOYEE.getYearBirth());
/*                FIRST_EMPLOYEE.getWage(),
                FIRST_EMPLOYEE.getDepartmentNumber());*/


        //        Employee add = out.add(FIRST_EMPLOYEE.getFirstName(), FIRST_EMPLOYEE.getLastName(), "10101010", 1975);


    }

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
