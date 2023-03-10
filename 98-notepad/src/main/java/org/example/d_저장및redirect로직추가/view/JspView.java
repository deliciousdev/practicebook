package org.example.d_저장및redirect로직추가.view;

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
        System.out.println(this.viewName);

    }


    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model.forEach(request::setAttribute);//한방에 에 깔끔하게

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(this.viewName);//뷰로 넘겨줌
        requestDispatcher.forward(request, response);

    }
}
