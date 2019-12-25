package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
@Getter
public class DataHolder {
    public static final List<Pizza> pizzas = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init() {
        pizzas.add(new Pizza("Margherita","Margherita (tomato sauce, mozzarella)"));
        pizzas.add(new Pizza("Carbonara","Carbonara (fresh cream, mozzarella, bacon)"));
        pizzas.add(new Pizza("Vegetariana","Vegetariana (tomato sauce, mushrooms)"));
        pizzas.add(new Pizza("Calzone","Calzone (Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        pizzas.add(new Pizza("Cheddar","Cheddar (cheddar, tomato sauce)"));
        pizzas.add(new Pizza("Capricciosa","Capricciosa (tomato sauce, cheese, ham)"));
        pizzas.add(new Pizza("Burger Classic","Burger Classic (barbecue sauce, beef, mozzarella, onions)"));
        pizzas.add(new Pizza("Boston Barbecue","Burger Barbecue (ham, chicken meat, onions)"));
        pizzas.add(new Pizza("Vegie Vulcano","Pepperoni (tomato sauce, mozzarella, sausage)"));
        pizzas.add(new Pizza("Boston Barbecue","Quattro Formaggi (Taleggio, Mascarpone, Gorgonzola, Parmesan)"));

        // orders.add(new Order("cv","cd","cdc"));
    }
}
