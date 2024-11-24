/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Post")
public class Post {

    public Post() {
    }

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPost;

    @Temporal(TemporalType.DATE)
    private Date fechaHoraCreacion;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String contenido;

    @Temporal(TemporalType.DATE)
    private Date fechaHoraEdicion;

    @Column(nullable = false)
    private boolean isAnclado;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public boolean isIsAnclado() {
        return isAnclado;
    }

    public void setIsAnclado(boolean isAnclado) {
        this.isAnclado = isAnclado;
    }
    
    
    
}
