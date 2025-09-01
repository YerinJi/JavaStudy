package com.multi.controller;

//비즈니스로직을 수행하고 어느페이지로 어떻게 이동할지 판단하는 클래스
//path list.jsp로 이동하거나. list.do?cmd=list와 같은 path이동
public class ActionForWard {
    private boolean isRedirect;
    private String path;

    public ActionForWard() {
    }

    public ActionForWard(String path, boolean isRedirect ) {
        this.isRedirect = isRedirect;
        this.path = path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
