package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    Ingredient findByName(String name);

    @Query("select i from Ingredient i where i.spicy=true")
    Page<Ingredient> getSpicy(Pageable pageable);

    @Query("select count (i) from Ingredient i where i.spicy=true")
    Integer getSpicyCount();
}
