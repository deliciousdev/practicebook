package newlect.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/cookie-test")
public class CookieTest extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();

        Cookie[] cookies = req.getCookies();

        String num_ = req.getParameter("mynum");
        String op_ = req.getParameter("operator");
        int num = Integer.parseInt(num_);

        if (op_.equals("=")) {
            int result = 0;
            PrintWriter out = res.getWriter();
//            String beforeOp = (String) session.getAttribute("op");
//            int beforeNum = (int) session.getAttribute("firstNum");
            String beforeOp="";
            int beforeNum=0;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("firstNum")) {
                    beforeNum = Integer.parseInt(cookie.getValue());
                    break;
                }
            }

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("operator")) {
                    beforeOp = cookie.getValue();
                    break;
                }
            }

            if (beforeOp.equals("+")) {
                result += beforeNum + num;
            } else if (beforeOp.equals("-")) {
                result += beforeNum - num;
            }

            out.printf("최종결과는 %d입니다%n", result);
            return;
        }

        insertDataIntoCookie(res, op_, num);
        res.sendRedirect("cookie.html"); //redirection 추가
    }

    private void insertDataIntoCookie(HttpServletResponse response, String op_, int num) {
//        session.setAttribute("firstNum", num);
//        session.setAttribute("op", op_);
        Cookie firstNumCookie = new Cookie("firstNum", String.valueOf(num));
        Cookie operationCookie = new Cookie("operator", op_);

        firstNumCookie.setPath("/cookie-test");
        operationCookie.setPath("/cookie-test");

//        operationCookie.setMaxAge(24*60*60); // 몇초후 만료됨

        response.addCookie(firstNumCookie);
        response.addCookie(operationCookie);
    }
}
