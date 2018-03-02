package internet_shop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "LocaleFilter")
public class LocaleFilter extends AbstractFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String locale = request.getParameter("locale");
        if (locale != null && !locale.isEmpty()) {
            ((HttpServletRequest)request).getSession().setAttribute("locale", locale);
        }
        super.doFilter(request, response, filterChain);

    }

    @Override
    public void destroy() {

    }
}
