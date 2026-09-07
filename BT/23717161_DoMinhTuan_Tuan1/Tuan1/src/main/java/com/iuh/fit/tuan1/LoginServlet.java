package com.iuh.fit.tuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet(){

    };

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("txtName");
        String password = req.getParameter("txtPassword");

        if(username.equals("admin") && password.equals("123456")){
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/home.jsp");
        }
        else {
            req.setAttribute("error", "Tài khoảng không hợp lệ");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
