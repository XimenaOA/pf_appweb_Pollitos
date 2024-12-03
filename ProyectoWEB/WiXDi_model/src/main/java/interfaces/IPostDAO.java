/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Post;
import dominio.Usuario;
import enums.Categoria;
import java.util.List;

/**
 *
 * @author pollitos
 */
public interface IPostDAO {
 
    public void agregarPost(Post post);
    public void actualizarPost(Post post);
    public void eliminarPost(Post post);
    public Post consultarPost(int id);
    public void anclarPost(Post post);
    
    public List<Post> consultarPostsUsuario(Usuario userId, Categoria categoria);
    public List<Post> consultarPostsCategoria(Categoria categoria);
}
