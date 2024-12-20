package com.project.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.project.entity.Admin;

public class AdminDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bill");

    public Admin findByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
                     .setParameter("username", username)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public void saveAdmin(Admin admin) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
