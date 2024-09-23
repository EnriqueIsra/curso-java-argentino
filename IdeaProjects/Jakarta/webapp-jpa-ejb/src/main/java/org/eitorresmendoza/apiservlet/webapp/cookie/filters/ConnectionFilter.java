package org.eitorresmendoza.apiservlet.webapp.cookie.filters;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.MysqlConn;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.ServiceJdcbException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
    /*
        @Inject
        @MysqlConn
        @Named("conn")
        private Connection conn;
    */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*        try (Connection conn = DataBaseConnectionDS.getConexion()) {
        try  {
            Connection connRequest = this.conn;

            if (connRequest.getAutoCommit()) {
                connRequest.setAutoCommit(false);
            }*/
        try {
//                request.setAttribute("conn", connRequest);
            chain.doFilter(request, response);
//                connRequest.commit();
        } catch (ServiceJdcbException e) {
//                connRequest.rollback();
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage());
            e.printStackTrace();
        }
/*        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
