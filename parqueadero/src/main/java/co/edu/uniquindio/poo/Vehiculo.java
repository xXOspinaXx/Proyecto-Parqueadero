package co.edu.uniquindio.poo;

public class Vehiculo {
    public String placa;
    public String modelo;
    public String propietario;
    public static double tarifa;

    

    public Vehiculo() {
    }

    /**
     * Metodo constructor
     * 
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Vehiculo(String placa, String modelo, String propietario, double tarifa) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.tarifa = tarifa;
    }

    /**
     * Metodo setTarifa
     * @param tarifa
     */
    public static void setTarifa(double tarifa) {
        Vehiculo.tarifa = tarifa;
    }
   
    /**
     * Metodo getTarifa
     * @return
     */
    public static double getTarifa() {
        return tarifa;
    }
    /**
     * Metodo getPlaca
     * 
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Metodo setPlaca
     * 
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Metodo getModelo
     * 
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo setModelo
     * 
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo getPropietario
     * 
     * @return
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * Metodo setPropietario
     * 
     * @param propietario
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
