package com.multi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
mvc로 로그인
1. index에서 login을 click했을때... mvclogin.jsp화면에 나오게한다.
2. 로그인 화면에서 로그인버튼을 눌렀을때... login.do?cmd=login
    LoginAction에서 로그인을 db로 체크하고 
 */

@WebServlet("*.do") //MVC에서 대장 컨트롤러
public class DispatcherServlet extends HttpServlet {
    /*
    1. 명령줄의 인수를 받는다.
    2. 명령에 대한 Action을 생성한다.
    3. 해당 Action을 호출한다. (비즈니스 로직을 수행한다.)
    4. Action을 수행하고 ActionForWard를 return 한다.
    5. redirect or forward 여부에 따라 페이지 이동한다.
    6.
     */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String cmd=request.getParameter("cmd");
        Action action=ActionFactory.getInstance().getAction(cmd); //Upcasting
        ActionForWard actionForWard = action.execute(request, response);
        if(actionForWard!=null){
            if(actionForWard.isRedirect()){//redirect로 이동 (2번 호출)
                response.sendRedirect(actionForWard.getPath());

            }else{ //forward는 리소스를 얻기 위해 내부적으로 한번 호출
                RequestDispatcher dispatcher=request.getRequestDispatcher(actionForWard.getPath());
                dispatcher.forward(request,response);
            }
        }
    }
}
