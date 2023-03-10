package newlect.servlet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/calculatorfinal")
public class CalculatorFinal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();

        Cookie[] cookies = req.getCookies();


        String exp = "";
        if (cookies != null) {
            exp = getExpCookie(cookies);
        }

        String value_ = req.getParameter("value");
        String operator_ = req.getParameter("operator");

        exp += value_ != null ? value_ : "";
        exp += operator_ != null ? operator_ : "";


        Cookie expCookie = new Cookie ("exp","");
        if (operator_ != null && operator_.equals("=")) {
            exp = calculate(exp);
        }
        else if (operator_ != null && operator_.equals("C")) {
            exp=""; //단순히 보이기에만 초기화됨
            expCookie.setMaxAge(0); // 브라우저에 있는 쿠키자체를 삭제함
        }

        expCookie.setValue(exp);
        expCookie.setPath("/calculatorfinal");
        res.addCookie(expCookie);

        res.sendRedirect("./calculatorfinal"); //redirection 추가
    }


    //자바스크립트를 실행할수 있는 라이브러리 : ScriptEngine
    private String calculate(String exp) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        exp = exp.substring(0, exp.length() - 1);
        try {
            exp = String.valueOf(engine.eval(exp));
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        return exp;
    }

    private String getExpCookie(Cookie[] cookies) {
        String exp;
        exp = Arrays.stream(cookies).filter(c -> c.getName().equals("exp"))
                .map(c -> c.getValue())
                .findFirst()
                .orElse("");
        return exp;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");


        Cookie[] cookies = req.getCookies();

        String exp = Arrays.stream(cookies).filter(c -> c.getName().equals("exp"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse("0");


        exp = exp.equals("") ? "0" : exp;

        PrintWriter out = res.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "\n" +
                "<style>\n" +
                "input {\n" +
                "    width: 50px;\n" +
                "    height: 50px;\n" +
                "}\n" +
                "\n" +
                ".output {\n" +
                "    height: 50px;\n" +
                "    background: #e9e9e9;\n" +
                "    font-size: 24px;\n" +
                "    font-weight : bold;\n" +
                "    text-align: right;\n" +
                "    padding: 0px 5px;\n" +
                "}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<form method=\"post\">\n" +
                "\n" +
                "    <table>\n" +
                "        <tr>\n" );

        out.printf("             <td class =\"output\" colspan =\"4\">%s</td>\n",exp ); // 정적인 html 이였으면 계산된 값인 11이 아니라 "10+1" 이라는문자열로 나오게됨

        out.write("        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"C\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"/\"></td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"7\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"8\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"9\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"*\"></td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"4\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"5\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"6\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"-\"></td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"1\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"2\"></td>\n" +
                "             <td><input type=\"submit\" name=\"value\" value=\"3\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"+\"></td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr>\n" +
                "             <td></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"0\"></td>\n" +
                "             <td><input type=\"submit\" name=\"dot\" value=\".\"></td>\n" +
                "             <td><input type=\"submit\" name=\"operator\" value=\"=\"></td>\n" +
                "        </tr>\n" +
                "\n" +
                "    </table>\n" +
                "\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }
}
