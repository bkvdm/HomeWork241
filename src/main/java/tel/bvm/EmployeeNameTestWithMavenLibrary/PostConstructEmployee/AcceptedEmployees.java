package tel.bvm.EmployeeNameTestWithMavenLibrary.PostConstructEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;
import tel.bvm.EmployeeNameTestWithMavenLibrary.service.EmployeeService;

import javax.annotation.PostConstruct;

@Component
public class AcceptedEmployees {
    //    private final EmployeeService employeeService;
//
//    public AcceptedEmployees(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//    @Autowired
//    private EmployeeService employeeService;

    private final EmployeeService employeeService;

    @Autowired
    public AcceptedEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init() {

        employeeService.addAcceptedEmployees("Иванов", "Иван", "12345", 1980);
        employeeService.addAcceptedEmployees("Петров", "Пётр", "34789", 1975);
        employeeService.addAcceptedEmployees("Смирнов", "Максим", "30237", 1989);
        employeeService.addAcceptedEmployees("Новая", "Мария", "48905", 1990);
        employeeService.addAcceptedEmployees("Симонов", "Тимофей", "01242", 1983);
        employeeService.addAcceptedEmployees("Виноградова", "Анастасия", "29384", 1991);
        employeeService.addAcceptedEmployees("Неизвестный", "Никита", "45892", 1980);
        employeeService.addAcceptedEmployees("Громыко", "Павел", "32947", 1995);
        employeeService.addAcceptedEmployees("Ким", "Юрий", "78118", 1999);
        employeeService.addAcceptedEmployees("Великий", "Антон", "32460", 2001);
        employeeService.addAcceptedEmployees("Крымская", "Маргарита", "34901", 1979);
    }
}

