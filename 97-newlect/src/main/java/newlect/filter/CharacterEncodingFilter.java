package newlect.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter
            (ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");//브라우저에서 보낸것을 utf-8로 디코딩하겟다

        filterChain.doFilter(req,res);

    }

    @Override
    public void destroy() {

    }
}
