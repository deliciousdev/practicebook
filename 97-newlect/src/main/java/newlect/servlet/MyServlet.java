package newlect.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        String cnt_ = req.getParameter("cnt");
        int cnt=10;
        if (cnt_ != null && !cnt_.equals("") ) {
            cnt = Integer.parseInt(cnt_);
        }
        for(int i=0; i<cnt; ++i){
            out.println(i+1 +" 안녕 servlet<br>");
        }
    }
}
