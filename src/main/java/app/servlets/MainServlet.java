package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/messenger.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        if(!name.equals("root") && !password.equals("pass")){
            PrintWriter pw = resp.getWriter();
            pw.println("Wrong login / password!");
        } else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/messenger.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
