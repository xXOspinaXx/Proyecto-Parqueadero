package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;

public class Puesto {

    public int columnas;
    public int filas;
    private boolean estado;

    /**
     * getEstado
     * 
     * @return
     */
    public boolean getEstado() {
        return this.estado;
    }

    /**
     * setEstado
     * 
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    Collection<Vehiculo> listaVehiculos = new ArrayList<>();

    /**
     * setListaVehiculos
     * 
     * @param vehiculos
     */
    public void setListaVehiculos(Vehiculo vehiculos) {
        this.listaVehiculos.add(vehiculos);
    }

    /**
     * Metodo constructor
     * 
     * @param columnas
     * @param filas
     */
    public Puesto(int columnas, int filas) {
        this.columnas = columnas;
        this.filas = filas;

    }

    /**
     * Metodo para ocupar un puesto
     */
    public void ocuparPuesto() {
        if (!estado) {
            estado = true;
            System.out.println("Vehículo asignado al puesto.");
        } else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    /**
     * Metodo para liberar un puesto
     */
    public void liberarPuesto() {
        if (estado) {
            estado = false;
            System.out.println("Vehículo retirado del puesto.");
        } else {
            System.out.println("El puesto ya está libre.");
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public Collection<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

}
