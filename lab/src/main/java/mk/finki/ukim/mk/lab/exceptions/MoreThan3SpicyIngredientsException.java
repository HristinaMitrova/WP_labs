package mk.finki.ukim.mk.lab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MoreThan3SpicyIngredientsException extends RuntimeException {
    public MoreThan3SpicyIngredientsException() {
        super("Eliminate one spicy ingredient!The pizza should only have three.:)");
    }
}
