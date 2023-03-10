package org.example.d_저장및redirect로직추가.viewresolver;

import org.example.d_저장및redirect로직추가.view.JspView;
import org.example.d_저장및redirect로직추가.view.RedirectView;
import org.example.d_저장및redirect로직추가.view.View;

public class JspViewResolver implements ViewResolver {

    private final String PREFIX = ".jsp";
    private final String SUFFIX = "/WEB-INF/view/"; //rootContext

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
