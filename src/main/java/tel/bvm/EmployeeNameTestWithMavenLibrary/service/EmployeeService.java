//package tel.bvm.EmployeeNameTestWithMavenLibrary.service;
//
//public interface EmployeeService {
//}
//package tel.bvm.EmployeeNameTestWithMaven.service;
//
//public interface EmployeeService {
//}
package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.Map;

public interface EmployeeService {

    Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth);

    Employee remove(String firstName, String lastName, String passwordNumber);

    Employee find(String firstName, String lastName, String passwordNumber);

    Map<String, Employee> allEmployeeInfo();

    Map<String, Employee> getMap();
}
