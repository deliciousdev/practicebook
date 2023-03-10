package newlect.servlet;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/dynamic")
public class Dynamic extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
        res.addCookie(expCookie);
        res.sendRedirect("./dynamicpage"); //redirection 추가
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
}
