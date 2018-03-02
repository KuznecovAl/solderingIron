package internet_shop.command.impl;

import internet_shop.ProductService;
import internet_shop.ProductServiceImpl;
import internet_shop.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProductController implements Controller {
    private ProductService productService = ProductServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("products", productService.getAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
