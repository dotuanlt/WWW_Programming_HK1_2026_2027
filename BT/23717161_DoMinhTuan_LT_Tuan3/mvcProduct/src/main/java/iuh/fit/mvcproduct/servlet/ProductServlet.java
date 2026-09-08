package iuh.fit.mvcproduct.servlet;

import iuh.fit.mvcproduct.dao.ProductDAO;
import iuh.fit.mvcproduct.model.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Resource(name = "jdbc/productdb")
    private DataSource dataSource;

    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        try{
            productDAO = new ProductDAO(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listProducts(req, resp);
                break;

            case "detail":
                showDetail(req, resp);
                break;

            case "edit":
                showEditForm(req, resp);
                break;

            case "delete":
                deleteProduct(req, resp);
                break;

            default:
                listProducts(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "update": updateProduct(req, resp);
                    break;

            default: resp.sendRedirect(req.getContextPath() + "/products");
                    break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getAllProduct();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/listProducts.jsp").forward(req, resp);
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = productDAO.getProductById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/views/productDetail.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = productDAO.getProductById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/views/editProduct.jsp").forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);

        productDAO.updateProduct(product);
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        productDAO.deleteProduct(id);
        resp.sendRedirect(req.getContextPath() + "/products");
    }

}
