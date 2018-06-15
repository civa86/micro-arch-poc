package info.civa86.photoservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.lang.Exception;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item not found")
public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
        super();
    }
}