import static org.junit.jupiter.api.Assertions.*;

import enums.DificultadMasterclass;
import excepciones.contenido.DuracionInvalidaException;
import modelo.contenido.Masterclass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MasterclassTest {

    private Masterclass masterclassNormal;
    private Masterclass masterclassIntensiva;

    @BeforeEach
    void setUp() throws DuracionInvalidaException {
        masterclassNormal = new Masterclass(
                "Java POO",
                3600,
                "David Instructor",
                DificultadMasterclass.INTERMEDIO,
                10,
                49.99
        );

        masterclassIntensiva = new Masterclass(
                "Arquitectura Avanzada",
                8000,
                "Expert Pro",
                DificultadMasterclass.AVANZADO,
                20,
                99.99
        );
    }

    @Test
    void testCreacionCorrecta() {
        assertEquals("Java POO", masterclassNormal.getTitulo());
        assertEquals(3600, masterclassNormal.getDuracionSegundos());
        assertEquals("David Instructor", masterclassNormal.getInstructor());
        assertEquals(10, masterclassNormal.getNumeroLecciones());
        assertEquals(49.99, masterclassNormal.getPrecio());
        assertEquals(DificultadMasterclass.INTERMEDIO, masterclassNormal.getDificultad());
    }

    @Test
    void testEsIntensivo() {
        assertEquals("NO", masterclassNormal.esIntensivo());
        assertEquals("SI", masterclassIntensiva.esIntensivo());
    }

    @Test
    void testDuracionMediaPorLeccion() {
        double media = masterclassNormal.calcularDuracionMediaPorLeccion();
        assertEquals(360.0, media);
    }

    @Test
    void testModificarPrecio() {
        masterclassNormal.setPrecio(59.99);
        assertEquals(59.99, masterclassNormal.getPrecio());
    }

    @Test
    void testNumeroLeccionesInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Masterclass(
                    "Clase Incorrecta",
                    3000,
                    "Instructor",
                    DificultadMasterclass.BASICO,
                    0,
                    29.99
            );
        });
    }

    @Test
    void testNoEsDescargable() {
        assertFalse(masterclassNormal instanceof interfaces.Descargable);
    }
}