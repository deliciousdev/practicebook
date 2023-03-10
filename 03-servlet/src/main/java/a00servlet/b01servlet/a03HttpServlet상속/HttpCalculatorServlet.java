package a00servlet.b01servlet.a03HttpServlet상속;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calculate/http")
public class HttpCalculatorServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(HttpCalculatorServlet.class);

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("[HttpCalculatorServlet] service()");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doPost()");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doPut()");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doDelete()");
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doHead()");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[HttpCalculatorServlet] doOptions()");
    }


}
