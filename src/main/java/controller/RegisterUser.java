package controller;

import connectionDB.ConnectionDB;
import dao.UserDAOImpl;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String rePass = req.getParameter("rePass");

            Users us = new Users();
            us.setUserName(userName);
            us.setPassword(password);
            HttpSession session = req.getSession();
            if (rePass.equals(password)) {
                if (password.length() >= 6 && password.length() <= 8) {
                    UserDAOImpl userDAO = new UserDAOImpl(ConnectionDB.getConnection());
                    boolean f = userDAO.registerUser(us);
                    if (f) {
                        session.setAttribute("succMsg", "Registration Successfully");
                        resp.sendRedirect("login.jsp");

                    } else {
                        //System.out.println("Something wrong on server..");
                        session.setAttribute("failedMsg", "Something wrong on server..");
                        resp.sendRedirect("register.jsp");
                    }
                } else {
                    //System.out.println("Something wrong on server..");
                    session.setAttribute("failedMsg", "Password need set from 6 to 8 characters");
                    resp.sendRedirect("register.jsp");
                }
            } else {
                session.setAttribute("failedMsg", "Re-enter password must be similar password");
                resp.sendRedirect("register.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
