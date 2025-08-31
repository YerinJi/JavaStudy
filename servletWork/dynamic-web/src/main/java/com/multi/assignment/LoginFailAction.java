package com.multi.assignment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFailAction implements Action {
    private String path;
    private boolean isRedirect;

    public LoginFailAction(String path, boolean isRedirect) {
        this.path = path;
        this.isRedirect = isRedirect;
    }

    @Override
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
        return new ActionForWard(path, isRedirect);
    }
}
