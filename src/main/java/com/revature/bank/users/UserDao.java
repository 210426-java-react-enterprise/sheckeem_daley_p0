package com.revature.bank.users;

import com.revature.bank.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private boolean correctLogin;
    private AppUser user;

    public AppUser findUser(String username, String password) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from p0.clients where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("client_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("ssn"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getString("sex"));
                user.setClientSince(rs.getString("client_since"));
                user.setClientActive(rs.getBoolean("client_active"));
            }
            correctLogin = true;
        } catch (SQLException e) {
            correctLogin = false;
            e.printStackTrace();
        }
        return user;
    }

    public boolean getCorrectLogin() {
        return correctLogin;
    }
}
