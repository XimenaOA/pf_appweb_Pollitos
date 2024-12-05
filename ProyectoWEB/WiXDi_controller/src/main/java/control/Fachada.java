/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


/**
 *
 * @author haloa
 */
import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import enums.Categoria;
import factory.FactoryObjects;
import factory.IFactoryObjects;
import java.util.List;

/**
 *
 * @author pollitos
 */
public class Fachada implements IFachada{
    IFactoryObjects factory;
    
    public Fachada(){
        factory = new FactoryObjects();
    }

    @Override
    public void agregarComentario(Comentario comentario, Post post) {
        factory.objectoComentario().agregarComentario(comentario, post);
    }

    @Override
    public void agregarComentarioAComentario(Comentario comentarioHijo, Comentario comentarioPadre) {
        factory.objectoComentario().agregarComentarioAComentario(comentarioHijo, comentarioPadre);
    }

    @Override
    public void actualizarComentario(Comentario comentario) {
        factory.objectoComentario().actualizarComentario(comentario);
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        factory.objectoComentario().eliminarComentario(comentario);
    }

    @Override
    public Comentario consultarComentario(int id) {
            return factory.objectoComentario().consultarComentario(id);
    }

    @Override
    public void agregarPost(Post post) {
        factory.obejctoPost().agregarPost(post);
    }

    @Override
    public void actualizarPost(Post post) {
        factory.obejctoPost().actualizarPost(post);
    }

    @Override
    public void eliminarPost(Post post) {
        factory.obejctoPost().eliminarPost(post);
    }

    @Override
    public Post consultarPost(int id) {
        return factory.obejctoPost().consultarPost(id);
    }

    @Override
    public void anclarPost(Post post) {
        factory.obejctoPost().anclarPost(post);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        factory.objectoUsuario().agregarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        factory.objectoUsuario().actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        factory.objectoUsuario().eliminarUsuario(usuario);
    }

    @Override
    public Usuario consultarUsuario(int id) {
        return factory.objectoUsuario().consultarUsuario(id);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return factory.objectoUsuario().consultarUsuarios();
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        return factory.objectoUsuario().iniciarSesion(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorCorreo(String correo) {
        return factory.objectoUsuario().consultarUsuarioPorCorreo(correo);
    }

    @Override
    public List<Post> consultarPostsUsuario(Usuario userId, Categoria categoria) {
        return factory.obejctoPost().consultarPostsUsuario(userId, categoria);
    }

    @Override
    public List<Post> consultarPostsCategoria(Categoria categoria) {
        return factory.obejctoPost().consultarPostsCategoria(categoria);
    }
}


