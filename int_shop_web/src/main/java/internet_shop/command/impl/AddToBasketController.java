package internet_shop.command.impl;

import com.google.gson.Gson;
import internet_shop.command.Controller;
import internet_shop.OrderService;
import internet_shop.OrderServiceImpl;
import internet_shop.vo.BasketVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AddToBasketController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketVO basket = (BasketVO) req.getSession().getAttribute("basket");
        if (basket == null) {
            basket = new BasketVO(new HashMap<>());
            req.getSession().setAttribute("basket", basket);
        }
        long productId = Long.parseLong(req.getParameter("productId"));
//        String id = req.getReader().readLine();
//        Gson in = new Gson();
//        long productId = in.fromJson(id, Long.class);
        AtomicInteger count = basket.getBasket().get(productId);
        int currentCount = 0;
        if (count == null) {
            count = new AtomicInteger();
            count.set(1);
            currentCount = 1;
        } else {
            currentCount = count.incrementAndGet();
        }
        basket.getBasket().put(productId, count);
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(currentCount));
    }
}
