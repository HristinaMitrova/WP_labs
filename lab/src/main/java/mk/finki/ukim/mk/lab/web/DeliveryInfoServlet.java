package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delivery-info")
public class DeliveryInfoServlet extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;

    DeliveryInfoServlet(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("pizza", request.getSession().getAttribute("pizza"));
        webContext.setVariable("pizza_size", request.getSession().getAttribute("pizza_size"));
        response.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("deliveryInfo.html", webContext, response.getWriter());
    }
}
