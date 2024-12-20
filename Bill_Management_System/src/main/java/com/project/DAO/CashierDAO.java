package com.project.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.project.entity.Cashier;

public class CashierDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bill");

    public List<Cashier> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cashier c", Cashier.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void saveCashier(Cashier cashier) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cashier);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Find the cashier by ID
            Cashier cashier = em.find(Cashier.class, id);
            
            // Check if the cashier exists
            if (cashier != null) {
                em.remove(cashier);  // Delete the cashier entity
            }
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    
    public void updatePassword(int id, String newPassword) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cashier cashier = em.createQuery("SELECT c FROM Cashier c WHERE c.id = :id", Cashier.class)
                                .setParameter("id", id)
                                .getSingleResult();
            cashier.setPassword(newPassword);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Cashier findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cashier.class, id);
        } finally {
            em.close();
        }
    }

}
