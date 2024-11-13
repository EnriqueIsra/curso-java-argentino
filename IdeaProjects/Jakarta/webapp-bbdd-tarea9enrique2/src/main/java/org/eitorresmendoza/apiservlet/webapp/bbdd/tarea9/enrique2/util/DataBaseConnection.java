package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() throws SQLException, NamingException {
        Context initContext = null;
        initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();
    }
}