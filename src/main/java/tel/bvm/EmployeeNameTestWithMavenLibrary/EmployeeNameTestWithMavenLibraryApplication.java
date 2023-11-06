package tel.bvm.EmployeeNameTestWithMavenLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;

@SpringBootApplication
public class EmployeeNameTestWithMavenLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeNameTestWithMavenLibraryApplication.class, args);
//		String nameEmployee = "Нина";

//		boolean checkNameEmployee = StringUtils.isAlpha(nameEmployee) && StringUtils.isWhitespace(nameEmployee);

//		if (checkNameEmployee) {
//		if (StringUtils.isAlpha(nameEmployee)) {
//			System.out.println("Имя и фамилие пользователя введено верно");
//		} else {
//			System.out.println("Имя и фамилие пользователя содержит недопустимые символы");
//		}
	}
}
