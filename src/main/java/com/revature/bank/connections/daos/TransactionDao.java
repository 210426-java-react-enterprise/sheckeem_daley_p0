package com.revature.bank.connections.daos;

import com.revature.bank.entities.Accounts;
import com.revature.bank.entities.Transactions;
import com.revature.bank.entities.AppUser;
import com.revature.bank.connections.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;

public class TransactionDao {
    private static TransactionDao transDao;
    private Transactions transaction = null;

    public Transactions find(Accounts account) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from p0.transactions where fk_account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account.getId());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transaction = new Transactions();
                transaction.setId(rs.getInt("trans_id"));
                transaction.setAccountId(rs.getInt("fk_account_id"));
                transaction.setTypeId(rs.getInt("fk_trans_type_id"));
                transaction.setAmount((double) rs.getFloat("amount"));
                transaction.setDate(rs.getDate("trans_date"));
                transaction.setNotFlagged(rs.getBoolean("flagged_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public AppUser make(AppUser user) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "insert into p0.transactions (fk_account_id, fk_trans_type_id, " +
                    "amount, trans_date, flagged_status) " +
                    "values ( ?, ?, ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, transaction.getAccountId());
            pstmt.setInt(2, transaction.getTypeId());
            pstmt.setFloat(3, (float) transaction.getAmount());
            pstmt.setDate(4, (Date) transaction.getDate());
            pstmt.setBoolean(5, transaction.isNotFlagged());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public static TransactionDao getInstance() {
        if (transDao == null) transDao = new TransactionDao();
        return transDao;
    }
}