package info.civa86.authservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.lang.Exception;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Email address already present")
public class EmailAlreadyPresentException extends Exception {

    public EmailAlreadyPresentException() {
        super();
    }
}