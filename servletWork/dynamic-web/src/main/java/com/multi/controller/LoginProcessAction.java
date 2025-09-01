package com.multi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcessAction implements Action{
    private String path;
    private boolean isRedirect;

    public LoginProcessAction(String path, boolean isRedirect) {
        this.path = path;
        this.isRedirect = isRedirect;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    @Override
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
        String id= request.getParameter("id");
        String passwd=request.getParameter("password");
        if(id.equals("admin")&&passwd.equals("1234")){
            request.getSession().setAttribute("admin",id);
            request.getSession().setMaxInactiveInterval(60); //60초
            //로그인 성공시 mvclist.jsp

        }

        return new  ActionForWard(path, isRedirect);

    }
}
