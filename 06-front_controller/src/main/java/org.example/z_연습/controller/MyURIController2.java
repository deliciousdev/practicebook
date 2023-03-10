package org.example.z_연습.controller;

import org.example.z_연습.User;
import org.example.z_연습.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyURIController2 implements Controller {

    private UserDao userDao = new UserDao();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String grade = request.getParameter("button");

        User user = userDao.findById(grade);
        if(user!=null){
            if (password.equals(user.getPassword())) {
                request.setAttribute("model",grade +"인증됨");
            }
            else{
                request.setAttribute("msg","비번틀림");
            }
        }
        else{
            request.setAttribute("model","비회원");
        }
        return "get";
    }
}
