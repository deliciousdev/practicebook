package org.example.c_view_viewresolver추가.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RedirectView implements View{

    private final String redirectURI;

    public RedirectView(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect(redirectURI);

    }
}
