package a00servlet.b01servlet.a01서블릿인터페이스구현;

import a00servlet.b01servlet.calculator.domain.Calculator;
import a00servlet.b01servlet.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculate")
public class InterfaceCalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(InterfaceCalculatorServlet.class);
    private ServletConfig servletConfig;


    @Override
    public void init(ServletConfig config) throws ServletException {
        //서블릿 라이프 사이클 관련 메서드
        log.info("[CalculatorServlet] init()");

        this.servletConfig = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //서블릿 라이프 사이클 관련 메서드
        log.info("[CalculatorServlet] service()");

        req.setCharacterEncoding("UTF-8");

        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

//        char c = operator.charAt(0);
//        System.out.println((int) c);

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter out = res.getWriter();
        out.printf("result = %d%n", result);
    }

    @Override
    public void destroy() {
        //서블릿 라이프 사이클 관련 메서드
        //resource release
        log.info("[CalculatorServlet] destroy()");
    }

    @Override
    public ServletConfig getServletConfig() {
        //라이프 사이클 관련 외 기타메서드
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        //라이프 사이클 관련 외 기타메서드
        return null;
    }

}
