/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package control;

import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import enums.Categoria;
import java.util.List;
/**
 *
 * @author haloa
 */
public interface IFachada {
     public void agregarComentario(Comentario comentario, Post post);
    public void agregarComentarioAComentario(Comentario comentarioHijo, Comentario comentarioPadre);
    public void actualizarComentario(Comentario comentario);
    public void eliminarComentario(Comentario comentario);
    public Comentario consultarComentario(int id);
    
    public void agregarPost(Post post);
    public void actualizarPost(Post post);
    public void eliminarPost(Post post);
    public Post consultarPost(int id);
    public void anclarPost(Post post);
    
    public void agregarUsuario(Usuario usuario);
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario consultarUsuario(int id);
    public List<Usuario> consultarUsuarios();
    public boolean iniciarSesion(Usuario usuario);
    public Usuario consultarUsuarioPorCorreo(String correo);
    
    public List<Post> consultarPostsUsuario(Usuario userId, Categoria categoria);
    public List<Post> consultarPostsCategoria(Categoria categoria);
}
