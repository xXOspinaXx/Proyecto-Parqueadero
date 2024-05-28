package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Menu interactivo del programa parqueadero
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", 50, 9, 9, null, null, null);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Vehículo");
            System.out.println("3. Crear Factura");
            System.out.println("4. Gestionar Parqueadero");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el ID del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del cliente: ");
                    String telefono = scanner.nextLine();

                    Cliente cliente = new Cliente(nombre, id, telefono);
                    break;
                case 2:
                    System.out.print("Ingrese la placa del vehiculo:");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehiculo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del propietario del vehiculo:");
                    String propietario = scanner.nextLine();

                    Vehiculo vehiculo = new Vehiculo(placa, modelo, propietario);
                    parqueadero.agregarVehiculo(vehiculo);
                    parqueadero.estacionarVehiculo(vehiculo);
                    System.out.println("Vehiculo registrado"+ vehiculo.getPlaca());
 
                    break;
                case 3:
                System.out.print("Ingrese la fecha de ingreso del vehiculo (formato yyyy-MM-dd HH:mm):");
                String fechaIngreso = scanner.nextLine();
                System.out.print("Ingrese la fecha de salida del vehiculo (formato yyyy-MM-dd HH:mm): ");
                String fechaSalida = scanner.nextLine();

                Factura factura = new Factura(null, fechaIngreso, opcion, fechaSalida, null);
                parqueadero.agregarFactura(factura); 
                    break;
                case 4:
                    while (true) {
                        System.out.println("\nGestionar Parqueadero:");
                        System.out.println("1. Mostrar parqueadero");
                        System.out.println("2. Eliminar Vehiculo");
                        System.out.println("3. Salir");
                        System.out.print("Seleccione una opción: ");
                        int opcion1 = scanner.nextInt();

                        switch (opcion1) {
                            case 1:
                            parqueadero.mostrarEstacionamiento();    
                                break;
                            case 2:
                            System.out.print("Ingrese la placa del vehículo a eliminar: ");
                            String placaAEliminar = scanner.nextLine();
                            parqueadero.eliminarVehiculo(placaAEliminar);
                            break;
                            case 3:
                            System.out.println("Saliendo...");
                            scanner.close();
                            System.exit(0);
                        
                            default:
                                break;
                        }
            
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

}
