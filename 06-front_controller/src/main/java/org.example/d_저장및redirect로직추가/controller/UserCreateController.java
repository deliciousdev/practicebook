package org.example.d_저장및redirect로직추가.controller;

import org.example.d_저장및redirect로직추가.User;
import org.example.d_저장및redirect로직추가.repository.UserMemoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        User user = new User(userId, name);
        UserMemoryRepository.save(user);
        return "redirect:/users";
    }
}
