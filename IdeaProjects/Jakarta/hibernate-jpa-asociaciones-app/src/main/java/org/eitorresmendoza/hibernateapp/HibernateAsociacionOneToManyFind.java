package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.entity.Direccion;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionOneToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {

            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 2L);
            Direccion d1 = new Direccion("el vergel", 123);
            Direccion d2 = new Direccion("vasco de gama", 456);
            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println("cliente = " + cliente);

            em.getTransaction().begin();
            d1 = em.find(Direccion.class, 1L);
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println("cliente = " + cliente);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }
    }
}
