package org.eitorresmendoza.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDataBase {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Monterrey";
    private static String username = "root";
    private static String password = "sasa";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
