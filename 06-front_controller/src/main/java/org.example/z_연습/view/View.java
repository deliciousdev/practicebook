package org.example.z_연습.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface View {

    void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
