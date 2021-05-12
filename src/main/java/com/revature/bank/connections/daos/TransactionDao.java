package com.revature.bank.connections.daos;

import com.revature.bank.entities.Transactions;
import com.revature.bank.entities.AppUser;
import com.revature.bank.connections.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;

public class TransactionDao {
    private Transactions transaction = null;

    public Transactions find(AppUser user) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from p0.accounts where fk_account_id = ?" +
                    "";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transaction = new Transactions();
                transaction.setId(rs.getInt("trans_id"));
                transaction.setAccountId(rs.getInt("fk_account_id"));
                transaction.setTypeId(rs.getInt("fk_trans_type_id"));
                transaction.setAmount(rs.getFloat("amount"));
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
            String sql = "insert into p0.clients (username, password, ssn, " +
                    "first_name, last_name, email, phone, sex, client_since, client_active) " +
                    "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getSsn());
            pstmt.setString(4, user.getFirstName());
            pstmt.setString(5, user.getLastName());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getPhone());
            pstmt.setString(8, user.getSex());
            pstmt.setDate(9, Date.valueOf(LocalDate.now()));
            pstmt.setBoolean(10, user.isClientActive());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}