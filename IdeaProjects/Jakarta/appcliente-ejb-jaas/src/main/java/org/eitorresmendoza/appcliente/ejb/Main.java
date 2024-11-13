package org.eitorresmendoza.appcliente.ejb;

import org.eitorresmendoza.webapp.ejb.models.Producto;
import org.eitorresmendoza.webapp.ejb.services.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {

        ServiceEjbRemote service = null;
        ServiceEjbRemote service2 = null;

//        final Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        env.put("jboss.naming.client.ejb.context", true);
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-jaas/ServiceEjb!org.eitorresmendoza.webapp.ejb.services.ServiceEjbRemote?stateful");
            service2 = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-jaas/ServiceEjb!org.eitorresmendoza.webapp.ejb.services.ServiceEjbRemote?stateful");


            String saludo = service.saludar("Enrique");
            String saludo2 = service2.saludar("Andres");
            System.out.println("saludo = " + saludo);
            System.out.println("saludo2 = " + saludo2);
            service.listar().forEach(System.out::println);

            Producto np = service.crear(new Producto("sandia"));
            System.out.println("nuevo producto = " + np);
            service.listar().forEach(System.out::println);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}