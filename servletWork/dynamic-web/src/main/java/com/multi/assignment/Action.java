package com.multi.assignment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response);
}
