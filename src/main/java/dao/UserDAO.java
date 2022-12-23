package dao;

import model.Users;

import java.sql.SQLException;

public interface UserDAO {
    public boolean registerUser(Users user) throws SQLException, ClassNotFoundException;
    public Users checkLogin(String email, String password)throws SQLException,ClassNotFoundException;
}
