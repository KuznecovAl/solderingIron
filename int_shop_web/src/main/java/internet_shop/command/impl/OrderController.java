package internet_shop.command.impl;

import internet_shop.Item;
import internet_shop.Order;
import internet_shop.Product;
import internet_shop.User;
import internet_shop.ItemService;
import internet_shop.OrderService;
import internet_shop.ProductService;
import internet_shop.ItemServiceImpl;
import internet_shop.OrderServiceImpl;
import internet_shop.ProductServiceImpl;
import internet_shop.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OrderController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();
    private ItemService itemService = ItemServiceImpl.getInstance();
    private ProductService productService = ProductServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.getByUserId(user.getId());
        List<Item> itemss = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            itemss.addAll(itemService.getByOrderId(orders.get(i).getId()));
        }

        for (int i = 0; i < itemss.size(); i++) {
            products.add(productService.get(itemss.get(i).getId_product()));
        }

        req.setAttribute("orders", orders);
        req.setAttribute("itemss", itemss);
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
