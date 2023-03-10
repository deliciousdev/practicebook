package newlect.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myservleturl3")
public class myServlet3 extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

//        req.setCharacterEncoding("utf-8");//브라우저에서 보낸것을 utf-8로 디코딩하겟다

        res.setCharacterEncoding("utf-8");//내가 브라우저로 보낼것을 utf-8로 인코딩하겠다
        res.setContentType("text/html; charset=utf-8"); //내가 보내는것이 utf-이니 이것을 볼때 utf-8로 디코딩해줘

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        PrintWriter out = res.getWriter();
        out.println("제목 "+title + "<br>");
        out.println("내용 "+content + " <br>");


    }
}
