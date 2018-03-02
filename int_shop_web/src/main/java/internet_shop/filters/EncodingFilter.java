package internet_shop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*", }, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class EncodingFilter extends AbstractFilter implements Filter {


  private String encoding;
  private FilterConfig filterConfig;

  public void doFilter(ServletRequest request,

                       ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      response.setContentType("text/html; charset=" + encoding);
      response.setCharacterEncoding(encoding);
      request.setCharacterEncoding(encoding);
      super.doFilter(request, response, filterChain);

  }

  public void init (FilterConfig fc) throws ServletException {

      ServletContext context = fc.getServletContext();

      FilterRegistration registration2 = context.getFilterRegistration("AuthFilter");
      registration2.addMappingForUrlPatterns(null, true, "/*");


      FilterRegistration registration22 = context.getFilterRegistration("LocaleFilter");
      registration22.addMappingForUrlPatterns(null, true, "/*");

      this.filterConfig = fc;
      this.encoding = filterConfig.getInitParameter("encoding");
  }


  public void destroy() {
  }
}
