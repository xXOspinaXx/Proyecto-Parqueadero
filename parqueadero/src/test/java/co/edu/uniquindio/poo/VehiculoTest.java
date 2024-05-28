import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VehiculoTest {

    @Test
    void testConstructor() {
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota Corolla", "Juan Perez");
        assertEquals("ABC123", vehiculo.getPlaca());
        assertEquals("Toyota Corolla", vehiculo.getModelo());
        assertEquals("Juan Perez", vehiculo.getPropietario());
    }

    @Test
    void testGettersAndSetters() {
        Vehiculo vehiculo = new Vehiculo("DEF456", "Honda Civic", "Maria Rodriguez");
        
        
        assertEquals("DEF456", vehiculo.getPlaca());
        assertEquals("Honda Civic", vehiculo.getModelo());
        assertEquals("Maria Rodriguez", vehiculo.getPropietario());
        
        
        vehiculo.setPlaca("GHI789");
        vehiculo.setModelo("Nissan Altima");
        vehiculo.setPropietario("Carlos Gomez");
        
        assertEquals("GHI789", vehiculo.getPlaca());
        assertEquals("Nissan Altima", vehiculo.getModelo());
        assertEquals("Carlos Gomez", vehiculo.getPropietario());
    }
}
