package dao;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    private Connection conn;
    public UserDAOImpl(Connection conn){
        super();
        this.conn=conn;
    }

    @Override
    public boolean registerUser(Users user) throws SQLException, ClassNotFoundException {
        boolean f= false;
        try {
            String sql= "insert into users(userName,password) values(?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            int i= ps.executeUpdate();
            if(i==1){
                f=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public Users checkLogin(String userName, String password) throws SQLException, ClassNotFoundException {
Users users=null;
try {
    String sql="select*from users where userName=? and password=?";
    PreparedStatement ps=conn.prepareStatement(sql);
    ps.setString(1,userName);
    ps.setString(2,password);
    ResultSet rs= ps.executeQuery();
    while (rs.next()){

        users=new Users();
users.setId(rs.getInt(1));
        users.setUserName(rs.getString(2));
        users.setPassword(rs.getString(3));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
        return users;
    }
}
