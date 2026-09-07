package com.example.shoppingcart.web;

import com.example.shoppingcart.service.AuthenticationService;
import com.example.shoppingcart.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(userSession.isLoggedIn()) {
            resp.sendRedirect(req.getContextPath() + "/products");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!authenticationService.authenticate(username, password)) {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            return;
        }
        userSession.login(username);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
