package com.multi.assignment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {
    private String path;
    private boolean isRedirect;

    public LoginAction(String path, boolean isRedirect) {
        this.path = path;
        this.isRedirect = isRedirect;
    }

    @Override
    public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pw = request.getParameter("password");

        if ("user".equals(id) && "1234".equals(pw)) {
            request.setAttribute("loginId", id);
            return new ActionForWard("assignment_0829/success.jsp", false);
        }
        return new ActionForWard("assignment_0829/fail.jsp?err=1", true);
    }
}
