package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
    private Factura factura;
    private Puesto puesto;

    @BeforeEach
    public void setUp() {
        puesto = mock(Puesto.class);
        factura = new Factura( LocalDateTime.now(), LocalDateTime.now().plusHours(1), 100.0, 200.0, 300.0, LocalDateTime.now().minusHours(1), puesto);
    }

    private Puesto mock(Class<Puesto> class1) {
        throw new UnsupportedOperationException();
    }

    @Test
    public void testConstructorValidaPuestoDisponible() {
        
        Puesto puesto = mock(Puesto.class);
        when(puesto.getEstado()).thenReturn(false);
        try {
            Factura factura = new Factura(LocalDateTime.now(), LocalDateTime.now().plusHours(1), 100.0, 200.0, 300.0, LocalDateTime.now().minusHours(1), puesto);
         assertDoesNotThrow(() -> {
                
            });
        } catch (Exception e) {
            
            fail("Se esperaba que la creación de la factura fuera exitosa, pero ocurrió una excepción: " + e.getMessage());
        }
    }

    private Object when(boolean estado) {
       
        throw new UnsupportedOperationException("Unimplemented method 'when'");
    }

    @Test
    public void testGettersSetters() {
        assertEquals(LocalDateTime.now(), factura.getFecha());
        assertEquals(LocalDateTime.now().plusHours(1), factura.getFechaSalida());
        assertEquals(100.0, factura.getTarifaMotoHibrida());
        assertEquals(200.0, factura.getTarifaMotoClasica());
        assertEquals(300.0, factura.getTarifaCarro());
        assertEquals(LocalDateTime.now().minusHours(1), factura.getFechaIngreso());
    }

    @Test
    public void testFraccionParqueado() {
        long horasDiferencia = 2L; 
        double resultadoEsperado = 2.0; 

        double resultadoObtenido = factura.fraccionParqueado(LocalDateTime.now().minusHours(2), LocalDateTime.now());
        assertEquals(resultadoEsperado, resultadoObtenido, "La fracción de tiempo parqueado debe coincidir");
    }

}
