//package tel.bvm.EmployeeNameTestWithMavenLibrary.service;
//
//public class DetailsEmployeeDepartmentServiceImpl {
//}
//package tel.bvm.EmployeeNameTestWithMaven.service;
//
//public class DetailsEmployeeDepartmentServiceImpl {
//}
package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.springframework.stereotype.Service;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.*;

@Service
public class DetailsEmployeeDepartmentServiceImpl implements tel.bvm.EmployeeNameTestWithMavenLibrary.service.DetailsEmployeeDepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DetailsEmployeeDepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxWageDepartment(Integer departmentNumber) {

        Optional<Employee> maxDepartmentEmployee;
        if (departmentNumber == null) {
            maxDepartmentEmployee = employeeService.getMap().values()
                    .stream()
                    .max(Comparator.comparingInt(employee -> employee.getWage()));
        } else {
            maxDepartmentEmployee = employeeService.getMap().values()
                    .stream()
                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                    .max(Comparator.comparingInt(employee -> employee.getWage()));
        }
        return maxDepartmentEmployee.orElseThrow();
    }

    @Override
    public Map<String, Employee> allEmployeeInfo() {
        return Collections.unmodifiableMap(employeeService.getMap());
    }

    @Override
    public Employee minWageDepartment(Integer departmentNumber) {

        Optional<Employee> minDepartmentEmployee;
        if (departmentNumber == null) {
            minDepartmentEmployee = employeeService.getMap().values()
                    .stream()
                    .min(Comparator.comparingInt(employee -> employee.getWage()));
        } else {
            minDepartmentEmployee = employeeService.getMap().values()
                    .stream()
                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                    .min(Comparator.comparingInt(employee -> employee.getWage()));
        }
        return minDepartmentEmployee.orElseThrow();
    }

    @Override
    public String allEmployeeGroup(Integer department) {

        Map<Integer, List<Employee>> employeeGroup = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>(employeeService.getMap().values());
        for (Employee employee : employeeList) {
            Integer departmentNumber = employee.getDepartmentNumber();
            List<Employee> employees = employeeGroup.getOrDefault(departmentNumber, new ArrayList<>());
            employees.add(employee);
            employeeGroup.put(departmentNumber, employees);
        }
        if (department == null) {
            return employeeGroup.toString();
        } else {
            return employeeGroup.get(department).toString();
        }
    }
}

