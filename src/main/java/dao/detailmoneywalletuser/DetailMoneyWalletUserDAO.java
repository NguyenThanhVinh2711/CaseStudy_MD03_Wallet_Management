package dao.detailmoneywalletuser;

import model.DetailMoneyWalletUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static connectionDB.ConnectionDB.getConnection;

public class DetailMoneyWalletUserDAO implements IDetailMoneyWalletUserDAO {




    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<DetailMoneyWalletUser> selectDetailMoneyWallet(int idUser) {
        List<DetailMoneyWalletUser> listDetailWalletUser = new ArrayList<>();
        try{
            String query = "select * from detailmoney_wallet_users2 where idUser = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idUser);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                int idUser = resultSet.getInt("idUser");
                int idWallet = resultSet.getInt("idWallet");
                String icon = resultSet.getString("icon");
                String name = resultSet.getString("name");
                double finalMoney = resultSet.getDouble("finalMoney");
                double sumMoney = resultSet.getDouble("sumMoney");
                listDetailWalletUser.add(new DetailMoneyWalletUser(idWallet,icon,name,finalMoney,sumMoney));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDetailWalletUser;
    }
}
