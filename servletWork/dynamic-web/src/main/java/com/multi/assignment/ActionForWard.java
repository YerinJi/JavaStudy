package com.multi.assignment;

public class ActionForWard {
    private String path;
    private boolean isRedirect;

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
