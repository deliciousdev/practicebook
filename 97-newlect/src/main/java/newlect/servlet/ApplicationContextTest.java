package newlect.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/application-test")
public class ApplicationContextTest extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-8");
        ServletContext context = req.getServletContext();

        String num_ = req.getParameter("mynum");
        String op_ = req.getParameter("operator");
        int num = Integer.parseInt(num_);

        if (op_.equals("=")) {
            int result = 0;
            PrintWriter out = res.getWriter();
            String beforeOp = (String) context.getAttribute("op");
            int beforeNum = (int) context.getAttribute("firstNum");

            if (beforeOp.equals("+")) {
                result += beforeNum + num;
            } else if (beforeOp.equals("-")) {
                result += beforeNum - num;
            }

            out.printf("최종결과는 %d입니다%n", result);
            return;
        }

        insertDataIntoApplication(context, op_, num);
    }

    private void insertDataIntoApplication(ServletContext context, String op_, int num) {
        context.setAttribute("firstNum", num);
        context.setAttribute("op", op_);
    }
}
