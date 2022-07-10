package ru.atikhonov.listsandsets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIncorrectDataException extends RuntimeException {
    public EmployeeIncorrectDataException() {
        super();
    }

    public EmployeeIncorrectDataException(String message) {
        super(message);
    }

    public EmployeeIncorrectDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeIncorrectDataException(Throwable cause) {
        super(cause);
    }

    protected EmployeeIncorrectDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
