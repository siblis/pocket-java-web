package app.servlets;

import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        if(name.equals("root") && password.equals("pass")){

            req.getSession().setAttribute("username", name);
            User.me = new User(name, password);
            resp.sendRedirect(req.getContextPath() + "messenger");

        } else{
            //нужно выводить сообщение о неверном логине/пароле в каком-нибудь диве в index.jsp
            PrintWriter pw = resp.getWriter();
            pw.println("Wrong login / password!");

        }
    }
}
