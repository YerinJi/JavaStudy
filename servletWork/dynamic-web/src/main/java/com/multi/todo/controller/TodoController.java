package com.multi.todo.controller;

import com.multi.todo.dto.Todo;
import com.multi.todo.service.TodoService;
import com.multi.todo.service.TodoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/todo")
public class TodoController extends HttpServlet {

    private final TodoService service = new TodoServiceImpl();

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatch(req, resp);
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        dispatch(req, resp);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = nvl(req.getParameter("action"), "list");
        try {
            switch (action) {
                case "list"      -> list(req, resp);
                case "view"      -> view(req, resp);
                case "writeForm" -> writeForm(req, resp);
                case "write"     -> write(req, resp);
                case "editForm"  -> editForm(req, resp);
                case "edit"      -> edit(req, resp);
                case "toggle"    -> toggle(req, resp);
                case "delete"    -> delete(req, resp);
                default -> resp.sendError(404, "Unknown action: " + action);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String q        = req.getParameter("q");
        String status   = req.getParameter("status");
        String category = req.getParameter("category");
        String priority = req.getParameter("priority");
        String due      = req.getParameter("due");
        String sort     = req.getParameter("sort");
        String order    = req.getParameter("order");

        List<Todo> items = service.list(q, status, category, priority, due, sort, order);
        req.setAttribute("items", items);
        req.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(req, resp);
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = toLong(req.getParameter("id"), -1);
        if (id <= 0) { resp.sendRedirect(req.getContextPath() + "/todo?action=list"); return; }
        Todo todo = service.view(id);
        if (todo == null) { resp.sendRedirect(req.getContextPath() + "/todo?action=list"); return; }
        req.setAttribute("todo", todo);
        req.getRequestDispatcher("/WEB-INF/views/todo/view.jsp").forward(req, resp);
    }

    private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/WEB-INF/views/todo/write.jsp").forward(req, resp);
    }

    private void write(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = service.write(
                req.getParameter("title"),
                req.getParameter("description"),
                req.getParameter("category"),
                toInt(req.getParameter("priority"), 3),
                nvl(req.getParameter("status"), "TODO"),
                parseDateTimeLocal(req.getParameter("dueAt"))
        );
        resp.sendRedirect(req.getContextPath() + "/todo?action=view&id=" + id);
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = toLong(req.getParameter("id"), -1);
        if (id <= 0) { resp.sendRedirect(req.getContextPath() + "/todo?action=list"); return; }
        Todo todo = service.view(id);
        if (todo == null) { resp.sendRedirect(req.getContextPath() + "/todo?action=list"); return; }
        if (todo.getDueAt() != null) {
            req.setAttribute("dueAtForEdit", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(todo.getDueAt()));
        }
        req.setAttribute("todo", todo);
        req.getRequestDispatcher("/WEB-INF/todo/edit.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = toLong(req.getParameter("id"), -1);
        service.edit(
                id,
                req.getParameter("title"),
                req.getParameter("description"),
                req.getParameter("category"),
                toInt(req.getParameter("priority"), 3),
                nvl(req.getParameter("status"), "TODO"),
                parseDateTimeLocal(req.getParameter("dueAt"))
        );
        resp.sendRedirect(req.getContextPath() + "/todo?action=view&id=" + id);
    }

    private void toggle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = toLong(req.getParameter("id"), -1);
        if (id > 0) service.toggleStatus(id);
        String ref = req.getHeader("Referer");
        resp.sendRedirect(ref != null ? ref : (req.getContextPath() + "/todo?action=list"));
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long id = toLong(req.getParameter("id"), -1);
        if (id > 0) service.delete(id);
        resp.sendRedirect(req.getContextPath() + "/todo?action=list");
    }

    /* helpers */
    private static String nvl(String s, String d){ return (s==null||s.isBlank())?d:s; }
    private static int toInt(String s,int d){ try{ return Integer.parseInt(s);}catch(Exception e){ return d;}}
    private static long toLong(String s,long d){ try{ return Long.parseLong(s);}catch(Exception e){ return d;}}
    private static Timestamp parseDateTimeLocal(String s){
        if(s==null||s.isBlank()) return null;
        return Timestamp.valueOf(s.replace("T"," ") + ":00");
    }
}
