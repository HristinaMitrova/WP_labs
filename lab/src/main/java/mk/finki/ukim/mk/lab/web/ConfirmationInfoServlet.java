package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ConfirmationInfo.do")
public class ConfirmationInfoServlet extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;
    ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        String name = request.getSession().getAttribute("pizza").toString();
        String size = request.getSession().getAttribute("pizza_size").toString();
        String userName = request.getParameter("clientName");
        String address = request.getParameter("clientAddress");
        response.setContentType("text/html; charset=UTF-8");
        webContext.setVariable("pizza", name);
        webContext.setVariable("pizza_size", size);
        webContext.setVariable("clientName", userName);
        webContext.setVariable("clientAddress", address);
        webContext.setVariable("ip_address", request.getRemoteAddr());
        webContext.setVariable("browser", request.getHeader("User-Agent"));

        springTemplateEngine.process("confirmationInfo.html", webContext, response.getWriter());
    }


}
