package org.example.a_기본구조.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("[HomeController.handleRequest()]");
        return "/view/home.jsp";
    }
}
