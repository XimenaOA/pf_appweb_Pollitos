/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import dominio.Comentario;
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
    public void agregarComentario(Comentario comentario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.persist(comentario); // Persiste el nuevo comentario
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hace rollback en caso de error
            }
            System.err.println("Error al agregar comentario: " + e.getMessage());
        }
    }

    @Override
    public void agregarComentarioAComentario(Comentario comentario, Comentario comentarioNuevo) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            // Aquí asumimos que 'comentarioNuevo' es una respuesta al 'comentario' existente
            comentarioNuevo.setComentarioPadre(comentario); // Asocia el nuevo comentario al comentario existente
            em.persist(comentarioNuevo); // Persiste el nuevo comentario
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hace rollback en caso de error
            }
            System.err.println("Error al agregar comentario a otro comentario: " + e.getMessage());
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
        Comentario comentario = null;
        try {
            comentario = em.find(Comentario.class, id); // Busca el comentario por ID
        } catch (Exception e) {
            System.err.println("Error al consultar comentario: " + e.getMessage());
        }
        return comentario; // Retorna el comentario encontrado
    }

}
