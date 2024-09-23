package org.eitorresmendoza.apiservlet.webapp.cookie.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.eitorresmendoza.apiservlet.webapp.cookie.configs.MysqlConn;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.ServiceJdcbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {
    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }
        try {
            log.info(" ----------> iniciando transaccion: " + invocation.getMethod().getName() +
                    ", de la clase: " + invocation.getMethod().getDeclaringClass());
            Object resultado = invocation.proceed();
            conn.commit();
            log.info(" ----------> realizando commit y finalizando transaccion: " + invocation.getMethod().getName() +
                    ", de la clase: " + invocation.getMethod().getDeclaringClass());
            return resultado;
        } catch (ServiceJdcbException e) {
            conn.rollback();
            throw e;
        }
    }
}
