package org.eitorresmendoza.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eitorresmendoza.cliente.jaxrs.models.Curso;
import org.eitorresmendoza.cliente.jaxrs.models.Instructor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs/api").path("/cursos");

        System.out.println("========= por id =========");
        Response response = rootUri.path("/2")
                .request(MediaType.APPLICATION_JSON)
                .get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);

        System.out.println("========= lista de cursos =========");
        listar(rootUri);

        System.out.println("========= crear curso =========");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Spring Cloud");
        cursoNuevo.setDescripcion("Spring Cloud eureka");
        cursoNuevo.setDuracion(25D);
        Instructor instructor = new Instructor();
        instructor.setId(2L);
        instructor.setNombre("sebas");
        instructor.setApellido("sebitas");
        cursoNuevo.setInstructor(instructor);

        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("========= editar curso =========");
        Curso cursoEditado = curso;
        cursoEditado.setNombre("microservicios con spring cloud eureka");
        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/" + curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader, Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("========= eliminar curso =========");
        rootUri.path("/" + curso.getId())
                .request()
                .delete();
        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        System.out.println("========= lista de cursos actualizada =========");

        Response response;
        response = rootUri.request(MediaType.APPLICATION_JSON)
               .get(Response.class);
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
    }
}