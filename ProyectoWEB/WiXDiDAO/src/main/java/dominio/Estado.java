package dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @OneToMany(mappedBy = "estado", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Municipio> municipios;

    // Constructor vacío (necesario para JPA)
    public Estado() {
        this.municipios = new ArrayList<>();  // Inicialización de la lista para evitar NullPointerException
    }

    // Constructor con parámetros (para cuando se desee crear un Estado con nombre)
    public Estado(String nombre) {
        this.nombre = nombre;
        this.municipios = new ArrayList<>();  // Inicialización de la lista para evitar NullPointerException
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
}
