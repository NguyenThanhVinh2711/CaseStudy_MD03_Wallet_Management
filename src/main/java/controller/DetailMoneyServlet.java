package controller;


import dao.DetailMoneyDAO;
import dao.WalletDAO;
import dao.categoryDAO.CategoryDAO;
import model.Category;
import model.DetailMoney;
import model.Wallet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "DetailMoneyServlet", urlPatterns = "/detailMoneys")
public class DetailMoneyServlet extends HttpServlet {
    public static List<DetailMoney> detailMoneyListSort = new ArrayList<>();
    private DetailMoneyDAO detailMoneyDAO;

    public CategoryDAO categoryDAO = new CategoryDAO();

    public WalletDAO walletDAO=new WalletDAO();


    public void init() {
        detailMoneyDAO = new DetailMoneyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createOut":
                    insertDetailMoneyOut(request, response);
                    break;
                case "createIn":
                    insertDetailMoneyIn(request, response);
                    break;
                case "editAdd":
                    updateDetailMoneyAdd(request, response);
                    break;
                case "editSub":
                    updateDetailMoneySub(request, response);
                    break;
                case "statisticRangeDate":
                    statisticRangeDate(request,response);
                    break;
                case "statisticToday":
                    statisticToday(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void statisticRangeDate(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession=request.getSession();
        int user_id=(int)httpSession.getAttribute("idUser");
        int wallet_id =Integer.parseInt(request.getParameter("id_wallet"));
        Date dateStart=Date.valueOf(request.getParameter("dateStart"));
        Date dateEnd=Date.valueOf(request.getParameter("dateEnd"));
        if(wallet_id==0){
            detailMoneyListSort=detailMoneyDAO.selectDetailMoneyByIdUserAndBetweenTwoDates(user_id,dateStart,dateEnd);
        }else{
            detailMoneyListSort=detailMoneyDAO.selectDetailMoneyByIdWalletAndBetweenTwoDates(user_id,wallet_id,dateStart,dateEnd);
        }
        request.setAttribute("listDetailMoney", detailMoneyListSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void statisticToday(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession=request.getSession();
        int user_id=(int)httpSession.getAttribute("idUser");
        int wallet_id =Integer.parseInt(request.getParameter("id_wallet"));
        if(wallet_id==0){
            detailMoneyListSort=detailMoneyDAO.selectDetailMoneyByIdUserAndToday(user_id);
        }else{
            detailMoneyListSort=detailMoneyDAO.selectDetailMoneyByIdWalletAndToday(user_id,wallet_id);
        }
        request.setAttribute("listDetailMoney", detailMoneyListSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createIn":
                    showNewFormIn(request, response);
                    break;
                case "createOut":
                    showNewFormOut(request, response);
                    break;
                case "editAdd":
                    showEditFormAdd(request, response);
                    break;
                case "editSub":
                    showEditFormSub(request, response);
                    break;
                case "delete":
                    deleteDetailMoney(request, response);
                    break;
                case "listDetailMoneyById_wallet":

                    listDetailMoneyByIdWallet(request,response);
                    break;
                case "sortByDate":
                    sortByDateIncrease(request,response);
                    break;
                case "reverseDate":
                    sortByDateDecrease(request,response);
                    break;
                case "statisticRangeDate":
                    showStatisticRangeDateForm(request,response);
                    break;
                case "statisticToday":
                    showStatisticTodayForm(request,response);
                    break;


                default:
                    listDetailMoney(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showStatisticRangeDateForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession=request.getSession();

        int user_id= (int) httpSession.getAttribute("idUser");
        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/statisticRangeDate.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showStatisticTodayForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession=request.getSession();

        int user_id= (int) httpSession.getAttribute("idUser");
        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/statisticToday.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByDateDecrease(HttpServletRequest request, HttpServletResponse response) {
        Collections.reverse(detailMoneyListSort);
        request.setAttribute("listDetailMoney", detailMoneyListSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByDateIncrease(HttpServletRequest request, HttpServletResponse response) {
        Collections.sort(detailMoneyListSort);
        request.setAttribute("listDetailMoney", detailMoneyListSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listDetailMoneyByIdWallet(HttpServletRequest request, HttpServletResponse response) {
        int id_wallet = Integer.parseInt(request.getParameter("idWallet"));
        HttpSession httpSession = request.getSession();
        int user_id = (int) httpSession.getAttribute("idUser");
        detailMoneyListSort = detailMoneyDAO.selectDetailMoneyByIdWallet(user_id, id_wallet);
        request.setAttribute("listDetailMoney", detailMoneyListSort);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {


        HttpSession httpSession=request.getSession();
        int user_id=(int)httpSession.getAttribute("idUser");

         detailMoneyListSort = detailMoneyDAO.selectAllDetailMoneysByUserId(user_id);

        request.setAttribute("listDetailMoney",detailMoneyListSort );

        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession httpSession=request.getSession();

        int user_id= (int) httpSession.getAttribute("idUser");
        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);

//        List<Category> categoryList=new ArrayList<>();
//        categoryList=categoryDAO.selectCategoryByIdUser(idUser);
//        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyIn.jsp");

        dispatcher.forward(request, response);
    }

    private void showNewFormOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();


        int user_id= (int) httpSession.getAttribute("idUser");
        List<Category> categoryList=new ArrayList<>();
        categoryList=categoryDAO.selectAllCategoryByIdUser(user_id);
        request.setAttribute("categoryList",categoryList);


        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);


        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyOut.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormAdd(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession httpSession=request.getSession();


        int user_id= (int) httpSession.getAttribute("idUser");
        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);
            int id = Integer.parseInt(request.getParameter("id"));
            DetailMoney existingDetailMoney = detailMoneyDAO.selectDetailMoneyAdd(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/editAdd.jsp");
            request.setAttribute("detailMoney", existingDetailMoney);

        dispatcher.forward(request, response);

    }

    private void showEditFormSub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {


        HttpSession httpSession=request.getSession();

        int user_id= (int) httpSession.getAttribute("idUser");

        List<Wallet> walletList=new ArrayList<>();
        walletList=walletDAO.selectAllWalletByIdUser(user_id);
        request.setAttribute("walletList",walletList);
        List<Category> categoryList=new ArrayList<>();
        CategoryDAO categoryDAO=new CategoryDAO();
        categoryList=categoryDAO.selectAllCategoryByIdUser(user_id);
        request.setAttribute("categoryList",categoryList);

            int id = Integer.parseInt(request.getParameter("id"));
            DetailMoney existingDetailMoney = detailMoneyDAO.selectDetailMoneySub(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/editSub.jsp");
            request.setAttribute("detailMoney", existingDetailMoney);

        dispatcher.forward(request, response);

    }

    private void insertDetailMoneyIn(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        int idDetail =Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
        double money = Double.parseDouble((request.getParameter("money")));
//        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note = request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(id_wallet, money, note, date);
        detailMoneyDAO.insertDetailMoneyIn(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyIn.jsp");
        dispatcher.forward(request, response);
    }

    private void insertDetailMoneyOut(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        int idDetail =Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
        double money = -Double.parseDouble((request.getParameter("money")));
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        String note = request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(id_wallet, money, id_category, note, date);
        detailMoneyDAO.insertDetailMoneyOut(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyOut.jsp");
        dispatcher.forward(request, response);
    }

    private void updateDetailMoneySub(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idDetail = Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
        double money = -Double.parseDouble((request.getParameter("money")));
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        String note = request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(idDetail, id_wallet, money, id_category, note, date);

        detailMoneyDAO.updateDetailMoneySub(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/editSub.jsp");
        dispatcher.forward(request, response);
    }

    private void updateDetailMoneyAdd(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idDetail = Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
        double money = Double.parseDouble((request.getParameter("money")));
//        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note = request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(idDetail, id_wallet, money, note, date);

        detailMoneyDAO.updateDetailMoneyAdd(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/editAdd.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        detailMoneyDAO.deleteDetailMoney(id);
        HttpSession httpSession = request.getSession();
        int user_id = (int) httpSession.getAttribute("idUser");
        List<DetailMoney> listDetailMoney = detailMoneyDAO.selectAllDetailMoneysByUserId(user_id);
        request.setAttribute("listDetailMoney", listDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        dispatcher.forward(request, response);
    }
} 

