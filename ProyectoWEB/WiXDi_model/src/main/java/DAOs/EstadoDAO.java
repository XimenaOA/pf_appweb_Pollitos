/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import conexion.IConexion;
import dominio.Estado;
import dominio.Municipio;
import interfaces.IEstadoDAO;
import javax.persistence.EntityManager;



/**
 *
 * @author pollitos
 */
public class EstadoDAO implements IEstadoDAO{
    
    private IConexion conexion;

    public EstadoDAO() {
        this.conexion = new Conexion();
    }
    
    @Override
    public void agregarEstado(Estado estado) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(estado); // Persiste el nuevo estado
            em.getTransaction().commit(); // Confirma la transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hace rollback en caso de error
            }
            System.err.println("Error al agregar estado: " + e.getMessage());
        }
    }

    @Override
    public void agregarMunicipio(Estado estado, Municipio municipio) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            // Aquí podrías añadir lógica para agregar un municipio al estado
            // Por ejemplo, agregar el municipio a una lista de municipios en Estado
            estado.getMunicipios().add(municipio); // Suponiendo que Estado tiene una lista de Municipios
            municipio.setEstado(estado); // Establece la relación en el municipio
            em.persist(municipio); // Persiste el nuevo municipio
            em.merge(estado); // Actualiza el estado para incluir el nuevo municipio
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al agregar municipio: " + e.getMessage());
        }
    }

    @Override
    public void actualizarEstado(Estado estado) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            em.merge(estado); // Actualiza el estado
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al actualizar estado: " + e.getMessage());
        }
    }

    @Override
    public Estado consultarEstado(int id) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            return em.find(Estado.class, id); // Busca y retorna el estado por ID
        } catch (Exception e) {
            System.err.println("Error al consultar estado: " + e.getMessage());
            return null;
        }
    }
    
    
}
    
    

