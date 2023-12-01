package com.joelfiare.dao;

import com.joelfiare.model.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class AlumnoDAO {

    private final EntityManagerFactory entityManagerFactory;

    public AlumnoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ValidadorDeCorrelativas");
    }

    public void agregarAlumno(Alumno alumno) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(alumno);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Alumno obtenerAlumnoPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Alumno alumno = null;

        try {
            alumno = entityManager.find(Alumno.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return alumno;
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Alumno> alumnos = null;

        try {
            alumnos = entityManager.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return alumnos;
    }

    public void cerrarEntityManagerFactory() {
        entityManagerFactory.close();
    }
}

