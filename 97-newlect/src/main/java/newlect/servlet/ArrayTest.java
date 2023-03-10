package newlect.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/arraytest")
public class ArrayTest extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        String[] mynums = req.getParameterValues("mynum");

        int result=0;
        for(int i=0; i<mynums.length; ++i){
            result+=Integer.parseInt(mynums[i]);
        }

        PrintWriter out = res.getWriter();
        out.printf("결과는 result = %d%n입니다",result);
    }
}
