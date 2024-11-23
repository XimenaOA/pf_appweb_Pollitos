/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import dominio.Post;
import interfaces.IPostDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 *
 * @author si
 */
public class PostDAO implements IPostDAO{
    
    private EntityManager em;
    private Conexion conexion;

    public PostDAO() {
        this.conexion = new Conexion();
        this.em = conexion.getEntityManager();
    }
    
    @Override
    public void agregarPost(Post post) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(post);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }

    @Override
    public void actualizarPost(Post post) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(post);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }

    @Override
    public void eliminarPost(Post post) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Post postToRemove = em.find(Post.class, post.getIdPost());
            if (postToRemove != null) {
                em.remove(postToRemove);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }

    @Override
    public Post consultarPost(int id) {
        return em.find(Post.class, id);
    }

    @Override
    public void anclarPost(Post post) {
        // Suponiendo que anclarPost solo modifica una propiedad del post
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Post postToUpdate = em.find(Post.class, post.getIdPost());
            if (postToUpdate != null) {
                postToUpdate.setIsAnclado(true); // Suponiendo que hay un campo "anclado" en la clase Post
                em.merge(postToUpdate);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }
    
    
}