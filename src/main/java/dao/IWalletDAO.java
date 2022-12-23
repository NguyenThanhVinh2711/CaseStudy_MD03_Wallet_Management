package dao;

import model.Wallet;

import java.sql.SQLException;
import java.util.List;

public interface IWalletDAO {
    public void insertWallet(Wallet wallet) throws SQLException;
    public Wallet selectWallet(int idWallet);

    public List<Wallet> selectAllWallets(int user_id);

    public boolean deleteWallet(int idWallet) throws SQLException;

    public boolean updateWallet(Wallet wallet) throws SQLException;

    Wallet getWalletById(int idWallet);

    public List<Wallet> selectWalletsByName(String name);
    public List<Wallet> sortByName();
}
