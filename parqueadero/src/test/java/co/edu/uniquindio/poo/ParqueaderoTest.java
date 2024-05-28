package co.edu.uniquindio.poo;

import java.lang.System.Logger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParqueaderoTest {

    private Parqueadero parqueadero;
    private Vehiculo vehiculo;
    private Puesto[][] puestoSimulado;

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void testConstructor() {
        String nombre = "Prueba";
        int cantPuestos = 10;
        int filas = 2;
        int columnas = 5;
        Collection<Vehiculo> listaVehiculos = new ArrayList<>();
        Collection<Factura> listaFacturas = new ArrayList<>();
        Puesto[][] puesto = new Puesto[filas][columnas];

        Parqueadero parqueadero = new Parqueadero(nombre, cantPuestos, filas, columnas, listaVehiculos, listaFacturas,
                puesto);

        assertEquals(nombre, parqueadero.getNombre(), "El nombre debe coincidir");
        assertEquals(cantPuestos, parqueadero.getCantPuestos(), "La cantidad de puestos debe coincidir");
        assertEquals(filas, parqueadero.getFilas(), "Las filas deben coincidir");
        assertEquals(columnas, parqueadero.getColumnas(), "Las columnas deben coincidir");
    }

    @Test
    public void testAgregarVehiculo() {

        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", "Carlos");
        Vehiculo vehiculo2 = new Vehiculo("XYZ456", "Honda", "Camilo");

        Parqueadero parqueadero = new Parqueadero("Prueba", 10, 2, 5, new ArrayList<>(), new ArrayList<>(),
                new Puesto[2][5]);
        parqueadero.agregarVehiculo(vehiculo1);
        parqueadero.agregarVehiculo(vehiculo2);

        assertTrue(parqueadero.existeVehiculo("ABC123"));
        assertFalse(parqueadero.existeVehiculo("XYZ789"));
    }

    @Test
    public void testFiltrarPorDia() {

        LocalDateTime fecha = LocalDateTime.of(2024, 5, 21, 0, 0);
        Factura factura1 = new Factura(fecha, fecha, 0, 0, 0, fecha, null);
        Factura factura2 = new Factura(fecha, fecha, 0, 0, 0, fecha, null);

        Parqueadero parqueadero = new Parqueadero("Prueba", 10, 2, 5, new ArrayList<>(), new ArrayList<>(),
                new Puesto[2][5]);
        parqueadero.agregarFactura(factura1);
        parqueadero.agregarFactura(factura2);

        List<Factura> facturasFiltradas = parqueadero.filtrarPorDia(fecha);
        assertEquals(1, facturasFiltradas.size());
    }

    @BeforeEach
    void setUp() {
        parqueadero = new Parqueadero("Prueba", 10, 2, 5, new ArrayList<>(), new ArrayList<>(), new Puesto[2][5]);
        vehiculo = mock(Vehiculo.class);
        puestoSimulado = new Puesto[2][5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                puestoSimulado[i][j] = mock(Puesto.class);
            }
        }
        parqueadero.setPuesto(puestoSimulado);
    }

    @Test
    void testSetUp() {
        assertEquals("Prueba", parqueadero.getNombre(), "El nombre debe coincidir");
        assertEquals(10, parqueadero.getCantPuestos(), "La cantidad de puestos debe coincidir");
        assertEquals(2, parqueadero.getFilas(), "El número de filas debe coincidir");
        assertEquals(5, parqueadero.getColumnas(), "El número de columnas debe coincidir");
        assertNotNull(parqueadero.getListaVehiculos(), "La lista de vehículos no debe ser nula");
        assertNotNull(parqueadero.getListaFacturas(), "La lista de facturas no debe ser nula");
        assertSame(puestoSimulado, parqueadero.getPuesto(), "La matriz de puestos debe ser la misma");
    }

    @Test
    void testEstacionarVehiculoConPuestoDisponible() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                puestoSimulado[i][j].setEstado(false);
            }
        }

        parqueadero.estacionarVehiculo(vehiculo);

        verify(vehiculo).setPlaca(anyString());

    }

    @Test
    void testEstacionarVehiculoSinPuestosDisponibles() {
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                puestoSimulado[i][j].setEstado(true); 
            }
        }

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(parqueadero, times(1)).printMessage(captor.capture());

        assertEquals("Todos los puestos del parqueadero están ocupados", captor.getValue());
    }

    @Test
    void testAgregarVehiculoDuplicado() {
       
        Vehiculo vehiculoDuplicado = new Vehiculo("ABC123", "Toyota", "Carlos");
        parqueadero.agregarVehiculo(vehiculoDuplicado);

        assertThrows(IllegalArgumentException.class, () -> parqueadero.agregarVehiculo(vehiculoDuplicado));
    }

}
