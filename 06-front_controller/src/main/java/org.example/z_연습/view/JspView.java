package org.example.z_연습.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JspView implements View {

    private final String viewName;

    public JspView(String viewName) {
        this.viewName = viewName;
    }


    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(this.viewName);//뷰로 넘겨줌
        requestDispatcher.forward(request, response);

    }
}
