package iuh.fit.demo.cdi;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CDITest", value = "/cdiTest")
public class CdiTestServlet extends HttpServlet {
    @Inject
    private HelloBean helloBean;

    @Inject
    private String appName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> RequestScoped: " + helloBean.sayHello() + "</h1>");
        out.println("<h1> ApplicationScoped: " + appName + "</h1>");

    }
}
