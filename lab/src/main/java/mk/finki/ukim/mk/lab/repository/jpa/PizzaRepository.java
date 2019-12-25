package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, String> {
    @Query("select p from Pizza p join p.ingredients i where i.name=:name")
    List<Pizza> getAllByIngredientName(@Param("name") String name);

    Pizza findByName(String name);

    @Query("select p from Pizza p join p.ingredients i group by p having count(p)<:num")
    List<Pizza> getAllByNumberOfIngredients(@Param("num") Long num);


    @Query("select i from Pizza p join p.ingredients i where p.name=:pizzaName")
    List<Ingredient> getIngredients(@Param("pizzaName") String pizzaName);
}
