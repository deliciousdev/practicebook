package org.example.c_view_viewresolver추가.mvc.viewresolver;

import org.example.c_view_viewresolver추가.mvc.view.JspView;
import org.example.c_view_viewresolver추가.mvc.view.RedirectView;
import org.example.c_view_viewresolver추가.mvc.view.View;

public class JspViewResolver implements ViewResolver{

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
