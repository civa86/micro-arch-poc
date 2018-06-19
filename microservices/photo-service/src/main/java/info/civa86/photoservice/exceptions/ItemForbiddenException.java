package info.civa86.photoservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.lang.Exception;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Item forbidden")
public class ItemForbiddenException extends Exception {

    public ItemForbiddenException() {
        super();
    }
}