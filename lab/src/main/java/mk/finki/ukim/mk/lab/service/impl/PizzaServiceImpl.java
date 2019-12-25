package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.exceptions.InvalidIngredientException;
import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.jpa.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.jpa.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaServiceInterface {
    private PizzaRepository pizzaRepository;
    private IngredientRepository ingredientRepository;


    PizzaServiceImpl(PizzaRepository pizzaRepository)
    {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.findAll();
    }
    /*@Override
    public List<Pizza> listPizzasWithIngredient(String name) {
        return pizzaRepository.getAllByIngredientName(name);
    }*/
    @Override
    public Pizza getById(String name) {
        return pizzaRepository.findByName(name);
    }



    @Override
    public Pizza create(String name, String description, List<Ingredient> ingredients, boolean veggie){
        Pizza pizza=new Pizza(name,description,ingredients,veggie);
        return  this.pizzaRepository.save(pizza);
    }

    @Override
    public Pizza createPizza(String pizzaname, String description, List<Ingredient> ingredients) {
        return null;
    }
    @Override
    public List<Ingredient> getSameIngredients(String pizzaName1, String pizzaName2) {
        List<Ingredient> pizza1Ingredients=pizzaRepository.getIngredients(pizzaName1);
        List<Ingredient> pizza2Ingredients=pizzaRepository.getIngredients(pizzaName2);
        pizza1Ingredients.retainAll(pizza2Ingredients);
        return pizza1Ingredients;
    }
    @Override
    public List<Pizza> listPizzasWithIngredient(String name) {
        return pizzaRepository.getAllByIngredientName(name);
    }

    @Override
    public Pizza addNewPizza(String name, String description, boolean veggie, String ingredientId) {

        List<Ingredient> pizzaIngredients=new ArrayList<>();
        Ingredient ingredient=ingredientRepository.findByName(ingredientId);
        if(veggie && !ingredient.isVeggie()) throw new InvalidIngredientException();

        pizzaIngredients.add(ingredient);
        Pizza newPizza=new Pizza(name,description,pizzaIngredients,veggie);
        return pizzaRepository.save(newPizza);

    }

    @Override
    public Pizza editPizza(String name, String description, boolean veggie, String ingredientId) {
        Pizza existingPizza=pizzaRepository.findByName(name);
        existingPizza.setDescription(description);
        existingPizza.setVeggie(veggie);

        List<Ingredient> pizzaIngredients=existingPizza.getIngredients();
        Ingredient addIngredient=ingredientRepository.findByName(ingredientId);
        if(veggie && !addIngredient.isVeggie()) throw new InvalidIngredientException();

        if(!pizzaIngredients.contains(addIngredient)) pizzaIngredients.add(addIngredient);
        existingPizza.setIngredients(pizzaIngredients);
        return pizzaRepository.save(existingPizza);
    }

    @Override
    public void deletePizza(String id) {
        Pizza oldPizza=pizzaRepository.findByName(id);
        pizzaRepository.delete(oldPizza);
    }

    @Override
    public List<Pizza> listPizzasWithNumIngredients(Long numIngredients) {
        return pizzaRepository.getAllByNumberOfIngredients(numIngredients);
    }

}
