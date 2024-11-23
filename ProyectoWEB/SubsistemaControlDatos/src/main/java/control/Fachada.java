/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.Comentario;
import dominio.Estado;
import dominio.Municipio;
import dominio.Post;
import dominio.Usuario;
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
    public void agregarComentario(Comentario comentario) {
        factory.objectoComentario().agregarComentario(comentario);
    }

    @Override
    public void agregarComentarioAComentario(Comentario comentario, Comentario comentarioNuevo) {
        factory.objectoComentario().agregarComentarioAComentario(comentario, comentarioNuevo);
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
    
    
    
}
