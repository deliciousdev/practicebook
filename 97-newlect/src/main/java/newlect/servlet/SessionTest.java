package newlect.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/session-test")
public class SessionTest extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-8");
//        ServletContext context = req.getServletContext();
        HttpSession session = req.getSession();

        String num_ = req.getParameter("mynum");
        String op_ = req.getParameter("operator");
        int num = Integer.parseInt(num_);

        if (op_.equals("=")) {
            int result = 0;
            PrintWriter out = res.getWriter();
            String beforeOp = (String) session.getAttribute("op");
            int beforeNum = (int) session.getAttribute("firstNum");

            if (beforeOp.equals("+")) {
                result += beforeNum + num;
            } else if (beforeOp.equals("-")) {
                result += beforeNum - num;
            }

            out.printf("최종결과는 %d입니다%n", result);
            return;
        }

        insertDataIntoSession(session, op_, num);
    }

    private void insertDataIntoSession(HttpSession session, String op_, int num) {
        session.setAttribute("firstNum", num);
        session.setAttribute("op", op_);
    }
}
