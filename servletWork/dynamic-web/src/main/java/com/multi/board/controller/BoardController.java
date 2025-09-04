package com.multi.board.controller;

import com.multi.board.dto.Board;
import com.multi.board.dto.Member;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;
import com.multi.board.service.BoardService;
import com.multi.board.service.BoardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet(name="boardController", urlPatterns={"/board"})
public class BoardController extends HttpServlet {
    private final BoardService svc = new BoardServiceImpl();

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = nvl(req.getParameter("action"), "list");
        switch(action){
            case "list": {
                int page=pi(req.getParameter("page"),1), size=pi(req.getParameter("size"),10);
                String q=req.getParameter("q"), type=req.getParameter("type");
                PageResult<Board> pr = svc.list(new PageRequest(page,size), type, q);
                req.setAttribute("boards", pr.getItems());
                req.setAttribute("pageResult", pr);
                req.setAttribute("q", q); req.setAttribute("type", type);
                req.getRequestDispatcher("/jsp/member/list.jsp").forward(req, resp);
                break;
            }
            case "view": {
                long id=pl(req.getParameter("id"),0L);
                Board b=svc.view(id);
                req.setAttribute("board", b);
                req.getRequestDispatcher("/jsp/member/detail.jsp").forward(req, resp);
                break;
            }
            case "write":  requireLogin(req); req.getRequestDispatcher("/jsp/member/write.jsp").forward(req, resp); break;
            case "edit": {
                Member login=requireLogin(req);
                long id=pl(req.getParameter("id"),0L);
                Board b=svc.view(id); // 조회수 +1 싫으면 svc.list-findById 따로 만들기
                if(b.getWriterId()!=login.getId()) throw new ServletException("작성자만 수정 가능");
                req.setAttribute("board", b);
                req.getRequestDispatcher("/jsp/member/edit.jsp").forward(req, resp);
                break;
            }
            case "delete": doPost(req, resp); break; // POST 권장
            default: resp.sendError(404);
        }
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = nvl(req.getParameter("action"), "");
        switch(action){
            case "write": {
                Member login = requireLogin(req);
                long id = svc.write(req.getParameter("title"), req.getParameter("content"), login.getId());
                resp.sendRedirect(req.getContextPath()+"/board?action=view&id="+id);
                break;
            }
            case "edit": {
                Member login = requireLogin(req);
                long id = pl(req.getParameter("id"),0L);
                svc.edit(id, req.getParameter("title"), req.getParameter("content"), login.getId());
                resp.sendRedirect(req.getContextPath()+"/board?action=view&id="+id);
                break;
            }
            case "delete": {
                Member login = requireLogin(req);
                long id = pl(req.getParameter("id"),0L);
                svc.remove(id, login.getId());
                resp.sendRedirect(req.getContextPath()+"/board?action=list");
                break;
            }
            default: resp.sendError(400);
        }
    }

    private Member requireLogin(HttpServletRequest req) throws ServletException {
        HttpSession s=req.getSession(false);
        Member m=(s==null)?null:(Member)s.getAttribute("loginMember");
        if(m==null) throw new ServletException("로그인이 필요합니다.");
        return m;
    }
    private String nvl(String s,String d){ return (s==null||s.isBlank())?d:s; }
    private int pi(String s,int d){ try{return Integer.parseInt(s);}catch(Exception e){return d;} }
    private long pl(String s,long d){ try{return Long.parseLong(s);}catch(Exception e){return d;} }
}
