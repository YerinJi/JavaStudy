package com.multi.board.controller;

import com.multi.board.dto.Member;
import com.multi.board.exception.AppException;
import com.multi.board.service.MemberService;
import com.multi.board.service.MemberServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet(name="memberController", urlPatterns={"/member"})
public class MemberController extends HttpServlet {
    private final MemberService svc = new MemberServiceImpl();

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = nvl(req.getParameter("action"), "login");
        switch(action){
            case "login":  req.getRequestDispatcher("/jsp/member/login.jsp").forward(req, resp); break;
            case "join":   req.getRequestDispatcher("/jsp/member/join.jsp").forward(req, resp);  break;
            case "logout": req.getSession().invalidate(); resp.sendRedirect(req.getContextPath()+"/board?action=list"); break;
            default: resp.sendError(404);
        }
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = nvl(req.getParameter("action"), "");
        try{
            if("login".equals(action)){
                Member m = svc.login(req.getParameter("username"), req.getParameter("password"));
                req.getSession(true).setAttribute("loginMember", m);
                resp.sendRedirect(req.getContextPath()+"/board?action=list");
            }else if("join".equals(action)){
                svc.join(req.getParameter("username"), req.getParameter("password"), req.getParameter("nickname"));
                resp.sendRedirect(req.getContextPath()+"/member?action=login");
            }else resp.sendError(400);
        }catch(Exception e){
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/jsp/member/"+("join".equals(action)?"join":"login")+".jsp").forward(req, resp);
        }
    }
    private String nvl(String s, String d){ return (s==null||s.isBlank())?d:s; }
}
