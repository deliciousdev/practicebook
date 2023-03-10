package org.example.a_기본구조.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(BController.class);
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("[BController.handleRequest()]");
        return "/view/b.jsp";
    }
}
