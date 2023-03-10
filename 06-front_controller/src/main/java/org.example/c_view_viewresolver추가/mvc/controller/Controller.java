package org.example.c_view_viewresolver추가.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
