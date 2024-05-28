package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CarroTest {

    @Test
    void testConstructor() {
        Carro carro = new Carro("ABC123", "Toyota Corolla", "Juan Perez", 4);
        assertEquals("ABC123", carro.getPlaca());
        assertEquals("Toyota Corolla", carro.getModelo());
        assertEquals("Juan Perez", carro.getPropietario());
        assertEquals(4, carro.getCantPuertas());
    }

    @Test
    void testGetCantPuertas() {
        Carro carro = new Carro("DEF456", "Honda Civic", "Maria Rodriguez", 2);
        assertEquals(2, carro.getcantPuertas());
    }
}