package co.edu.uniquindio.poo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ClienteTest {


    @Test
    void testConstructor() {
        Cliente cliente = new Cliente("Juan Pérez", "12345", "555-1234");
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("12345", cliente.getId());
        assertEquals("555-1234", cliente.getTelefono());
    }

    @Test
    void testGetters() {
        Cliente cliente = new Cliente("Juan Pérez", "12345", "555-1234");
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("12345", cliente.getId());
        assertEquals("555-1234", cliente.getTelefono());
    }

    @Test
    void testSetters() {
        Cliente cliente = new Cliente("Juan Pérez", "12345", "555-1234");
        cliente.setNombre("Pedro García");
        cliente.setId("67890");
        cliente.setTelefono("666-5678");

        assertEquals("Pedro García", cliente.getNombre());
        assertEquals("67890", cliente.getId());
        assertEquals("666-5678", cliente.getTelefono());
    }
}

