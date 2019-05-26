package aplicactions.ticas.appticas.models;


import javax.persistence.*;

@Entity
@Table(name="app")
@Access(AccessType.FIELD)
public class ApplicationEntity {

    @Id
    @Column(name="id_app",nullable = true)
    private Integer idApp;// serial not null,

    @Column(name="nombre",nullable = false, length = 20)
    private String nombre;// varchar(20) not null,

    @Column(name="categoria",nullable = false)
    private Integer categoria;// int not null,

    @Column(name="desarrollador",nullable = false)
    private Integer desarrollador;// int not null,

    @Column(name="descripcion",nullable = true, length = 100)
    private String descripcion;// varchar (100),

    @Column(name="imagen",nullable = true)
    private String imagen;// BYTEA,

    public Integer getIdApp() {
        return idApp;
    }

    public void setIdApp(Integer idApp) {
        this.idApp = idApp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Integer desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ApplicationEntity(Integer idApp, String nombre, Integer categoria, Integer desarrollador, String descripcion, String imagen) {
        this.idApp = idApp;
        this.nombre = nombre;
        this.categoria = categoria;
        this.desarrollador = desarrollador;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "idApp=" + idApp +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", desarrollador=" + desarrollador +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

