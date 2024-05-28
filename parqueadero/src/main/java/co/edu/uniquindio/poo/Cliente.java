package co.edu.uniquindio.poo;

public class Cliente {

    public String nombre;
    public String id;
    public String telefono;

    /**
     * Metodo constructor
     * 
     * @param nombre
     * @param id
     * @param telefono
     */
    public Cliente(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    /**
     * Metodo getNombre
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo getId
     * 
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo getTelefono
     * 
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo setNombre
     * 
     * @return
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo setId
     * 
     * @return
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo setTelefono
     * 
     * @return
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
