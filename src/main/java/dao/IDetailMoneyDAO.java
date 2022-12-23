package dao;

import model.DetailMoney;

import java.sql.SQLException;
import java.util.List;

public interface IDetailMoneyDAO {
    void insertDetailMoneyIn(DetailMoney detailMoney) throws SQLException;

    public void insertDetailMoneyOut(DetailMoney detailMoney) throws SQLException;

    public DetailMoney selectDetailMoney(int id);

    DetailMoney selectDetailMoneyAdd(int id);

    DetailMoney selectDetailMoneySub(int id);

    public List<DetailMoney> selectAllDetailMoneysByUserId(int user_id);

    public boolean deleteDetailMoney(int id) throws SQLException;

//    public boolean updateDetailMoney(DetailMoney detailMoney) throws SQLException;

    boolean updateDetailMoneyAdd(DetailMoney detailMoney) throws SQLException;

    boolean updateDetailMoneySub(DetailMoney detailMoney) throws SQLException;

    List<DetailMoney> selectDetailMoneyByIdWallet(int user_id, int id_wallet);

    List<DetailMoney> selectDetailMoneyByIdUserAndToday(int user_id);

    List<DetailMoney> selectDetailMoneyByIdWalletAndToday(int user_id, int wallet_id);
}