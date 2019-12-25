package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.enumerations.PizzaSize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/create")
public class CreatePizzaServlet extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;

    CreatePizzaServlet(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        String name = getParamFromQuery(request, "pizza");
        request.getSession().setAttribute("pizza", name);
        webContext.setVariable("pizza", name);
        webContext.setVariable("pizzaSizes", PizzaSize.values());
        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("selectPizzaSize.html", webContext, response.getWriter());
    }

    private String getParamFromQuery(HttpServletRequest request, String pizza) {
        String URL = request.getRequestURL().toString() + "?" + request.getQueryString();
        MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUriString(URL).build().getQueryParams();
        List<String> nameParams = queryParams.get(pizza);
        return nameParams.get(0).replace('+', ' ');
    }
}
