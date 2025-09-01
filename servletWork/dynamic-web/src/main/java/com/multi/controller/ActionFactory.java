package com.multi.controller;

//Mapper의 역할을 수행
public class ActionFactory {
    private static ActionFactory actionFactory;

    //싱글패턴 (단 한번생성)
    public static ActionFactory getInstance() {
        if (actionFactory == null) {
            actionFactory = new ActionFactory();
        }
        return actionFactory;
    }
    //DispatcherServlet으로부터 cmd를 전달받아서 명령과 관련된 객체 생성
    public Action getAction(String cmd){
        Action action=null;
        if(cmd.equals("write")){//write.do?cmd=write
            action=new WriteAction("list.do?cmd=list",true);
        }else if(cmd.equals("list")){//*.do라는 url이면 getAction이 불려진다
            action=new ListAction("view/mvclist.jsp",false);
            //new ListAction생성할때, path, redirect는 ActionForward로 저장
        }else if(cmd.equals("loginui")){
            action = new UiAction("view/mvclogin.jsp", false);
            //mvclogin.jsp를 forward로 보여주기
        }else if(cmd.equals("loginprocess")){
            action = new LoginProcessAction("list.do?cmd=list", true);
        }
        return action;
    }
}

