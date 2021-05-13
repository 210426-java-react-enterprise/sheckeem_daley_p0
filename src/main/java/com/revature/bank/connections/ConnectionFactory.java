package com.revature.bank.connections;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// @Author Wezley Singleton (mostly)

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory;
    private Properties props = new Properties();

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionFactory() {
        try {
            URL url = Paths.get("src/main/resources/application.properties").toUri().toURL();
            props.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //singleton = public static field and method while public class
    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }

        return connectionFactory;
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                    props.getProperty("host-url"),
                    props.getProperty("username"),
                    props.getProperty("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}