package org.scoula.dynamicweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter pw = response.getWriter();
            String html = "<HTML><HEAD></HEAD><BODY><h1>hi</h1></BODY></HTML>";
            pw.write(html);

        }
}

