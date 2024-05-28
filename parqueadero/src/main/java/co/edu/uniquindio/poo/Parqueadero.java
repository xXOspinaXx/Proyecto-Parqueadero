package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Parqueadero {

  public String nombre;
  public int cantPuestos = 50;
  public int filas = 9;
  public int columnas = 9;

  /**
   * Metodo constructor de la clase parqueadero
   * @param nombre
   * @param cantPuestos
   * @param filas
   * @param columnas
   * @param listaVehiculos
   * @param listaFacturas
   * @param puesto
   */

  public Parqueadero(String nombre, int cantPuestos, int filas, int columnas, Collection<Vehiculo> listaVehiculos,
      Collection<Factura> listaFacturas, Puesto[][] puesto) {
    this.nombre = nombre;
    this.cantPuestos = cantPuestos;
    this.filas = filas;
    this.columnas = columnas;
    this.listaVehiculos = listaVehiculos;
    this.listaFacturas = listaFacturas;
    this.puesto = puesto;
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
   * Metodo setNombre
   * 
   * @param nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Metodo getCantPuestos
   * 
   * @return
   */
  public int getCantPuestos() {
    return cantPuestos;
  }

  /**
   * Metodo setCantPuestos
   * 
   * @param cantPuestos
   */
  public void setCantPuestos(int cantPuestos) {
    this.cantPuestos = cantPuestos;
  }

  /**
   * Metodo getFilas
   * 
   * @return
   */
  public int getFilas() {
    return filas;
  }

  /**
   * Metodo setFilas
   * 
   * @param filas
   */
  public void setFilas(int filas) {
    this.filas = filas;
  }

  /**
   * Metodo getColumnas
   * 
   * @return
   */
  public int getColumnas() {
    return columnas;
  }

  /**
   * setColumnas
   * 
   * @param columnas
   */
  public void setColumnas(int columnas) {
    this.columnas = columnas;
  }

  Collection<Vehiculo> listaVehiculos = new ArrayList<>();
  
  /**
   * Metodo getListavehiculos
   * @return
   */
  public Collection<Vehiculo> getListaVehiculos() {
    return listaVehiculos;
  }
  /**
   * Metodo setListaVehiculos
   * @param listaVehiculos
   */
  public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
    this.listaVehiculos = listaVehiculos;
  }

  Collection<Factura> listaFacturas = new ArrayList<>();

  /**
   * Metodo crear la matriz para los puestos del parqueadero
   */
  Puesto[][] puesto = new Puesto[filas][columnas];
  {

    for (int i = 0; i < filas; i++) {
      puesto[0][0].setEstado(false);
      puesto[0][1].setEstado(false);
      puesto[1][1].setEstado(false);
      puesto[1][2].setEstado(false);
      puesto[1][3].setEstado(false);
      puesto[1][4].setEstado(false);
      puesto[1][5].setEstado(false);
      puesto[1][6].setEstado(false);
      puesto[1][7].setEstado(false);
      puesto[2][1].setEstado(false);
      puesto[2][4].setEstado(false);
      puesto[2][7].setEstado(false);
      puesto[3][1].setEstado(false);
      puesto[3][4].setEstado(false);
      puesto[3][7].setEstado(false);
      puesto[4][1].setEstado(false);
      puesto[4][4].setEstado(false);
      puesto[4][7].setEstado(false);
      puesto[5][1].setEstado(false);
      puesto[5][4].setEstado(false);
      puesto[5][7].setEstado(false);
      puesto[6][1].setEstado(false);
      puesto[6][4].setEstado(false);
      puesto[6][7].setEstado(false);
      puesto[7][1].setEstado(false);
      puesto[7][2].setEstado(false);
      puesto[7][3].setEstado(false);
      puesto[7][4].setEstado(false);
      puesto[7][5].setEstado(false);
      puesto[7][6].setEstado(false);
      puesto[7][7].setEstado(false);

      for (int j = 0; j < columnas; j++) {

      }
    }

  }

  /**
   * Metodo para agregar un vehiculo a la lista de vehiculos
   * 
   * @param vehiculo
   */
  public void agregarVehiculo(Vehiculo vehiculo) {
    assert !existeVehiculo(vehiculo.getPlaca());
    listaVehiculos.add(vehiculo);
  }

  /**
   * Metodo para verificar si el vehiculo ya se encuentra en la lista de vehiculos
   * 
   * @param placa
   * @return
   */
  boolean existeVehiculo(String placa) {
    for (Vehiculo vehiculo : listaVehiculos) {
      if (vehiculo.getPlaca().equals(placa)) {
        return true;
      }
    }
    return false;

  }

  /**
   * Metodo para verificar los estados de los puestos si esta ocupado o si esta
   * desocupado
   * 
   * @param puestos
   * @return
   */
  public boolean verificarEstadosPuestos(Puesto puestos) {
    for (int i = 0; i < puesto.length; i++) {
      for (int j = 0; j < puesto[i].length; j++) {
        if (puesto[i][j].equals(puestos) && puesto[i][j].isEstado()) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Metodo que estaciona un vehiculo en un puesto al azar y verifica si ese
   * puesto esta ocupado o desocupado
   * 
   * @param vehiculo
   */

  public void estacionarVehiculo(Vehiculo vehiculo) {
    Random random = new Random();
    int i = 0, j = 0;
    boolean estacionado = false;
    Puesto puesto1 = new Puesto(i, j);

    while (!estacionado) {
      i = random.nextInt(filas);
      j = random.nextInt(columnas);

      if (verificarEstadosPuestos(puesto1) == true) {
        puesto[i][j].setListaVehiculos(vehiculo);
        estacionado = true;
        System.out.println("Vehículo " + vehiculo + " estacionado en (" + i + ", " + j + ")");
      } else {
        System.out.println("Todos los puestos del parqueadero estan ocupados");
        break;
      }
    }
  }

  /**
   * Metodo para agregar las facturas a la lista de facturas
   * 
   * @param factura
   */
  public void agregarFactura(Factura factura) {
    listaFacturas.add(factura);
  }

  /**
   * Metodo para filtrar las facturas por dia
   * 
   * @param fecha
   * @return
   */
  public List<Factura> filtrarPorDia(LocalDateTime fecha) {
    List<Factura> facturasFiltradas = new ArrayList<>();
    for (Factura factura : listaFacturas) {
      if (factura.getFecha().equals(fecha)) {
        facturasFiltradas.add(factura);

      }
    }
    return facturasFiltradas;
  }

  /**
   * Metodo para filtrar las facturas por mes
   * 
   * @param fecha
   * @return
   */
  public List<Factura> filtrarPorMes(LocalDateTime fecha) {
    List<Factura> facturasFiltradas = new ArrayList<>();
    for (Factura factura : listaFacturas) {
      if (factura.getFecha().getMonthValue() == fecha.getMonthValue()) {
        facturasFiltradas.add(factura);

      }
    }
    return facturasFiltradas;
  }
  /**
   * Metodo para mostrar la matriz parqueadero
   */
  public void mostrarEstacionamiento() {
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            System.out.print(puesto[i][j] + "\t");
        }
        System.out.println();
    }
  }
  /**
   * Metodo para eliminar un vehiculo de la lista de vehiculos y tambien actualizar el parqueadero 
   * @param placa
   */
  public void eliminarVehiculo(String placa) {
    
    Vehiculo vehiculoAEliminar = null;
    for (Vehiculo vehiculo : listaVehiculos) {
        if (vehiculo.getPlaca().equals(placa)) {
            vehiculoAEliminar = vehiculo;
            break;
        }
    }

    if (vehiculoAEliminar != null) {
        
        listaVehiculos.remove(vehiculoAEliminar);
        System.out.println("Vehículo con placa " + placa + " eliminado de la lista de vehículos.");

        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (puesto[i][j].getListaVehiculos() == vehiculoAEliminar) {
                    puesto[i][j].setEstado(false);
                    System.out.println("Puesto (" + i + ", " + j + ") marcado como desocupado.");
                    return;
                }
            }
        }
        System.out.println("No se encontró el vehículo en la matriz de puestos.");
    } else {
        System.out.println("No se encontró el vehículo en la lista de vehículos.");
    }
}

}



