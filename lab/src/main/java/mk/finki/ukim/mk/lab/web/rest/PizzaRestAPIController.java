package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.jpa.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.jpa.PizzaRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import mk.finki.ukim.mk.lab.service.PizzaServiceInterface;
import mk.finki.ukim.mk.lab.service.impl.IngredientServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.PizzaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest/pizzas")
public class PizzaRestAPIController {
    //private final PizzaRepository pizzaRepository;
    private PizzaServiceImpl pizzaService;
    //private IngredientRepository ingredientRepository;
    private IngredientServiceImpl ingredientService;
    public PizzaRestAPIController(PizzaServiceImpl psi,IngredientServiceImpl ingredientService){
        this.ingredientService=ingredientService;
        this.pizzaService=psi;
    }
    //GET /pizzas
    @GetMapping
    public List<Pizza> getAllPizzas(@RequestParam(value = "totalIngredients", required = false) Long totalIngredients){
        if(totalIngredients!=null)
            return pizzaService.listPizzasWithNumIngredients(totalIngredients);

        return pizzaService.listPizzas();
    }

    //: POST /pizzas 	(default: veggie = false)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createPizza(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam(value = "ingredientId") String ingredientId,
                             @RequestParam(value = "veggie", defaultValue = "false") boolean veggie,
                             HttpServletResponse response,
                             UriComponentsBuilder builder){
        Pizza resultPizza=pizzaService.addNewPizza(name,description,veggie,ingredientId);
        response.setHeader("Location", builder.path("/rest/pizzas/{id}").buildAndExpand(resultPizza.getName()).toUriString());
        return resultPizza;
    }
    //PUT /pizzas/{id}
    @PutMapping("/{id}")
    public Pizza updatePizza(@PathVariable String id,
                             @RequestParam("description") String description,
                             @RequestParam(value = "ingredientId") String ingredientId,
                             @RequestParam(value = "veggie", defaultValue = "false") boolean veggie){

        return pizzaService.editPizza(id, description, veggie, ingredientId);
    }

    //DELETE /pizzas/{id}
    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable String id) {

        pizzaService.deletePizza(id);
    }
    //GET /pizzas

    //GET /pizzas/{id}
    @GetMapping("/{id}")
    public Pizza getPizza(@PathVariable String id){

        return pizzaService.getById(id);
    }
    //GET /pizzas?totalIngredients=100

    //GET /pizzas/compare?pizza1=id1&pizza2=id2
    @GetMapping("/compare")
    public List<Ingredient> getSameIngredients(@RequestParam("pizza1") String pizzaName1,
                                               @RequestParam("pizza2") String pizzaName2){

        return pizzaService.getSameIngredients(pizzaName1,pizzaName2);

    }
}
