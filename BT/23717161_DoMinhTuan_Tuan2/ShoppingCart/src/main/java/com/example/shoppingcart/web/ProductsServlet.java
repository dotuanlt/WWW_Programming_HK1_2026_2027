package com.example.shoppingcart.web;

import com.example.shoppingcart.service.ProductCatalog;
import com.example.shoppingcart.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "products", value = "/products")
public class ProductsServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!userSession.isLoggedIn()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.setAttribute("productList", productCatalog.findAll());
        req.setAttribute("userSession", userSession);
        req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
    }
}
