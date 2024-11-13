package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernateResultListWhere {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where formaPago=?1");
        System.out.println("Ingrese una forma de pago: ");
        String pago = scanner.next();
        query.setParameter(1, pago);
//        query.setMaxResults(1);
        List<Cliente> clientes = query.getResultList();
        System.out.println(clientes);
        em.close();
    }
}