package dao;

import connectionDB.ConnectionDB;
import model.Wallet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO implements IWalletDAO {

    private static final String INSERT_WALLET_SQL = "INSERT INTO WALLET (user_id, icon, Name, Description) VALUES (?,?,?,?);";
    private static final String SELECT_Wallet_BY_ID = "select IdWallet,user_id,icon, Name, Description from WALLET where IdWallet =?";
    private static final String SELECT_ALL_WALLET = "select * from WALLET where user_id = ?";
    private static final String DELETE_WALLET_SQL = "delete from WALLET where IdWallet = ?;";
    private static final String UPDATE_WALLET_SQL = "update WALLET set user_id= ?, icon = ?,name= ?, description =? where IdWallet = ?;";


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


    @Override
    public void insertWallet(Wallet wallet) throws SQLException {

        System.out.println(INSERT_WALLET_SQL);

        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WALLET_SQL)) {

            preparedStatement.setInt(1, wallet.getIdUser());

            preparedStatement.setString(2, wallet.getIcon());

            preparedStatement.setString(3, wallet.getNameWallet());

            preparedStatement.setString(4, wallet.getDescription());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);

        }

    }

    @Override
    public Wallet selectWallet(int idWallet) {
        Wallet wallet = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Wallet_BY_ID);) {
            preparedStatement.setInt(1, idWallet);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name = rs.getString("name");
                String description = rs.getString("description");
                wallet = new Wallet(idWallet, idUser, icon, name, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return wallet;

    }


    @Override
    public List<Wallet> selectAllWallets(int user_id) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Wallet> wallets = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WALLET);) {
            preparedStatement.setInt(1,user_id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idWallet = rs.getInt("idWallet");
                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name = rs.getString("name");
                String description = rs.getString("description");
                wallets.add(new Wallet(idWallet, idUser, icon, name, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return wallets;
    }

    @Override
    public boolean deleteWallet(int idWallet) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_WALLET_SQL);) {
            statement.setInt(1, idWallet);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    protected Connection getConnection(){
        Connection connection= ConnectionDB.getConnection();
        return connection;
    }
    @Override
    public boolean updateWallet(Wallet wallet) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_WALLET_SQL);) {
            statement.setInt(1, wallet.getIdUser());
            statement.setString(2, wallet.getIcon());
            statement.setString(3, wallet.getNameWallet());
            statement.setString(4, wallet.getDescription());
            statement.setInt(5, wallet.getIdWallet());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Wallet getWalletById(int idWallet) {
        Wallet wallet = null;

        String query = "{CALL get_wallet_by_id(?)}";

        // Step 1: Establishing a Connection

        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, idWallet);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {
                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name = rs.getString("name");
                String description = rs.getString("description");

                wallet = new Wallet(idWallet, idUser, icon, name, description);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return wallet;


    }

    @Override
    public List<Wallet> selectWalletsByName(String name) {
        List<Wallet> wallets = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Wallet where name like ?")) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name1 = rs.getString("name");
                String description = rs.getString("description");
                wallets.add(new Wallet(id, idUser, icon, name1, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return wallets;
    }

    @Override
    public List<Wallet> sortByName() {
        List<Wallet> wallets = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Wallet order by name")) {

            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("idWallet");
                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name = rs.getString("name");
                String description = rs.getString("description");

                wallets.add(new Wallet(id, idUser, icon, name, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return wallets;

    }

//    public boolean updateUser(Wallet wallet) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_WALLET_SQL);) {
//            statement.setInt(1, wallet.getIdUser());
//            statement.setString(2, wallet.getIcon());
//            statement.setString(3, wallet.getNameWallet());
//            statement.setString(4, wallet.getDescription());
//            statement.setInt(5, wallet.getIdWallet());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }

    public List<Wallet> selectUsersByName(String name, int user_id) {
        List<Wallet> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Wallet where name like ? and user_id=?")) {
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setInt(2,user_id);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("idWallet");
                int idUser = rs.getInt("user_id");
                String icon = rs.getString("icon");
                String name1 = rs.getString("name");
                String description = rs.getString("description");
                users.add(new Wallet(id, idUser, icon, name, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public List<Wallet> selectAllWalletByIdUser(int user_id) {
        List<Wallet> walletList =new ArrayList<>();
        try {
            String query = "select idWallet, name from wallet where user_id=?";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idWallet = resultSet.getInt("idWallet");
                String name = resultSet.getString("name");
//                String note = resultSet.getString("note");
//                int user_id = resultSet.getInt("user_id");
                walletList.add(new Wallet(idWallet,name));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return walletList;
    }
}
