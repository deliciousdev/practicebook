package org.example.z_연습.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RedirectView implements View {

    private final String redirectURI;

    public RedirectView(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    @Override
    public void render( HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect(redirectURI);

    }
}
