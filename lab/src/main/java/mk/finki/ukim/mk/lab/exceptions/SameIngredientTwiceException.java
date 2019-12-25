package mk.finki.ukim.mk.lab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SameIngredientTwiceException extends RuntimeException {
    public SameIngredientTwiceException(String name){
        super("The ingredient: "+name+"is appearing more than once. Choose another igredient!");
    }

    public SameIngredientTwiceException() {

    }
}
