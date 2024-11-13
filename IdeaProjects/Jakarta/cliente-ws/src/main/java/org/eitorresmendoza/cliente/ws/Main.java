package org.eitorresmendoza.cliente.ws;

import org.eitorresmendoza.webapp.jaxws.services.Curso;
import org.eitorresmendoza.webapp.jaxws.services.ServicioWs;
import org.eitorresmendoza.webapp.jaxws.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        ServicioWs service = new ServicioWsImplService().getServicioWsImplPort();
        System.out.println("el saludo: " + service.saludar("Enrique"));

        Curso curso = new Curso();
        curso.setNombre("Angular");
        Curso respuesta = service.crear(curso);
        System.out.println("nuevo curso: " + curso.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
