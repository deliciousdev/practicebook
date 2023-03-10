package newlect.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestFilter.init");
    }

    @Override
    public void destroy() {
        System.out.println("TestFilter.destroy");
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("dofilter 전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("dofilter 후");

    }
}
