package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Table(name="Pizzas")
public class Pizza {
    @Id
    String name;
    String description;
    @ManyToMany
    List<Ingredient> ingredients;
    boolean veggie;


   public Pizza(String name,String description){
        this.name=name;
        this.description=description;
    }

    public Pizza(String name, String description, List<Ingredient> ingredients, boolean veggie) {

    }
}
