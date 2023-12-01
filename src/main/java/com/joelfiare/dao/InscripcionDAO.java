package com.joelfiare.dao;

import com.joelfiare.model.Inscripcion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class InscripcionDAO {

    private final EntityManagerFactory entityManagerFactory;

    public InscripcionDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ValidadorDeCorrelativas");
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(inscripcion);

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

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
    }

    public Inscripcion obtenerInscripcionPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Inscripcion.class, id);
    }

    public void cerrarEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public void agregarInscripcion(int alumnoId, int materiaId1) {
    }
}

