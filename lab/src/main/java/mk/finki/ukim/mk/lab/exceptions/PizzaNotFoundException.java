package mk.finki.ukim.mk.lab.exceptions;

public class PizzaNotFoundException extends RuntimeException{
    public PizzaNotFoundException(String name) {
        super("The pizza with name " + name + ", that you chose cannot be found. Try again.");
    }
}
