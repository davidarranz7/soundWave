import static org.junit.jupiter.api.Assertions.*;

import enums.NivelMembresia;
import modelo.artistas.Artista;
import modelo.artistas.MembresiaArtista;
import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioPremium;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MembresiaArtistaTest {

    private MembresiaArtista membresia;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() throws EmailInvalidoException, PasswordDebilException {

        Artista artista = new Artista("Coldplay", "Chris Martin", "UK");

        membresia = new MembresiaArtista(
                "Fan Club Oficial",
                artista,
                NivelMembresia.EXCLUSIVO
        );

        usuario1 = new UsuarioPremium("David", "david@test.com", "password123");
        usuario2 = new UsuarioPremium("Laura", "laura@test.com", "password123");
    }

    @Test
    void testSuscribirUsuario() {
        membresia.suscribirUsuario(usuario1);

        assertTrue(membresia.estaSuscrito(usuario1));
        assertEquals(1, membresia.getNumeroSuscriptores());
    }

    @Test
    void testNoPermiteSuscripcionDuplicada() {
        membresia.suscribirUsuario(usuario1);

        assertThrows(IllegalArgumentException.class, () -> {
            membresia.suscribirUsuario(usuario1);
        });
    }

    @Test
    void testCancelarSuscripcion() {
        membresia.suscribirUsuario(usuario1);
        membresia.cancelarSuscripcion(usuario1);

        assertFalse(membresia.estaSuscrito(usuario1));
        assertEquals(0, membresia.getNumeroSuscriptores());
    }

    @Test
    void testCancelarSinEstarSuscritoLanzaError() {
        assertThrows(IllegalArgumentException.class, () -> {
            membresia.cancelarSuscripcion(usuario1);
        });
    }

    @Test
    void testCalcularIngresosMensuales() {
        membresia.suscribirUsuario(usuario1);
        membresia.suscribirUsuario(usuario2);

        double ingresosEsperados = 2 * NivelMembresia.EXCLUSIVO.getPrecioMensual();

        assertEquals(ingresosEsperados, membresia.calcularIngresosMensuales());
    }

    @Test
    void testCambiarNivel() {
        membresia.setNivel(NivelMembresia.VIP);

        assertEquals(NivelMembresia.VIP, membresia.getNivel());
    }
}