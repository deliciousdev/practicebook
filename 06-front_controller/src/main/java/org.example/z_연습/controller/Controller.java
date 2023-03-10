package org.example.z_연습.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
