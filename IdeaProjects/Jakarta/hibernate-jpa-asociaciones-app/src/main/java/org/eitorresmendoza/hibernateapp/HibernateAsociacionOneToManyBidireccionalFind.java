package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.entity.Factura;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionOneToManyBidireccionalFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1L);

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnología", 7000L);
            cliente.addFactura(f1).addFactura(f2);

//            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println("cliente = " + cliente);

            em.getTransaction().begin();
//            Factura f3 = em.find(Factura.class, 1L);
            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            cliente.removeFactura(f3);
            em.getTransaction().commit();

            System.out.println("cliente = " + cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
