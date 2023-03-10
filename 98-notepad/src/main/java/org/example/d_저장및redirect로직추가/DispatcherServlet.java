package org.example.d_저장및redirect로직추가;

import org.example.d_저장및redirect로직추가.controller.Controller;
import org.example.d_저장및redirect로직추가.mappinghandler.MappingHandler;
import org.example.d_저장및redirect로직추가.mappinghandler.MappingTableKey;
import org.example.d_저장및redirect로직추가.view.View;
import org.example.d_저장및redirect로직추가.viewresolver.JspViewResolver;
import org.example.d_저장및redirect로직추가.viewresolver.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


//@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private final String WRONG_VIEW = "wrong";

    private MappingHandler mappingHandler;
    private List<ViewResolver> viewResolvers;


    @Override
    public void init() throws ServletException {
        this.mappingHandler = new MappingHandler();
        this.viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[DispatcherServlet] service");

        Controller requestHandler = null;
        String viewName = "";
        try {
            requestHandler = mappingHandler.mappingHandle(
                    new MappingTableKey(req.getRequestURI(), RequestMethod.valueOf(req.getMethod())));

            viewName = requestHandler.handleRequest(req, resp);
        } catch (NullPointerException e) {
            viewName = WRONG_VIEW;
        }

        for (ViewResolver viewResolver : viewResolvers) {
            View view = viewResolver.resolveView(viewName);
            view.render(new HashMap<>(), req, resp);
        }
    }
}
