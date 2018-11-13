//written by Ann
package app.servlets;

import app.entities.User;
import app.entities.UserSerializer;
import app.server.Connect;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

import static app.entities.User.me;

@WebServlet("/index")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        me = new User();
        me.setName(req.getParameter("name"));
        me.setPassword(req.getParameter("pass"));

        Connect con = new Connect(me.toJSON());
//        System.out.println(me.toJSON());

        resp.sendRedirect(req.getContextPath() + "messenger");

    }
}
