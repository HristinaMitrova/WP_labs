package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.domain.Page;

public interface IngredientService {
    Ingredient addNewIngredient(String name, boolean spicy, float amount, boolean veggie);
    Ingredient editIngredient(String id,boolean spicy, float amount, boolean veggie);
    void deleteIngredient(String id);
    Page<Ingredient> getAllIngredients(int page, int size);
    Ingredient getById(String id);
    Page<Ingredient> getSpicy(int page, int size);
}
