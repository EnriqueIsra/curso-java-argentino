package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.services.ClienteService;
import org.eitorresmendoza.hibernateapp.services.ClienteServiceImpl;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("============== Listar ==============");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("============== Obtener por id ==============");
        Optional<Cliente> optionalCliente = service.porId(1L);
        optionalCliente.ifPresent(System.out::println);

        System.out.println("============== Insertar nuevo cliente ==============");
        Cliente cliente = new Cliente();
        cliente.setNombre("Ale");
        cliente.setApellido("Sanchez");
        cliente.setFormaPago("paypal");

        System.out.println("cliente guardado con el id: " + cliente.getId());
        service.guardar(cliente);
        service.listar().forEach(System.out::println);

        System.out.println("============== Editar cliente ==============");
        Long id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            System.out.println("cliente editado con el id: " + cliente.getId());
            service.guardar(c);

            service.listar().forEach(System.out::println);
        });

        System.out.println("============== Eliminar cliente ==============");
        id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            System.out.println("cliente eliminado con el id: " + cliente.getId());
            service.eliminar(c.getId());
            service.listar().forEach(System.out::println);
        });

//        if (optionalCliente.isPresent()){
//            service.eliminar(id);
//        }

        em.close();
    }
}
