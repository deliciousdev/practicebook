package org.example.z_연습.controller;

import org.example.z_연습.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyURIController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("msg", "");
        request.setAttribute("model","");
        return "get";
    }
}
