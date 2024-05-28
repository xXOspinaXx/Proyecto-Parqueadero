
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotoTest {

    @Test
    void testConstructorConValidVelMax() {
        Moto moto = new Moto("XYZ78G", "Yamaha R1", "Carlos Gomez", 180.0);
        assertEquals("XYZ789", moto.getPlaca());
        assertEquals("Yamaha R1", moto.getModelo());
        assertEquals("Carlos Gomez", moto.getPropietario());
        assertEquals(180.0, moto.Velmax(), 0.01); 
    }

    @Test
    void testConstructorConInvalidVelMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Moto("ABC12D", "Suzuki GSX-R", "Ana Martinez", 0.0);
        });
    }

    @Test
    void testVelmax() {
        Moto moto = new Moto("DEF45G", "Kawasaki Z650", "Pedro Lopez", 150.5);
        assertEquals(150.5, moto.Velmax(), 0.01); 
    }
}