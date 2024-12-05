/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import dominio.Comentario;
import dominio.Post;
import interfaces.IComentarioDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author pollitos
 */
public class ComentarioDAO implements IComentarioDAO {

    private Conexion conexion;

    public ComentarioDAO() {
        this.conexion = new Conexion();
    }

    @Override
    public void agregarComentario(Comentario comentario, Post post) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();

            // Recuperar el Post gestionado si no lo está
            Post postGestionado = em.find(Post.class, post.getIdPost());
            if (postGestionado == null) {
                throw new IllegalArgumentException("El Post asociado no existe en la base de datos.");
            }

            // Asociar el comentario al Post
            comentario.setPost(postGestionado);

            // Agregar el comentario a la lista de comentarios del Post
            postGestionado.getComentarios().add(comentario);

            // Persistir el nuevo comentario
            em.persist(comentario);

            // JPA sincroniza automáticamente los cambios en el Post gestionado
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback en caso de error
            }
            System.err.println("Error al agregar comentario: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public void agregarComentarioAComentario(Comentario comentarioHijo, Comentario comentarioPadre) {
         EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();

            // Recuperar el Post gestionado si no lo está
            Comentario comentarioGestionado = em.find(Comentario.class, comentarioPadre.getId());
            if (comentarioGestionado == null) {
                throw new IllegalArgumentException("El Post asociado no existe en la base de datos.");
            }

            // Asociar el comentario al Post
            comentarioHijo.setComentarioPadre(comentarioGestionado);

            // Agregar el comentario a la lista de comentarios del Post
            comentarioGestionado.getComentariosHijos().add(comentarioHijo);

            // Persistir el nuevo comentario
            em.persist(comentarioHijo);

            // JPA sincroniza automáticamente los cambios en el Post gestionado
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback en caso de error
            }
            System.err.println("Error al agregar comentario: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }

    @Override
    public void actualizarComentario(Comentario comentario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.merge(comentario); // Actualiza el comentario existente
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hace rollback en caso de error
            }
            System.err.println("Error al actualizar comentario: " + e.getMessage());
        }
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            // Busca el comentario por ID
            Comentario comentarioParaEliminar = em.find(Comentario.class, comentario.getId());
            if (comentarioParaEliminar != null) {
                em.remove(comentarioParaEliminar); // Elimina el comentario
            }
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hace rollback en caso de error
            }
            System.err.println("Error al eliminar comentario: " + e.getMessage());
        }
    }

    @Override
    public Comentario consultarComentario(int id) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();

        try {
            Comentario comentario = em.find(Comentario.class, id); // Busca el comentario por ID
            return comentario; // Retorna el comentario encontrado
        } catch (Exception e) {
            System.err.println("Error al consultar comentario: " + e.getMessage());
            return null;
        }
    }

}
