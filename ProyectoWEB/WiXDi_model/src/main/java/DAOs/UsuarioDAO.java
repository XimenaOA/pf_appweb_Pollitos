/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import conexion.IConexion;
import dominio.Usuario;
import interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author pollitos
 */
public class UsuarioDAO implements IUsuarioDAO {

    private IConexion conexion;

    public UsuarioDAO() {
        this.conexion = new Conexion();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        EntityManager em = conexion.abrir();
        try {
            em.getTransaction().begin();
            Usuario usuarioToRemove = em.find(Usuario.class, usuario.getIdUsuario());
            if (usuarioToRemove != null) {
                em.remove(usuarioToRemove);
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario consultarUsuario(int id) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } catch (RuntimeException e) {
            // Manejo de errores
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            em.close();
        }
        return usuarios;
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            // Crear la consulta JPQL para buscar el usuario por correo
            String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia";

            // Ejecutar la consulta y obtener el resultado
            Usuario usuarioQuery = em.createQuery(jpql, Usuario.class)
                    .setParameter("correo", usuario.getCorreo())
                    .setParameter("contrasenia", usuario.getContrasenia())
                    .getSingleResult(); // Devuelve el único usuario que coincide con ambos parámetros

            if (usuarioQuery != null) {
                return true;
            }

        } catch (NoResultException e) {
            // Si no se encuentra un usuario con ese correo y contraseña
            throw e; // Lanza la excepción para manejarla en otro lugar
        } finally {
            // Cerrar el EntityManager
            em.close();
        }
        return false;
    }
}
