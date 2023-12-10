package tel.bvm.EmployeeNameTestWithMavenLibrary.constants;

import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeConstants {

    public static final Employee FIRST_EMPLOYEE = new Employee("Иван", "Иванов", "10101010", 1975, 100000, 5);
    public static final Employee SECOND_EMPLOYEE = new Employee("Петров", "Пётр", "01010101", 1980, 200000, 4);
    public static final Employee THREE_EMPLOYEE = new Employee("Смирнов", "Семён", "20202020", 1985, 300000, 3);
    public static final Employee FOUR_EMPLOYEE = new Employee("Владимиров", "Владимир", "02020202", 1990, 400000, 2);
    public static final Employee FIVE_EMPLOYEE = new Employee("Тимофеев", "Тимофей", "303030303", 1995, 500000, 1);

    public static final String idFirst = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
    public static final String idSecond = SECOND_EMPLOYEE.getFirstName() + SECOND_EMPLOYEE.getLastName() + SECOND_EMPLOYEE.getPasswordNumber();
    public static final String idThree = THREE_EMPLOYEE.getFirstName() + THREE_EMPLOYEE.getLastName() + THREE_EMPLOYEE.getPasswordNumber();
    public static final String idFour = FOUR_EMPLOYEE.getFirstName() + FOUR_EMPLOYEE.getLastName() + FOUR_EMPLOYEE.getPasswordNumber();
    public static final String idFive = FIVE_EMPLOYEE.getFirstName() + FIVE_EMPLOYEE.getLastName() + FIVE_EMPLOYEE.getPasswordNumber();

    public static final Map<String, Employee> MAP_EMPLOYEE = Map.of(
            "ИванИванов10101010", new Employee("Иван", "Иванов", "10101010", 1975, 100000, 5),
            "ПетровПётр01010101", new Employee("Петров", "Пётр", "01010101", 1980, 200000, 4),
            "СмирновСемён20202020", new Employee("Смирнов", "Семён", "20202020", 1985, 300000, 3),
            "ВладимировВладимир02020202", new Employee("Владимиров", "Владимир", "02020202", 1990, 400000, 2),
            "ТимофеевТимофей303030303", new Employee("Тимофеев", "Тимофей", "303030303", 1995, 500000, 1)
    );

//    private static final Map mapEmployee() {
//        Map<String, Employee> MAP_EMPLOYEE = new HashMap<>();
//        Employee FIRST_EMPLOYEE = new Employee("Иван", "Иванов", "10101010", 1975, 100000, 5);
//        Employee SECOND_EMPLOYEE = new Employee("Петров", "Пётр", "01010101", 1980, 200000, 4);
//        Employee THREE_EMPLOYEE = new Employee("Смирнов", "Семён", "20202020", 1985, 300000, 3);
//        Employee FOUR_EMPLOYEE = new Employee("Владимиров", "Владимир", "02020202", 1990, 400000, 2);
//        Employee FIVE_EMPLOYEE = new Employee("Тимофеев", "Тимофей", "303030303", 1995, 500000, 1);
//
//
//        String idFirst = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
//        String idSecond = SECOND_EMPLOYEE.getFirstName() + SECOND_EMPLOYEE.getLastName() + SECOND_EMPLOYEE.getPasswordNumber();
//        String idThree = THREE_EMPLOYEE.getFirstName() + THREE_EMPLOYEE.getLastName() + THREE_EMPLOYEE.getPasswordNumber();
//        String idFour = FOUR_EMPLOYEE.getFirstName() + FOUR_EMPLOYEE.getLastName() + FOUR_EMPLOYEE.getPasswordNumber();
//        String idFive = FIVE_EMPLOYEE.getFirstName() + FIVE_EMPLOYEE.getLastName() + FIVE_EMPLOYEE.getPasswordNumber();
//
//
//        MAP_EMPLOYEE.put(idFirst, FIRST_EMPLOYEE);
//        MAP_EMPLOYEE.put(idSecond, SECOND_EMPLOYEE);
//        MAP_EMPLOYEE.put(idThree, THREE_EMPLOYEE);
//        MAP_EMPLOYEE.put(idFour, FOUR_EMPLOYEE);
//        MAP_EMPLOYEE.put(idFive, FIVE_EMPLOYEE);
//
//        return MAP_EMPLOYEE;
//    }
}
