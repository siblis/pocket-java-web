//written by Ann & Artem changes by mifendos
package app.servlets;

import app.entities.User;
import app.responseProcessing.ResponseAuth;
import app.server.Connect;
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
        String respAuth;
        me = new User();
        me.setName(req.getParameter("name"));
        me.setPassword(req.getParameter("pass"));

        try {
            respAuth = Connect.connect(me.toJSON(), Connect.PUT, Connect.AUTH_PATH);
            if (ResponseAuth.resp(respAuth).equals("OK"))
                resp.sendRedirect(req.getContextPath() + "messenger");
            else {
                req.setAttribute("error_msg", ResponseAuth.resp(respAuth));
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(respAuth);
    }
}
