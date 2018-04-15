package internet_shop.command.impl;

import internet_shop.entities.Address;
import internet_shop.entities.User;
import internet_shop.services.UserService;
import internet_shop.services.UserServiceImpl;
import internet_shop.auth.Encoder;
import internet_shop.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SettingsController implements Controller {

    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        String password = req.getParameter("password");
        String email = req.getParameter("e_mail");
        //String name = new String(req.getParameter("name").getBytes("ISO-8859-1"), Charset.forName("UTF-8"));
        String name = req.getParameter("name");
        String lname = req.getParameter("lname");
        String phone = req.getParameter("phone");
        String address_city = req.getParameter("address_city");
        String address_street = req.getParameter("address_street");
        String address_building = req.getParameter("address_building");
        String address_flat = req.getParameter("address_flat");
        String address_index = req.getParameter("address_index");
        String birthday=req.getParameter("birthday");


        if (password == null){

            req.setAttribute("errorMsg", "Error");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            req.setAttribute("title", "Sett");
            dispatcher.forward(req, resp);
            return;
        }else {

            User user = (User) req.getSession().getAttribute("user");
            user.setEmail(email);

            if ((user.getPassword() != Encoder.encode(password))&(password!=null)&(password!="")) {
                user.setPassword(Encoder.encode(password));
            }


            Address address=new Address("Belarus",address_city,address_street,address_building,address_flat,address_index);
            user.setPhone(phone);
            user.setFirstname(name);
            user.setLastname(lname);
            user.setAddress(address);
            user.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("y-M-d")));
            user.setLang("RU");
            user.setPrivilege("2");
            user.setStatus("reg");
            userService.update(user);
            req.getSession().setAttribute("user", user);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=orders");
            return;
        }

    }
}

