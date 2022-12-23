package controller;

import connectionDB.ConnectionDB;
import dao.UserDAOImpl;
import dao.detailmoneywalletuser.DetailMoneyWalletUserDAO;
import model.DetailMoneyWalletUser;
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
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    DetailMoneyWalletUserDAO detailMoneyWalletUserDAO=new DetailMoneyWalletUserDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        Users us= (Users) session.getAttribute("userobj");



            List<DetailMoneyWalletUser> detailMoneyWalletUsers= detailMoneyWalletUserDAO.selectDetailMoneyWallet(us.getId());
            double sum = 0;
            for (DetailMoneyWalletUser dt: detailMoneyWalletUsers
            ) {
                sum += dt.getFinalMoney();
            }
            req.setAttribute("sum",sum) ;
            req.setAttribute("detailMWUList",detailMoneyWalletUsers);
            RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req,resp);
//                resp.sendRedirect("home.jsp");


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            UserDAOImpl dao=new UserDAOImpl(ConnectionDB.getConnection());
            HttpSession session=req.getSession();
            String userName =req.getParameter("userName");
            String password = req.getParameter("password");
            Users us=dao.checkLogin(userName,password);
            if (us!=null){
                session.setAttribute("idUser",us.getId());

                session.setAttribute("userobj",us);
                List<DetailMoneyWalletUser> detailMoneyWalletUsers= detailMoneyWalletUserDAO.selectDetailMoneyWallet(us.getId());
                double sum = 0;
                for (DetailMoneyWalletUser dt: detailMoneyWalletUsers
                     ) {
                    sum += dt.getFinalMoney();
                }
                req.setAttribute("sum",sum) ;
                req.setAttribute("detailMWUList",detailMoneyWalletUsers);
                RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
                dispatcher.forward(req,resp);
//                resp.sendRedirect("home.jsp");

            }else {
                session.setAttribute("failedMsg","userName &Password Invalid");
                resp.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
