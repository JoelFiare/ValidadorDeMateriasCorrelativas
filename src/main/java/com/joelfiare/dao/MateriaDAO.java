package com.joelfiare.dao;

import com.joelfiare.model.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class MateriaDAO {

    private final EntityManagerFactory entityManagerFactory;

    public MateriaDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ValidadorDeCorrelativas");
    }

    public void agregarMateria(Materia materia) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(materia);

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

    public List<Materia> obtenerTodasLasMaterias() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT m FROM Materia m", Materia.class).getResultList();
    }

    public Materia obtenerMateriaPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Materia.class, id);
    }

    public void cerrarEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
