package tel.bvm.EmployeeNameTestWithMavenLibrary.PostConstructEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;
import tel.bvm.EmployeeNameTestWithMavenLibrary.service.EmployeeService;

import javax.annotation.PostConstruct;

@Component
public class AcceptedEmployees {

    @Autowired
    public EmployeeService employeeService;

    @PostConstruct
    public void init() {

        employeeService.add("Иванов", "Иван", "12345", 1980);
        employeeService.add("Петров", "Пётр", "34789", 1975);
        employeeService.add("Смирнов", "Максим", "30237", 1989);
        employeeService.add("Новая", "Мария", "48905", 1990);
        employeeService.add("Симонов", "Тимофей", "01242", 1983);
        employeeService.add("Виноградова", "Анастасия", "29384", 1991);
        employeeService.add("Неизвестный", "Никита", "45892", 1980);
        employeeService.add("Громыко", "Павел", "32947", 1995);
        employeeService.add("Ким", "Юрий", "78118", 1999);
        employeeService.add("Великий", "Антон", "32460", 2001);
        employeeService.add("Крымская", "Маргарита", "34901", 1979);
    }
}

