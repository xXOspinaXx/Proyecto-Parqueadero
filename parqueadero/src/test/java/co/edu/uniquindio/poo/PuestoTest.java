package co.edu.uniquindio.poo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuestoTest {
    
    @Test
    void testInicializacion() {
        Puesto puesto = new Puesto(10, 20);
        assertEquals(10, puesto.getColumnas());
        assertEquals(20, puesto.getFilas());
    }

    @Test
    void testAccesoAPropiedades() {
        Puesto puesto = new Puesto(0, 0);
        assertFalse(puesto.isEstado());

        puesto.setEstado(true);
        assertTrue(puesto.isEstado());
    }

    @Test
    void testManejoDeListasDeVehiculos() {
        Vehiculo vehiculo = new Vehiculo(); 
        Puesto puesto = new Puesto(0, 0);

        puesto.setListaVehiculos(vehiculo);
        assertEquals(1, puesto.getListaVehiculos().size());
    }

    @Test
    void testOcupacionYLiberacionDePuestos() {
        Puesto puesto = new Puesto(0, 0);
        assertFalse(puesto.isEstado());

        puesto.ocuparPuesto();
        assertTrue(puesto.isEstado());
        assertEquals("Vehículo asignado al puesto.", puesto.toString()); 

        puesto.liberarPuesto();
        assertFalse(puesto.isEstado());
        assertEquals("Vehículo retirado del puesto.", puesto.toString());
    }

    @Test
    void testEstadoDelPuesto() {
        Puesto puesto = new Puesto(0, 0);
        assertFalse(puesto.isEstado());
    }
}
