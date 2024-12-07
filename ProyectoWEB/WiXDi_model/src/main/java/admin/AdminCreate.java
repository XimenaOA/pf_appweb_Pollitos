
package admin;

import conexion.Conexion;
import dominio.Municipio;
import dominio.Usuario;
import dominio.Usuario.Rol;
import java.util.Date;
import javax.persistence.EntityManager;


/**
 *
 * @author Wilber
 */
public class AdminCreate {

//    //LEER---------------------------------LEER--------------------------------LEER-------------------------------LEER-------------------------------LEER------------------
//    
////PLEBES ESTUVE INTENTANDO HACER QUE SE CREARA UN USUARIO ADMIN AUTOMATICAMENTE CUANDO SE CORRE EL PROGRAMA.
//   //DESPUES DE ESTA CLASE SE MANDAN LOS DATOS A LA CLASE "AppInitializer" (paquete: listeners, en WiXDi_Web), Para esto, se añade un <listener> en web.xml(esta hasta abajo).
//    //El problema es que cuando lo corro me sale un fallo, no encontre el error. Pero creo que es en esta clase.
//    
//    //LEER---------------------------------LEER--------------------------------LEER-------------------------------LEER-------------------------------LEER------------------
//
//  
//
//    public void createAdmin() {
//        // Crear instancia de la clase Conexion
//        Conexion conexion = new Conexion();
//        EntityManager em = conexion.abrir();
//
//        try {
//            // VERIFICA SI YA EXISTE UN ADMIN EN LA BASE DE DATOS
//            Usuario admin = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo", Usuario.class)
//                              .setParameter("correo", "admin@gmail.com")
//                              .getResultList().stream().findFirst().orElse(null);
//
//            if (admin == null) {
//                // Si no existe el usuario admin, crear uno nuevo
//                em.getTransaction().begin();
//
//                // Crear el municipio llamado "Admin"
//                Municipio municipio = em.createQuery("SELECT m FROM Municipio m WHERE m.nombre = :nombre", Municipio.class)
//                                         .setParameter("nombre", "Admin")
//                                         .getSingleResult();
//
//                // CREAR UN NUEVO USUARIO ADMIN
//                admin = new Usuario();
//                admin.setNombre("admin");
//                admin.setApellidoPaterno("admin");
//                admin.setApellidoMaterno("admin");
//                admin.setCorreo("admin@gmail.com");
//                admin.setContrasenia("admin");
//                admin.setTelefono("12345");
//                admin.setFechaNacimiento(new Date(2024 - 1900, 10 - 1, 2)); // Corrección en el año y mes
//                admin.setGenero(Usuario.Genero.MASCULINO);
//                admin.setRol(Rol.ADMINISTRADOR);
//                admin.setMunicipio(municipio);
//
//                // persiste   el usuario admin en la base de datos
//                em.persist(admin);
//                em.getTransaction().commit();
//                System.out.println("Usuario administrador creado exitosamente.");
//            } else {
//                System.out.println("El usuario administrador ya existe.");
//            }
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close(); 
//        }
//    }
}