package newlect.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/dynamicpage")
public class DynamicPage extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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
                "<form action=\"dynamic\" method=\"post\">\n" +
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
