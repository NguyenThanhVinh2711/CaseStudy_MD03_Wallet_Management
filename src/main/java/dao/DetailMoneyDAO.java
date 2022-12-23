package dao;

import connectionDB.ConnectionDB;
import model.DetailMoney;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailMoneyDAO implements IDetailMoneyDAO{
    public  DetailMoneyDAO(){}
    protected Connection getConnection(){
        Connection connection=ConnectionDB.getConnection();
        return connection;
    }
    @Override
    public void insertDetailMoneyIn(DetailMoney detailMoney) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into detailMoney(id_wallet,money,note,date) values (?,?,?,?)");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
//        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(3,detailMoney.getNote());
        preparedStatement.setDate(4,detailMoney.getDate());
        preparedStatement.executeUpdate();
    }
public void insertDetailMoneyOut(DetailMoney detailMoney) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into detailMoney(id_wallet,money,id_category,note,date) values (?,?,?,?,?)");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(4,detailMoney.getNote());
        preparedStatement.setDate(5,detailMoney.getDate());
        preparedStatement.executeUpdate();
    }

    @Override
    public DetailMoney selectDetailMoney(int id) {
        DetailMoney detailMoney=null;
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select  * from detailMoney where idDetail=?");
            preparedStatement.setInt(1,id);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){

                int id_wallet=rs.getInt("id_wallet");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                 detailMoney=new DetailMoney(id,id_wallet,money,id_category,note,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailMoney;
    }
    @Override
    public DetailMoney selectDetailMoneyAdd(int id) {
        DetailMoney detailMoney=null;
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select  * from detailMoney where idDetail=?");
            preparedStatement.setInt(1,id);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){

                int id_wallet=rs.getInt("id_wallet");
                double money=rs.getDouble("money");
//                int id_category=rs.getInt("id_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                 detailMoney=new DetailMoney(id,id_wallet,money,note,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailMoney;
    }
    @Override
    public DetailMoney selectDetailMoneySub(int id) {
        DetailMoney detailMoney=null;
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select  * from detailMoney where idDetail=?");
            preparedStatement.setInt(1,id);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){

                int id_wallet=rs.getInt("id_wallet");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                 detailMoney=new DetailMoney(id,id_wallet,money,id_category,note,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailMoney;
    }

    @Override
    public List<DetailMoney> selectDetailMoneyByIdWallet(int user_id, int id_wallet) {
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from detailMoney_wallet_category where user_id=? and id_wallet=?");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,id_wallet);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
//                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }

    @Override
    public List<DetailMoney> selectAllDetailMoneysByUserId(int user_id) {
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from detailMoney_wallet_category where user_id=?");
            preparedStatement.setInt(1,user_id);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;

    }

    @Override
    public boolean deleteDetailMoney(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete  from detailMoney where idDetail=?");
        preparedStatement.setInt(1,id);
        rowDeleted=preparedStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateDetailMoneyAdd(DetailMoney detailMoney) throws SQLException {
        boolean rowUpdated;
        Connection connection=getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("update detailMoney set " +
                "id_wallet=?,money=?,note=?,date=? where idDetail=?");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
        preparedStatement.setString(3,detailMoney.getNote());
        preparedStatement.setDate(4,detailMoney.getDate());
        preparedStatement.setInt(5,detailMoney.getIdDetail());
        rowUpdated=preparedStatement.executeUpdate()>0;
        return rowUpdated;
    }
    @Override
    public boolean updateDetailMoneySub(DetailMoney detailMoney) throws SQLException {
        boolean rowUpdated;
        Connection connection=getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("update detailMoney set " +
                "id_wallet=?,money=?,id_category=?,note=?,date=? where idDetail=?");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(4,detailMoney.getNote());
        preparedStatement.setDate(5,detailMoney.getDate());
        preparedStatement.setInt(6,detailMoney.getIdDetail());
        rowUpdated=preparedStatement.executeUpdate()>0;
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<DetailMoney> selectDetailMoneyByIdUserAndBetweenTwoDates(int user_id, Date dateStart, Date dateEnd) {
        Connection connection=getConnection();
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from detailMoney_wallet_category where user_id=? and (date between ? and ?)");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setDate(2,dateStart);
            preparedStatement.setDate(3,dateEnd);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }
    public List<DetailMoney> selectDetailMoneyByIdUserAndToday(int user_id) {
        Connection connection=getConnection();
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from detailMoney_wallet_category where user_id=? and date=curdate()");
            preparedStatement.setInt(1,user_id);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }

    @Override
    public List<DetailMoney> selectDetailMoneyByIdWalletAndToday(int user_id,int wallet_id) {
        Connection connection=getConnection();
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from detailMoney_wallet_category where id_wallet=? and date=curdate()");
            preparedStatement.setInt(1,wallet_id);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }

    public List<DetailMoney> selectDetailMoneyByIdWalletAndBetweenTwoDates(int user_id,int wallet_id, Date dateStart, Date dateEnd) {
        Connection connection=getConnection();
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from detailMoney_wallet_category where id_wallet=? and (date between ? and ?)");
            preparedStatement.setInt(1,wallet_id);
            preparedStatement.setDate(2,dateStart);
            preparedStatement.setDate(3,dateEnd);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                String name_wallet=rs.getString("name_wallet");
//                int user_id=rs.getInt("user_id");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,name_wallet,user_id,money,id_category,name_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }
}
