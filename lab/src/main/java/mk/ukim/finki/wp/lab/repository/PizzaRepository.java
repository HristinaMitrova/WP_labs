package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaRepository {
    List<Pizza> pizzaList=new ArrayList<Pizza>();
    public List<Pizza> getAllPizzas(){
        return  pizzaList;
    }
}
