/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import enums.Categoria;
import java.util.Date;

/**
 *
 * @author haloa
 */
public class test {

    public static void main(String[] args) {
        IFachada f;
        f = new Fachada();
        Usuario usuario = f.consultarUsuarioPorCorreo("x@gmail.com");
 
//        Post post = new Post(new Date(), "hey muy buenas a todos guapisimos aqui vegetta 700 te la meteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", false, null, Categoria.Valorant, usuario);
        
        Post post = f.consultarPost(22);
        Comentario comentario = new Comentario(new Date(), "hola soy panchito", usuario, post, null);
        Comentario comentario2 = new Comentario(new Date(), "papoi", usuario, post, null);

        f.agregarComentario(comentario, post);
        f.agregarComentario(comentario2, post);

        System.out.println(comentario.getUsuario().getIdUsuario());
    }
}
