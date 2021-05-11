package com.revature.bank.users;

import com.revature.bank.utils.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;

public class UserDao {
    private static UserDao userDao;
    private boolean correctLogin;
    private AppUser user = null;

    public AppUser findUser(String username, String password) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from p0.clients where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new AppUser();
                user.setId(rs.getInt("client_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("ssn"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getString("sex"));
                user.setClientSince(rs.getDate("client_since"));
                user.setClientActive(rs.getBoolean("client_active"));
            }
            correctLogin = true;
        } catch (SQLException e) {
            correctLogin = false;
            e.printStackTrace();
        }
        return user;
    }

    public AppUser register(AppUser user) {
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

    public boolean getCorrectLogin() {
        return correctLogin;
    }

    public static UserDao getInstance() {
        if (userDao == null) userDao = new UserDao();
        return userDao;
    }

    public void clearCredentials() {
        user = null;
        correctLogin = false;
        userDao = null;
    }
}