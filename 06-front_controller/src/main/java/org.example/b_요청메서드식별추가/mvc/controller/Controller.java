package org.example.b_요청메서드식별추가.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
