package controller.categoryservlet;

import dao.categoryDAO.CategoryDAO;
import model.Category;

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

@WebServlet(name = "CatalogServlet", urlPatterns = "/categorys")
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public CategoryDAO categoryDAO;

    public void init() {
        categoryDAO = new CategoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createCategory(request, response);
                    break;
                case "edit":
                    editCategory(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewCreate(request, response);
                    break;
                case "edit":
                    showEditCategory(request, response);
                    break;
                case "delete":
                    deleteCategory(request, response);
                    break;
                default:
                    displayCategory(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession httpSession = request.getSession();
        int user_id = (int) httpSession.getAttribute("idUser");
        List<Category> categoryList = categoryDAO.selectAllCategoryByIdUser(user_id);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/list.jsp");
        dispatcher.forward(request, response);
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idCategory = Integer.parseInt(request.getParameter("idCategory"));
            String name = request.getParameter("name");
            String note = request.getParameter("note");
            Category newCategory = new Category(idCategory, name, note);
            categoryDAO.editCategory(newCategory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/edit.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idCategory = Integer.parseInt(request.getParameter("idCategory"));
            Category showCategory = categoryDAO.getById(idCategory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/edit.jsp");
            request.setAttribute("showCategory", showCategory);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession httpSession = request.getSession();
            int user_id = (int) httpSession.getAttribute("idUser");
            int idCategory = Integer.parseInt(request.getParameter("idCategory"));
//            int userId = Integer.parseInt(request.getParameter("user_id"));
            categoryDAO.deleteCategory(idCategory);
            List<Category> categoryList = categoryDAO.selectAllCategoryByIdUser(user_id);
            request.setAttribute("categoryList", categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession httpSession=request.getSession();
            int user_id= (int) httpSession.getAttribute("idUser");

            String name = request.getParameter("name");
            String note = request.getParameter("note");

//            int user_id = Integer.parseInt(request.getParameter("user_id"));
            Category newCategory = new Category(name, note,user_id);
            categoryDAO.createCategory(newCategory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewcategory/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
