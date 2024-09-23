package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.dominio.ClienteDto;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class HibernateQL {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("=========== consultar todos ===========");
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== consultar por id ===========");
        Cliente cliente = em.createQuery("select c from Cliente c where c.id=:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("=========== consultar solo el nombre por el id ===========");
        String nombreCliente = em.createQuery("select c.nombre from Cliente c where c.id=:id", String.class)
                .setParameter("id", 2L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("=========== consulta por campos personalizados ===========");
        Object[] objetoCliente = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id=:id", Object[].class)
                .setParameter("id", 1L)
                .getSingleResult();
        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("id: " + id + ", nombre: " + nombre + ", apellido: " + apellido);

        System.out.println("=========== consulta por campos personalizados lista===========");
        List<Object[]> registros = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c", Object[].class)
                .getResultList();
//        for (Object[] reg : registros) {
        registros.forEach(reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println("id: " + idCli + ", nombre: " + nombreCli + ", apellido: " + apellidoCli);
        });

        System.out.println("=========== consulta por cliente y forma de pago ===========");
        registros = em.createQuery("select c, c.formaPago from Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];
            System.out.println("formaPago = " + formaPago + ", " + c);
        });

        System.out.println("=========== consulta personalizada que puebla y devuelve objeto entity de una clase ===========");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== consulta personalizada que puebla y devuelve objeto dto de una clase ===========");
        List<ClienteDto> clientesDto = em.createQuery("select new org.eitorresmendoza.hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) from Cliente c", ClienteDto.class)
                .getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("=========== consulta nombres de clientes ===========");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta nombres de clientes únicos ===========");
        nombres = em.createQuery("select distinct(c.nombre) from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta formas de pago únicas ===========");
        List<String> formasPago = em.createQuery("select distinct(c.formaPago) from Cliente c", String.class)
                .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("=========== consulta cantidad de formas de pago únicas ===========");
        Long cantidadFormasPago = em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class)
                .getSingleResult();
        System.out.println(cantidadFormasPago);

        System.out.println("=========== consulta nombre y apellido concatenados ===========");
        /*nombres = em.createQuery("select concat(c.nombre, ' ', c.apellido) as nombreCompleto from Cliente c", String.class)
                        .getResultList();*/
        nombres = em.createQuery("select c.nombre || ' ' || c.apellido as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta nombre y apellido concatenados en mayúsculas ===========");
        nombres = em.createQuery("select upper(concat(c.nombre, ' ', c.apellido)) as nombreCompleto from Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== consulta para buscar por nombre ===========");
        String param = "TI";
        clientes = em.createQuery("select c from Cliente c where upper(c.nombre) like upper(:parametro)", Cliente.class)
                .setParameter("parametro", "%" + param + "%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== consulta por rangos ===========");
//        clientes = em.createQuery("select c from Cliente c where c.id between 2 and 5", Cliente.class).getResultList();
        clientes = em.createQuery("select c from Cliente c where c.nombre between 'A' and 'T'", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== consulta con orden ===========");
        clientes = em.createQuery("select c from Cliente c order by c.nombre asc, c.apellido asc", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== consulta del total de registros ===========");
        Long total = em.createQuery("select count(c) as total from Cliente c", Long.class).getSingleResult();
        System.out.println(total);

        System.out.println("=========== consulta del valor mínimo del id ===========");
        Long minId = em.createQuery("select min(c.id) as minimo from Cliente c", Long.class).getSingleResult();
        System.out.println(minId);

        System.out.println("=========== consulta del valor máximo del id ===========");
        Long maxId = em.createQuery("select max(c.id) as maximo from Cliente c", Long.class).getSingleResult();
        System.out.println(maxId);

        System.out.println("=========== consulta de nombre y su largo ===========");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class).getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo: " + largo);
        });
        System.out.println("=========== consulta el nombre mas corto ===========");
        Integer minLargoNombre = em.createQuery("select min(length(c.nombre)) from Cliente c", Integer.class).getSingleResult();
        System.out.println(minLargoNombre);

        System.out.println("=========== consulta el nombre mas largo ===========");
        Integer maxLargoNombre = em.createQuery("select max(length(c.nombre)) from Cliente c", Integer.class).getSingleResult();
        System.out.println(maxLargoNombre);

        System.out.println("=========== consultas resumen funciones agregaciones count min max avg sum ===========");
        Object[] estadisticas = em.createQuery("select min(c.id), max(c.id), sum(c.id), count(c.id), avg(length(c.nombre)) from Cliente c", Object[].class)
                .getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min: " + min + ", max: " + max + ", sum: " + sum + ", count: " + count + ", avg: " + avg);

        System.out.println("=========== consulta el nombre mas corto y su valor ===========");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c where length(c.nombre) = " +
                        "(select min(length(c.nombre)) from Cliente c)", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo: " + largo);
        });

        System.out.println("=========== consulta para obtener el ultimo registro ===========");
        Cliente ultimoCliente = em.createQuery("select c from Cliente c where c.id = " +
                "(select max(c.id) from Cliente c)", Cliente.class).getSingleResult();
        System.out.println("ultimoCliente = " + ultimoCliente);

        System.out.println("=========== consulta where in ===========");
        clientes = em.createQuery("select c from Cliente c where c.id in :ids", Cliente.class)
                .setParameter("ids", Arrays.asList(1L, 4L, 9L, 5L))
                .getResultList();
        clientes.forEach(System.out::println);

        em.close();
    }
}
