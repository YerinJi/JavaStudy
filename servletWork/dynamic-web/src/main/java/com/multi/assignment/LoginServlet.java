package com.multi.assignment;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.doo")
public class LoginServlet extends HttpServlet {

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
