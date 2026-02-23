import static org.junit.jupiter.api.Assertions.*;

import enums.TematicaDocumental;
import excepciones.contenido.DuracionInvalidaException;
import modelo.contenido.Documental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;

public class DocumentalTest {

    private Documental documentalNormal;
    private Documental documentalLargo;

    @BeforeEach
    void setUp() throws DuracionInvalidaException {

        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.JANUARY, 1);
        Date fecha2015 = cal.getTime();

        documentalNormal = new Documental(
                "Planeta Tierra",
                3600,
                "David Attenborough",
                TematicaDocumental.NATURALEZA,
                fecha2015,
                true
        );

        documentalLargo = new Documental(
                "Historia Completa del Universo",
                6000,
                "Carl Sagan",
                TematicaDocumental.CIENCIA,
                fecha2015,
                false
        );
    }

    @Test
    void testEsLargo() {
        assertEquals("NO", documentalNormal.esLargo());
        assertEquals("SI", documentalLargo.esLargo());
    }

    @Test
    void testGetTematica() {
        assertEquals(TematicaDocumental.NATURALEZA, documentalNormal.getTematica());
    }

    @Test
    void testSetTematica() {
        documentalNormal.setTematica(TematicaDocumental.HISTORIA);
        assertEquals(TematicaDocumental.HISTORIA, documentalNormal.getTematica());
    }

    @Test
    void testCalcularAntiguedad() {
        int antiguedad = documentalNormal.calcularAntiguedad();
        assertTrue(antiguedad >= 0);
    }

    @Test
    void testFechaFuturaLanzaError() {

        Calendar cal = Calendar.getInstance();
        cal.set(3000, Calendar.JANUARY, 1);
        Date fechaFutura = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Documental(
                    "Documental Futuro",
                    4000,
                    "Director X",
                    TematicaDocumental.TECNOLOGIA,
                    fechaFutura,
                    true
            );
        });
    }
}