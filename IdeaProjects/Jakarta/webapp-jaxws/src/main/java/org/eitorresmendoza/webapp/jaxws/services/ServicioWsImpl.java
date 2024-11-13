package org.eitorresmendoza.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.eitorresmendoza.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.eitorresmendoza.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {
    private int contador;
    @Override
    public String saludar(String persona) {
        System.out.println("instancia del servicio web: " + this);
        contador ++;
        System.out.println("Valor del contador en metodo saludar: " + contador);
        return "Hola que tal " + persona + " bienvenido.";
    }

    @WebMethod
    @Override
    public List<Curso> listar() {
        return Arrays.asList(new Curso("Java"), new Curso("Spring"), new Curso("Jakarta ee"));
    }

    @WebMethod
    @Override
    public Curso crear(Curso curso) {
        System.out.println("nuevo curso creado con exito: " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
