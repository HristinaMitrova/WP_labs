package mk.finki.ukim.mk.lab.web;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PizzaOrder.do")
public class NewOrderServlet extends HttpServlet {
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        String name = getParamFromQuery(request, "pizza");
        String size = getParamFromQuery(request, "pizza_size");
        request.getSession().setAttribute("pizza", name);
        request.getSession().setAttribute("pizza_size", size);
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("/delivery-info");
    }

    private String getParamFromQuery(HttpServletRequest request, String pizza) {
        String URL = request.getRequestURL().toString() + "?" + request.getQueryString();
        MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUriString(URL).build().getQueryParams();
        List<String> nameParams = queryParams.get(pizza);
        return nameParams.get(0).replace('+', ' ');
    }
}
