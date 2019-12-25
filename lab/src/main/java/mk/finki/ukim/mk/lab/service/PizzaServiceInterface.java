package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.List;

public interface PizzaServiceInterface {
    List<Pizza> listPizzas();
    public Pizza create(String name, String description, List<Ingredient> ingredients, boolean veggie);

   public Pizza createPizza(String pizzaname, String description, List<Ingredient> ingredients);


    List<Pizza> listPizzasWithIngredient(String name);

    Pizza addNewPizza(String name, String description, boolean veggie, String ingredientId);

    Pizza editPizza(String name, String description, boolean veggie, String ingredientId);

    void deletePizza(String id);

    List<Pizza> listPizzasWithNumIngredients(Long numIngredients);

    Pizza getById(String name);

    List<Ingredient> getSameIngredients(String pizzaName1, String pizzaName2);
}
