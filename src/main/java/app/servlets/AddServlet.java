package app.servlets;

import app.entities.User;
import app.model.Model;
import app.server.Connect;
import app.server.responseProcessing.ResponseReg;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static app.entities.User.me;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("views/add.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String respReg;

        String pwd = req.getParameter("pass");
        String confirm_pwd = req.getParameter("pass_confirm");

        if (pwd.equals(confirm_pwd)) {
            me = new User();
            me.setName(req.getParameter("name"));
            me.setEmail(req.getParameter("email"));
            me.setPassword(req.getParameter("pass"));

//        String name = req.getParameter("name");
//        String password = req.getParameter("pass");
//        String email = req.getParameter("email");
//
//        User user = new User(name, email, password);
            try {
                respReg = Connect.connect(me.toJSON(), Connect.POST, Connect.USERS);
                System.out.println(respReg);
                if (ResponseReg.resp(respReg).equals("OK")) {
                    req.setAttribute("error_msg", "Пользователь успешно создан");
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error_msg", ResponseReg.resp(respReg));
                    this.getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("error_msg", "Пароли не совпадают");
            this.getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);
        }
//        Model model = Model.getInstance();
//        model.add(user);
//
//        req.setAttribute("userName", name);
//        doGet(req, resp);
    }
}
