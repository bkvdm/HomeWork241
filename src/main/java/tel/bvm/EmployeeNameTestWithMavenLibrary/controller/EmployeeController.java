//package tel.bvm.EmployeeNameTestWithMavenLibrary.controller;
//
//public class EmployeeController {
//}
//package tel.bvm.EmployeeNameTestWithMaven.controller;
//
//public class EmployeeController {
//}

package tel.bvm.EmployeeNameTestWithMavenLibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;
import tel.bvm.EmployeeNameTestWithMavenLibrary.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Map add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber, @RequestParam Integer yearBirth) {
        return service.add(firstName, lastName, passwordNumber, yearBirth);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
        return service.remove(firstName, lastName, passwordNumber);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
        return service.find(firstName, lastName, passwordNumber);
    }

    @GetMapping
    public Map<String, Employee> allEmployeeInfo() {
        return service.allEmployeeInfo();
    }
}

