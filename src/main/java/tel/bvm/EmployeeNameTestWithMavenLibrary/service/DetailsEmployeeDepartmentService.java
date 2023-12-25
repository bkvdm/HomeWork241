//package tel.bvm.EmployeeNameTestWithMavenLibrary.service;
//
//public interface DetailsEmployeeDepartmentService {
//}
//package tel.bvm.EmployeeNameTestWithMaven.service;
//
//public interface DetailsEmployeeDepartmentService {
//}
package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.Map;

public interface DetailsEmployeeDepartmentService {
    Employee maxWageDepartment(Integer departmentNumber);

    Map<String, Employee> allEmployeeInfo();

    Employee minWageDepartment(Integer departmentNumber);

    String allEmployeeGroup(Integer department);
}