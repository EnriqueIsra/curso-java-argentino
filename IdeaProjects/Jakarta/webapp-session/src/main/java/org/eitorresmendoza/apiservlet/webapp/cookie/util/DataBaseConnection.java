package org.eitorresmendoza.apiservlet.webapp.cookie.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Monterrey";
    private static String username = "root";
    private static String password = "sasa";

    public static Connection getConexion() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }
}
