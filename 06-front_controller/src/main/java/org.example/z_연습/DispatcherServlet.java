package org.example.z_연습;

import org.example.z_연습.controller.Controller;
import org.example.z_연습.mappinghandler.MappingHandler;
import org.example.z_연습.mappinghandler.MappingTableKey;
import org.example.z_연습.view.View;
import org.example.z_연습.viewresolver.JspViewResolver;
import org.example.z_연습.viewresolver.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private final String WRONG_VIEW = "wrong";

    private MappingHandler mappingHandler;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {
        this.mappingHandler = new MappingHandler();
        this.viewResolver = new JspViewResolver();
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

        View view = viewResolver.resolveView(viewName);
        view.render( req, resp);
    }
}
