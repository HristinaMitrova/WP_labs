package mk.finki.ukim.mk.lab.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Not vegetarian ingredient in vegetarian pizza")
public class InvalidIngredientException extends RuntimeException {
    public InvalidIngredientException() {
        super("Not vegetarian ingredient in vegetarian pizza");
    }
}
