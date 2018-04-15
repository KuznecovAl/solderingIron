package internet_shop.command.impl;

import internet_shop.entities.User;
import internet_shop.services.old.UserService;
import internet_shop.services.old.UserServiceImpl;
import internet_shop.auth.Encoder;
import internet_shop.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {

    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login==null || password==null) {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
        User user = userService.getByLogin(login);
        if (user != null && user.getPassword().equals(Encoder.encode(password))) {
//        if (user != null && password.equals(user.getPassword())) {
            req.getSession().setAttribute("user", user);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+ "/frontController?command=orders");
            return;
        } else {
            req.setAttribute("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Login form");
            dispatcher.forward(req, resp);
            return;
        }
    }
}
