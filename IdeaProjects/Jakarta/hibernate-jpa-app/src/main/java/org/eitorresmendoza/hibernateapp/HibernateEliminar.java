package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.entity.Cliente;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id del cliente a eliminar: ");
        Long id = scanner.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente c = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
