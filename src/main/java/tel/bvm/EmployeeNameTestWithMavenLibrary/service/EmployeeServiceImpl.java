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

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 1;
        int departmentNumberGenerator = random.nextInt(5) + minimumScore;
        return departmentNumberGenerator;
    }

    public int wageValueGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 100_000;
        int wageValueGenerator = random.nextInt(300_000) + minimumScore;
        return wageValueGenerator;
    }

    public String employeeNameMatches(String anyName) {
        String nameClean = null;

        for (int letter = 0; letter < anyName.length(); letter++) {
            char checkLetter;

            if (letter == 0) {
                if (!Character.isUpperCase(anyName.charAt(letter))) {
                    checkLetter = Character.toUpperCase(anyName.charAt(letter));
                    nameClean = checkLetter + anyName.substring(1);
                }
            }
            if (Character.isUpperCase(anyName.charAt(letter))) {
                checkLetter = Character.toLowerCase(anyName.charAt(letter));
                nameClean = checkLetter + anyName.substring(letter + 1);
            }
        }
        return nameClean;
//        return StringUtils.capitalize(anyName.toLowerCase());
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
            Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wageValueGenerator(), departmentNumberGenerator());
            employeeMap.put(idEmployeeInfo, employee);
        }
        throw new EmployeeNamesNotCorrect();
    }

    @Override
    public Map addAcceptedEmployees(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wageValueGenerator(), departmentNumberGenerator());
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


