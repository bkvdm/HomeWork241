//package tel.bvm.EmployeeNameTestWithMavenLibrary.service;
//
//public class EmployeeServiceImpl {
//}
//package tel.bvm.EmployeeNameTestWithMaven.service;
//
//public class EmployeeServiceImpl {
//}
package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeAlreadyAddedException;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeNamesNotCorrect;
import tel.bvm.EmployeeNameTestWithMavenLibrary.exception.EmployeeNotFoundException;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements tel.bvm.EmployeeNameTestWithMavenLibrary.service.EmployeeService {

    public final Map<String, Employee> employeeMap;
    private final WageDepartmentGenerator wageDepartmentGenerator;

    public EmployeeServiceImpl(Map<String, Employee> employeeMap, WageDepartmentGenerator wageDepartmentGenerator) {
        this.employeeMap = employeeMap;
        this.wageDepartmentGenerator = wageDepartmentGenerator;
    }

    public String employeeNameMatches(String anyName) {
        return StringUtils.capitalize(anyName.toLowerCase());
    }

    @Override
    public Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
        boolean namesCorrect = StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        if (employeeMap.containsKey(idEmployeeInfo)) {
            throw new EmployeeAlreadyAddedException();
        } else if (namesCorrect) {
            firstName = employeeNameMatches(firstName);
            lastName = employeeNameMatches(lastName);
            idEmployeeInfo = firstName + lastName + passwordNumber;
            Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wageDepartmentGenerator.wageValueGenerator(), wageDepartmentGenerator.departmentNumberGenerator());
            employeeMap.put(idEmployeeInfo, employee);
        } else {
            throw new EmployeeNamesNotCorrect();
        }
        return employeeMap;
    }

    @Override
    public Map addAcceptedEmployees(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
        Map<String, Employee> employeeMap = new HashMap<>();
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wageDepartmentGenerator.wageValueGenerator(), wageDepartmentGenerator.departmentNumberGenerator());
        employeeMap.put(idEmployeeInfo, employee);
        return employeeMap;
    }

    @Override
    public Employee remove(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.remove(idEmployeeInfo, employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.get(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> allEmployeeInfo() {
        return Collections.unmodifiableMap(employeeMap);
    }

    @Override
    public Map<String, Employee> getMap() {
        return employeeMap;
    }
}
