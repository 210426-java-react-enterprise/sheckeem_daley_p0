package com.revature.bank;

import com.revature.bank.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppUser {
    private int id;
    private String username;
    private String password; //No getter for password is intentional
    private String email;
    private String firstName;
    private String lastName;

    public AppUser() {}

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    // returns full name rather than individual getters
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    //might not be necessary since id should be serial
    public void setId (int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // No getter for Password is intentional
    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private class UserDao extends AppUser {
        public AppUser findUser(String username, String password) {
            AppUser user = new AppUser();

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                String sql = "select * from p0.clients where username = ? and password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }
    }
}