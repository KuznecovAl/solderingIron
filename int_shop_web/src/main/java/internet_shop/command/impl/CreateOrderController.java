package internet_shop.command.impl;

import internet_shop.entities.Order;
import internet_shop.services.OrderService;
import internet_shop.entities.User;
import internet_shop.services.OrderServiceImpl;
import internet_shop.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateOrderController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        long productId = (long)req.getAttribute("productId");
        Order order = orderService.createOrder(user.getId(), productId, 0);

        req.setAttribute("order", order);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}