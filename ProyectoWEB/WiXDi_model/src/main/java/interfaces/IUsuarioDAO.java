/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author pollitos
 */
public interface IUsuarioDAO {
    public void agregarUsuario(Usuario usuario);
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario consultarUsuario(int id);
    public List<Usuario> consultarUsuarios();
    public boolean iniciarSesion(Usuario usuario);
    public Usuario consultarUsuarioPorCorreo(String correo);
}
