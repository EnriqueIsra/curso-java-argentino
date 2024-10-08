package org.eitorresmendoza.apiservlet.webapp.bbdd.tarea9.enrique2.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
public class ProducerResources {

    @Inject
    private Logger log;

    @Resource(name = "jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
    private Connection beanConnection() throws SQLException{
        return ds.getConnection();
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    public void close(@Disposes Connection connection) throws SQLException {
        connection.close();
        log.info("cerrando la conexión a la base de datos mysql.");
    }

}
