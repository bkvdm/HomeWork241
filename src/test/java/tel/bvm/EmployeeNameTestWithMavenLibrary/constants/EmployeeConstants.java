package tel.bvm.EmployeeNameTestWithMavenLibrary.constants;

import tel.bvm.EmployeeNameTestWithMavenLibrary.scheme.Employee;

import java.util.Map;

public class EmployeeConstants {

    public static final Employee FIRST_EMPLOYEE = new Employee("Иван", "Иванов", "10101010", 1975, 100000, 5);
    public static final Employee SECOND_EMPLOYEE = new Employee("Петров", "Пётр", "01010101", 1980, 200000, 4);
    public static final Employee THREE_EMPLOYEE = new Employee("Смирнов", "Семён", "20202020", 1985, 300000, 3);
    public static final Employee FOUR_EMPLOYEE = new Employee("Владимиров", "Владимир", "02020202", 1990, 400000, 2);
    public static final Employee FIVE_EMPLOYEE = new Employee("Тимофеев", "Тимофей", "303030303", 1995, 500000, 5);
    public static final Employee SIX_EMPLOYEE = new Employee("Маруся", "Смирнова", "123", 2000, 600000, 6);
    public static final String ID_FIRST = FIRST_EMPLOYEE.getFirstName() + FIRST_EMPLOYEE.getLastName() + FIRST_EMPLOYEE.getPasswordNumber();
    public static final String ID_SECOND = SECOND_EMPLOYEE.getFirstName() + SECOND_EMPLOYEE.getLastName() + SECOND_EMPLOYEE.getPasswordNumber();
    public static final String ID_THREE = THREE_EMPLOYEE.getFirstName() + THREE_EMPLOYEE.getLastName() + THREE_EMPLOYEE.getPasswordNumber();
    public static final String ID_FOUR = FOUR_EMPLOYEE.getFirstName() + FOUR_EMPLOYEE.getLastName() + FOUR_EMPLOYEE.getPasswordNumber();
    public static final String ID_FIVE = FIVE_EMPLOYEE.getFirstName() + FIVE_EMPLOYEE.getLastName() + FIVE_EMPLOYEE.getPasswordNumber();
    public static final String ID_SIX = SIX_EMPLOYEE.getFirstName() + SIX_EMPLOYEE.getLastName() + SIX_EMPLOYEE.getPasswordNumber();

    public static final Map<String, Employee> MAP_EMPLOYEE = Map.of(
            ID_FIRST, new Employee(FIRST_EMPLOYEE.getFirstName(), FIRST_EMPLOYEE.getLastName(), FIRST_EMPLOYEE.getPasswordNumber(), FIRST_EMPLOYEE.getYearBirth(), FIRST_EMPLOYEE.getWage(), FIRST_EMPLOYEE.getDepartmentNumber()),
            ID_SECOND, new Employee(SECOND_EMPLOYEE.getFirstName(), SECOND_EMPLOYEE.getLastName(), SECOND_EMPLOYEE.getPasswordNumber(), SECOND_EMPLOYEE.getYearBirth(), SECOND_EMPLOYEE.getWage(), SECOND_EMPLOYEE.getDepartmentNumber()),
            ID_THREE, new Employee(THREE_EMPLOYEE.getFirstName(), THREE_EMPLOYEE.getLastName(), THREE_EMPLOYEE.getPasswordNumber(), THREE_EMPLOYEE.getYearBirth(), THREE_EMPLOYEE.getWage(), THREE_EMPLOYEE.getDepartmentNumber()),
            ID_FOUR, new Employee(FOUR_EMPLOYEE.getFirstName(), FOUR_EMPLOYEE.getLastName(), FOUR_EMPLOYEE.getPasswordNumber(), FOUR_EMPLOYEE.getYearBirth(), FOUR_EMPLOYEE.getWage(), FOUR_EMPLOYEE.getDepartmentNumber()),
            ID_FIVE, new Employee(FIVE_EMPLOYEE.getFirstName(), FIVE_EMPLOYEE.getLastName(), FIVE_EMPLOYEE.getPasswordNumber(), FIVE_EMPLOYEE.getYearBirth(), FIVE_EMPLOYEE.getWage(), FIVE_EMPLOYEE.getDepartmentNumber()),
            ID_SIX, new Employee(SIX_EMPLOYEE.getFirstName(), SIX_EMPLOYEE.getLastName(), SIX_EMPLOYEE.getPasswordNumber(), SIX_EMPLOYEE.getYearBirth(), SIX_EMPLOYEE.getWage(), SIX_EMPLOYEE.getDepartmentNumber())
    );
}
