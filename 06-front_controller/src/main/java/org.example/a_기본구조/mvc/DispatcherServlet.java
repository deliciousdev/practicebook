package org.example.a_기본구조.mvc;

import org.example.a_기본구조.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private MappingHandler mappingHandler;
    private final String WRONG_VIEW = "/view/wrong.jsp";
    //이런식으로 생성자로 초기화해주면안됨 -> init() 으로 초기화 해야함
//    public DispatcherServlet(MappingHandler mappingHandler) {
//        System.out.println("DispatcherServlet.DispatcherServlet");
//        this.mappingHandler = new MappingHandler();
//    }
    @Override
    public void init() throws ServletException {
        this.mappingHandler = new MappingHandler();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[DispatcherServlet] service");

        Controller requestHandler = null;
        String viewName = "";
        try {
            requestHandler = mappingHandler.mappingHandle(req.getRequestURI());
            viewName = requestHandler.handleRequest(req, resp);
        } catch (NullPointerException e) {
            viewName = WRONG_VIEW;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);//뷰로 넘겨줌
        requestDispatcher.forward(req, resp);
    }
}
