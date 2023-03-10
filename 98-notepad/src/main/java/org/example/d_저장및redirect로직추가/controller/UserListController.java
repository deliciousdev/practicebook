package org.example.d_저장및redirect로직추가.controller;

import org.example.d_저장및redirect로직추가.repository.UserMemoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", UserMemoryRepository.findAll() );
        return "user/list";
    }
}
