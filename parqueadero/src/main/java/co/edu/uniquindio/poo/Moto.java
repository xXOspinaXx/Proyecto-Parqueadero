package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {

    private double VelMax;
    private TipoMoto tipoMoto;

    /**
     * Metodo constructor clase moto
     * 
     * @param placa
     * @param modelo
     * @param propietario
     * @param tarifa
     * @param velMax
     * @param tipoMoto
     */
    public Moto(String placa, String modelo, String propietario, double tarifa, double velMax, TipoMoto tipoMoto) {
        super(placa, modelo, propietario, tarifa);
        VelMax = velMax;
        this.tipoMoto = tipoMoto;
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
     * Metodo para obtener la Velmax de una moto
     * 
     * @return
     */
    public double getVelMax() {
        return VelMax;
    }

    /**
     * Metodo setVelMax
     * 
     * @param velMax
     */
    public void setVelMax(double velMax) {
        VelMax = velMax;
        assert VelMax > 0;
    }

    /**
     * Metodo getTipoMoto
     * 
     * @return
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    /**
     * Metodo setTipoMoto
     * 
     * @param tipoMoto
     */
    public void setTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

}
