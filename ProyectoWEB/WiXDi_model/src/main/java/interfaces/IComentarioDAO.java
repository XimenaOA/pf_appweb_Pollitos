/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Comentario;
import dominio.Post;

/**
 *
 * @author pollitos
 */
public interface IComentarioDAO {
    
     public void agregarComentario(Comentario comentario, Post post);
     public void agregarComentarioAComentario(Comentario comentario, Comentario comentarioNuevo);
     public void actualizarComentario(Comentario comentario);
     public void eliminarComentario(Comentario comentario);
     public Comentario consultarComentario(int id);
}
