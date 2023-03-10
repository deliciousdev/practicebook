package org.example.z_연습.viewresolver;

import org.example.z_연습.view.JspView;
import org.example.z_연습.view.RedirectView;
import org.example.z_연습.view.View;

public class JspViewResolver implements ViewResolver {

    private final String PREFIX = ".jsp";
    private final String SUFFIX = "/view/"; //rootContext

    @Override
    public View resolveView(String viewName) {
        if (viewName.startsWith("redirect:")) {
            String redirectURI = viewName.substring("redirect:".length());
            return new RedirectView(redirectURI);
        }
        else {
            return new JspView(SUFFIX+viewName+PREFIX);
        }
    }

}
