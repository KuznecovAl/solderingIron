package internet_shop.filters;

import internet_shop.command.enums.ControllerType;
import internet_shop.handlers.RequestHandler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static internet_shop.command.enums.ControllerType.ORDERS;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter extends AbstractFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        ControllerType type = RequestHandler.getCommand(req);
        if (ORDERS.equals(type)) {
            String contextPath = req.getContextPath();
            HttpSession session = req.getSession();
            if((session.getAttribute("user") == null)) {
                res.sendRedirect(contextPath + "/frontController?command=login");
                return;
            }
        }
        super.doFilter(request, response, chain);
    }

    @Override
    public void destroy() {

    }
}