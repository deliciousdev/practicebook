package org.example.a_기본구조.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
