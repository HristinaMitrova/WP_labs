package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.model.Pizza;
//import mk.finki.ukim.mk.lab.repository.PizzaRepositoryInterface;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Repository
//public class PizzaRepository implements PizzaRepositoryInterface {
//    private static final List<Pizza> pizzas = new ArrayList<>();
//
//    @PostConstruct
//    public void init(){
//        pizzas.addAll(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .map(x -> new Pizza("Pizza "+x, "Description for pizza "+x))
//                .collect(Collectors.toList()));
//    }
//    @Override
//    public List<Pizza> getAllPizzas() {
//        return pizzas;
//    }
//
//    @Override
//    public void addPizza(String pizzaName, String pizzaDescription) {
//         pizzas.add(new Pizza(pizzaName,pizzaDescription));
//    }
//}
