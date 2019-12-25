package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.service.PizzaServiceInterface;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class ShowPizzaServlet extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;
    private PizzaServiceInterface pizzaService;

    ShowPizzaServlet(SpringTemplateEngine springTemplateEngine, PizzaServiceInterface pizzaService){
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("listOfPizzas", pizzaService.listPizzas());
        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("listPizzas.html", webContext, response.getWriter());
    }
}
