package com.multi.assignment;

public class ActionFactory {
    private static ActionFactory actionFactory;

    public static Action getAction(String cmd){
        Action action=null;
        if(cmd.equals("login")){
            action=new LoginAction("login.doo?cmd=login",false);
        }else if(cmd.equals("list")){
            action=new LoginFailAction("assignment_0829/fail.jsp",true);
        }
        return action;
    }

    public static ActionFactory getInstance() {
        if (actionFactory == null) {
            actionFactory = new ActionFactory();
        }
        return actionFactory;
    }
}
