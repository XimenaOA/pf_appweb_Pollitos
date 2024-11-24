/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author pollitos
 */
public class Conexion implements IConexion {

    private EntityManagerFactory emf;

    @Override
    public EntityManager abrir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
