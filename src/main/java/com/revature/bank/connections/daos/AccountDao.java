package com.revature.bank.connections.daos;

import com.revature.bank.connections.ConnectionFactory;
import com.revature.bank.entities.Accounts;
import com.revature.bank.entities.AppUser;

import java.sql.*;

public class AccountDao {
    private static AccountDao accountDao = null;
    private Accounts account = null;

    public Accounts findAcountFromDb(AppUser user) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from p0.accounts where fk_client_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                account = new Accounts();
                account.setId(rs.getInt("account_id"));
                account.setCurrentBalance((double) rs.getFloat("balance"));
                account.setType(rs.getInt("account_type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Accounts createAccount(AppUser user) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "insert into p0.account (fk_client_id, fk_account_type_id, " +
                    "balance, account_active, client_locked, admin_locked) " +
                    "values ( ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, account.getType());
            pstmt.setFloat(3, (float) account.getCurrentBalance());
            pstmt.setBoolean(4,true);
            pstmt.setBoolean(5, false);
            pstmt.setBoolean(5, false);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static AccountDao getInstance() {
        if (accountDao == null) accountDao = new AccountDao();
        return accountDao;
    }
}
