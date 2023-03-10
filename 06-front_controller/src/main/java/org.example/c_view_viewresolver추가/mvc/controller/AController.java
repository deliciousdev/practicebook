package org.example.c_view_viewresolver추가.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AController implements Controller {

    private static final Logger log = LoggerFactory.getLogger(AController.class);
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("[AController.handleRequest()]");
        return "a";
//        return "/view/a.jsp";
    }
}
