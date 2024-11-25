/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import conexion.IConexion;
import dominio.Post;
import interfaces.IPostDAO;
import javax.persistence.EntityManager;


/**
 *
 * @author si
 */
public class PostDAO implements IPostDAO{
    
    private IConexion conexion;

    public PostDAO() {
        this.conexion = new Conexion();
    }
    
    @Override
    public void agregarPost(Post post) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            // Asegurarse de cerrar el EntityManager
            em.close();
        }
    }

    @Override
    public void actualizarPost(Post post) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }finally {
            // Asegurarse de cerrar el EntityManager
            em.close();
        }
    }

    @Override
    public void eliminarPost(Post post) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            Post postToRemove = em.find(Post.class, post.getIdPost());
            if (postToRemove != null) {
                em.remove(postToRemove);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }finally {
            // Asegurarse de cerrar el EntityManager
            em.close();
        }
    }

    @Override
    public Post consultarPost(int id) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        return em.find(Post.class, id);
    }

    @Override
    public void anclarPost(Post post) {
       EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            Post postToUpdate = em.find(Post.class, post.getIdPost());
            if (postToUpdate != null) {
                postToUpdate.setIsAnclado(true); // Suponiendo que hay un campo "anclado" en la clase Post
                em.merge(postToUpdate);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }finally {
            // Asegurarse de cerrar el EntityManager
            em.close();
        }
    }
    
    
}
