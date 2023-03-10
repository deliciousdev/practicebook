package newlect.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculatorurl")
public class CalculatorServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");

        String x_ = req.getParameter("x");
        String y_ = req.getParameter("y");
        String operator = req.getParameter("operator");
        int x=0;
        int y=0;

        if(isValid(x_)){
            x = Integer.parseInt(x_);
        }
        if (isValid(y_)) {
            y = Integer.parseInt(y_);
        }

        int result=0;
        switch (operator) {
            case "add":
                result= x+y;
                break;
            case "subtract":
                result=x-y;
                break;
        }

        PrintWriter out = res.getWriter();
        out.println("결과는 다음과 같습니다 <br/>");
        out.printf("result is %d%n",result);
    }

    private boolean isValid(String input) {
        return !input.equals("");
    }
}
