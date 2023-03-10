package newlect.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/method")
public class Method extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp); //부모에서 자동으로 get or post 로 분기해줌. 물론 지금 이 service() 를 오버라이딩 안하면 자동으로 super.service()가 호출됨.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("get 함수입니다");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("post 함수입니다");
    }
}
