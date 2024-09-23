package org.eitorresmendoza.hibernateapp;

import jakarta.persistence.EntityManager;
import org.eitorresmendoza.hibernateapp.entity.Alumno;
import org.eitorresmendoza.hibernateapp.entity.Curso;
import org.eitorresmendoza.hibernateapp.util.JpaUtil;

public class HibernateAsociacionManyToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Alumno alumno1 = em.find(Alumno.class, 1L);
            Alumno alumno2 = em.find(Alumno.class, 2L);

            Curso curso1 = em.find(Curso.class, 1L); // new Curso("Curso Java", "Andres");
            Curso curso2 = em.find(Curso.class, 2L); // new Curso("Curso Hibernate y Jpa", "Andres");

            alumno1.getCursos().add(curso1);
            alumno1.getCursos().add(curso2);

            alumno2.getCursos().add(curso1);

            em.getTransaction().commit();
            System.out.println("alumno1 = " + alumno1);
            System.out.println("alumno2 = " + alumno2);


        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
