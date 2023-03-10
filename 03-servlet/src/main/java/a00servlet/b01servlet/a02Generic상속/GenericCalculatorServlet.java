package a00servlet.b01servlet.a02Generic상속;

import a00servlet.b01servlet.calculator.domain.Calculator;
import a00servlet.b01servlet.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculate/generic")
public class GenericCalculatorServlet extends GenericServlet {

    private static final Logger log = LoggerFactory.getLogger(GenericCalculatorServlet.class);

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //서블릿 라이프 사이클 관련 메서드
        log.info("[GenericCalculatorServlet] service()");

        req.setCharacterEncoding("UTF-8");

        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));


        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter out = res.getWriter();
        out.printf("result = %d%n", result);
    }
}
