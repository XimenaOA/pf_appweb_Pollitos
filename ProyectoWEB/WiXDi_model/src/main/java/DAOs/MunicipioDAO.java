/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import conexion.IConexion;
import dominio.Municipio;
import interfaces.IMunicipioDAO;
import javax.persistence.EntityManager;


/**
 *
 * @author pollitos
 */
public class MunicipioDAO implements IMunicipioDAO{
    
    private IConexion conexion;

    public MunicipioDAO() {
        this.conexion = new Conexion();
        
    }
    @Override
    public void agregarMunicipio(Municipio municipio) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            em.persist(municipio);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }

    @Override
    public void actualizarMunicipio(Municipio municipio) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            em.merge(municipio);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Lanza la excepción para manejarla en otro lugar
        }
    }


    @Override
    public Municipio consultarMunicipio(int id) {
        EntityManager em = conexion.abrir();
        em.getTransaction().begin();
        return em.find(Municipio.class, id);
    }
}
