/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/**
 *
 * @author pollitos
 */
public class Conexion {
    private static EntityManagerFactory emf;

    // Inicializa el EntityManagerFactory
    static {
        try {
            emf = Persistence.createEntityManagerFactory("com.mycompany_SportifyDAO_jar_1.0-SNAPSHOTPU");
        } catch (Exception e) {
            System.err.println("Error al crear el EntityManagerFactory: " + e.getMessage());
        }
    }

    // Método para obtener el EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para cerrar el EntityManagerFactory
    public  void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
