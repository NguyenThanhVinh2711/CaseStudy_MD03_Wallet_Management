package dao.detailmoneywalletuser;

import model.DetailMoneyWalletUser;

import java.util.List;

public interface IDetailMoneyWalletUserDAO {
    List<DetailMoneyWalletUser> selectDetailMoneyWallet (int idUser);
}
