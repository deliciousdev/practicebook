package org.example.d_저장및redirect로직추가.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
