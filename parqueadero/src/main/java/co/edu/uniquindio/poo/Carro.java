package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    public final int cantPuertas;
    
    
    /**
     * Metodo constructor de la clase carro
     */
    public Carro(String placa, String modelo, String propietario, double tarifa, int cantPuertas) {
        super(placa, modelo, propietario, tarifa);
        this.cantPuertas = cantPuertas;
    }
    
    
    /**
     * Metodo setTarifa
     * @param tarifa
     */
    public static void setTarifa(double tarifa){
        Vehiculo.setTarifa(tarifa);
    
    }

    /**
     * Metodo getCantPuertas
     * 
     * @return
     */
    public int getCantPuertas() {
        return cantPuertas;
    }
   
    /**
     * Metodo getTarifa
     * @return
     */
    public static double getTarifa() {
        return tarifa;
    }
    
}
