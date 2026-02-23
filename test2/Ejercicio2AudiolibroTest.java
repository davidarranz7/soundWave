import enums.CategoriaLiteraria;
import excepciones.contenido.DuracionInvalidaException;
import modelo.contenido.Audiolibro;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio2AudiolibroTest {

    // ==============================
    // TEST 1 - Creación básica
    // ==============================

    @Test
    @DisplayName("2.1 - Crear Audiolibro correctamente")
    void testCrearAudiolibro() throws DuracionInvalidaException {

        Audiolibro libro = new Audiolibro(
                "El Quijote",
                7200,
                "Carlos Narrador",
                60,
                CategoriaLiteraria.NOVELA
        );

        assertNotNull(libro);
        assertEquals("Carlos Narrador", libro.getNarrador());
        assertEquals(60, libro.getNumeroCapitulos());
        assertEquals(CategoriaLiteraria.NOVELA, libro.getCategoria());
    }

    // ==============================
    // TEST 2 - Libro Extenso
    // ==============================

    @Test
    @DisplayName("2.2 - Audiolibro con más de 50 capítulos es Extenso")
    void testAudiolibroExtenso() throws DuracionInvalidaException {

        Audiolibro libro = new Audiolibro(
                "Historia Completa",
                10000,
                "Narrador Test",
                80,
                CategoriaLiteraria.HISTORIA
        );

        assertTrue(libro.esExtenso());
    }

    // ==============================
    // TEST 3 - Libro NO Extenso
    // ==============================

    @Test
    @DisplayName("2.3 - Audiolibro con menos de 50 capítulos NO es Extenso")
    void testAudiolibroNoExtenso() throws DuracionInvalidaException {

        Audiolibro libro = new Audiolibro(
                "Libro Corto",
                4000,
                "Narrador Test",
                20,
                CategoriaLiteraria.CIENCIA
        );

        assertFalse(libro.esExtenso());
    }

    // ==============================
    // TEST 4 - toString debe indicar Extenso
    // ==============================

    @Test
    @DisplayName("2.4 - toString debe indicar si es Extenso")
    void testToStringIncluyeExtenso() throws DuracionInvalidaException {

        Audiolibro libro = new Audiolibro(
                "Gran Saga",
                15000,
                "Narrador",
                70,
                CategoriaLiteraria.NOVELA
        );

        assertTrue(libro.toString().contains("Extenso"));
    }

    // ==============================
    // TEST 5 - Duración inválida
    // ==============================

    @Test
    @DisplayName("2.5 - Duración inválida debe lanzar excepción")
    void testDuracionInvalida() {

        assertThrows(DuracionInvalidaException.class, () -> {
            new Audiolibro(
                    "Error",
                    -100,
                    "Narrador",
                    10,
                    CategoriaLiteraria.INFANTIL
            );
        });
    }
}