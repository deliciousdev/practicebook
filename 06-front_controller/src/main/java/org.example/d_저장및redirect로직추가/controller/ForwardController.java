package org.example.d_저장및redirect로직추가.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "user/form";
    }
}
