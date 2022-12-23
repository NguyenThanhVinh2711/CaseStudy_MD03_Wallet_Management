package dao.categoryDAO;

import model.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> selectAllCategory(int idCategory);
    List<Category> selectAllCategoryByIdUser(int user_id);
    boolean editCategory(Category category);
    Category getById(int id);
    boolean deleteCategory(int id);
    void createCategory(Category category );
}

