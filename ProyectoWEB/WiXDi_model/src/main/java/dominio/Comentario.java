/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Comentario")
public class Comentario implements Serializable {

    public Comentario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(nullable = false, length = 255)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idComentarioPadre", referencedColumnName = "idComentario", foreignKey = @ForeignKey(name = "FK_Comentario_idComentarioPadre"))
    private Comentario comentarioPadre;

    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> respuestas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idPost", nullable = false)
    private Post post;

    public Comentario(Date fechaHora, String contenido, Usuario usuario) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
    }

    public Comentario(Date fechaHora, String contenido, Usuario usuario, Post post, Comentario comentarioPadre, List<Comentario> respuestas) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.post = post;
        this.comentarioPadre = comentarioPadre;
        this.respuestas = respuestas;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comentario getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(Comentario comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    public List<Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Comentario> respuestas) {
        this.respuestas = respuestas;
    }

}
