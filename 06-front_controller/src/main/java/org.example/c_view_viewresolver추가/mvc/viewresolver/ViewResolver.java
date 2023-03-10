package org.example.c_view_viewresolver추가.mvc.viewresolver;

import org.example.c_view_viewresolver추가.mvc.view.View;

public interface ViewResolver {

    View resolveView(String viewName);
}
