/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haloa
 */
public class test {
       public static void main(String[] args) {
        IFachada f;
        f = new Fachada();
        Usuario usuario = f.consultarUsuarioPorCorreo("x@gmail.com");
 
           System.out.println(usuario);
        
        List<Comentario> list = new ArrayList<>();
        
        Comentario comentario1 = new Comentario(new Date(), "KJASKJAJKSKJAS", usuario);
        Comentario comentario2 = new Comentario(new Date(), "NO PUEDE SER", usuario);
        
        list.add(comentario1);
        list.add(comentario2);
        
        Post post = new Post(new Date(), "Si ghiuwfhgwefhwehfwehi", "", false, list);
        List<Post> listPost = new ArrayList<>();
        listPost.add(post);
 
    }
}
