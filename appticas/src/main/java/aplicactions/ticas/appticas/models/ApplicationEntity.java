package aplicactions.ticas.appticas.models;


public class ApplicationEntity {

    private Integer idApp;// serial not null,
    private String nombre;// varchar(20) not null,
    private Integer categoria;// int not null,
    private Integer desarrollador;// int not null,
    private String descripcion;// varchar (100),
    private String imagen;// BYTEA,
    private Integer stars;

    public ApplicationEntity(Integer idApp, String nombre, Integer categoria, Integer desarrollador, String descripcion, String imagen, Integer stars) {
        this.idApp = idApp;
        this.nombre = nombre;
        this.categoria = categoria;
        this.desarrollador = desarrollador;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stars = stars;
    }

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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}

