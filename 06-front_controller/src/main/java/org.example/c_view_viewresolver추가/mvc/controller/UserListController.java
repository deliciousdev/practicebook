package org.example.c_view_viewresolver추가.mvc.controller;

import org.example.c_view_viewresolver추가.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", List.of(new User("1", "tony"), new User("2", "tom")));
        return "user/list";
//        return "/view/user/list.jsp";
    }
}
