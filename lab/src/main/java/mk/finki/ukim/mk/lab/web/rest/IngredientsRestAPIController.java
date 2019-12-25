package mk.finki.ukim.mk.lab.web.rest;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.jpa.IngredientRepository;
import mk.finki.ukim.mk.lab.service.impl.IngredientServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.PizzaServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest/ingredients")
public class IngredientsRestAPIController {
    //private final IngredientRepository ingredientRepository;
    private PizzaServiceImpl pizzaService;
    private IngredientServiceImpl ingredientService;



    public IngredientsRestAPIController(PizzaServiceImpl psi,IngredientServiceImpl ingredientService1) {
        this.pizzaService=psi;
        this.ingredientService=ingredientService1;
    }

    //POST /ingredients
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam(value = "amount") float amount,
                                       @RequestParam(value = "veggie") boolean veggie,
                                       HttpServletResponse response,
                                       UriComponentsBuilder builder){

        Ingredient newIngredient=ingredientService.addNewIngredient(name,spicy,amount,veggie);
        response.setHeader("Location", builder.path("/rest/ingredients/{id}").buildAndExpand(newIngredient.getName()).toUriString());
        return newIngredient;
    }

    //GET /ingredients
    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                              @RequestHeader(name = "page-size", defaultValue = "5", required = false) int size,
                                              @RequestParam(value = "spicy", required = false) boolean spicy ){
        if(!spicy)
            return ingredientService.getAllIngredients(page,size);
        else
            return ingredientService.getSpicy(page,size);
    }
    //PATCH /ingredients/{id}
    @PatchMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam(value = "amount") float amount,
                                       @RequestParam(value = "veggie") boolean veggie) {
        return ingredientService.editIngredient(id, spicy, amount, veggie);
    }
    //: DELETE /ingredients/{id}
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id)
    {
      ingredientService.deleteIngredient(id);
    }
    //GET /ingredients/{id}
    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id){

        return ingredientService.getById(id);
    }
    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasWithIngredient(@PathVariable String id){
        return pizzaService.listPizzasWithIngredient(id);
    }
    /*
    //: DELETE /ingredients/{id}
    public void deleteIngredient(List<Ingredient> list,Ingredient ingredient){
for (int i=0;i<list.size();i++){
    if(list.get(i).getName().equals(ingredient.getName())){
        list.remove(list.get(i));
    }
}
    }
    //GET /ingredients
    public List<Ingredient> listOfIngredients(){
        List<Ingredient> alphabeticalList=new ArrayList<Ingredient>();
        return alphabeticalList;

    }
    //GET /ingredients/{id}
    public Ingredient ingredientyy(List<Ingredient> list,int id){
        return list.get(id);
    }
    //GET /ingredients?spicy=true
    public List<Ingredient> spicyIngre(List<Ingredient> list){
        List<Ingredient> spicies=new ArrayList<Ingredient>();
        int br=0;
        for (Ingredient el:list
             ) { if(el.isSpicy()){
                 spicies.add(el);
                 br++;
        }
        if(br>3){
            throw new MoreThan3SpicyIngredientsException();
        }

        }

        return spicies;
    }
    //GET /ingredients/{id}/pizzas
*/
}
