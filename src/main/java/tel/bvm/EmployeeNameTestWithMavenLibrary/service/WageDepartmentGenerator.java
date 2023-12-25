package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.springframework.stereotype.Component;

@Component
public class WageDepartmentGenerator {
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
}
