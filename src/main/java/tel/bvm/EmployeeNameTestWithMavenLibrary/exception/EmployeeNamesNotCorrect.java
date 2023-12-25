package tel.bvm.EmployeeNameTestWithMavenLibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CHECKPOINT)
public class EmployeeNamesNotCorrect extends RuntimeException {
    public EmployeeNamesNotCorrect() {
    }

    public EmployeeNamesNotCorrect(String massage) {
        super(massage);
    }

    public EmployeeNamesNotCorrect(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNamesNotCorrect(Throwable cause) {
        super(cause);
    }

    public EmployeeNamesNotCorrect(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
