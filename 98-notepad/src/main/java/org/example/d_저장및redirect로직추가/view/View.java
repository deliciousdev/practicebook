package org.example.d_저장및redirect로직추가.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface View {

    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
