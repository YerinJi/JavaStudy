package com.multi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface Action {
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response);
}
