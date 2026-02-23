import enums.TipoSuscripcionPremium;
import modelo.artistas.Artista;
import modelo.suscripciones.SuscripcionArtista;
import modelo.suscripciones.SuscripcionMasterclass;
import modelo.suscripciones.SuscripcionPremium;
import modelo.usuarios.UsuarioPremium;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuscripcionPremiumTest {

    @Test
    void testNoSePuedeInstanciarClaseAbstracta() {
        assertTrue(SuscripcionPremium.class.isAssignableFrom(SuscripcionArtista.class));
        assertTrue(SuscripcionPremium.class.isAssignableFrom(SuscripcionMasterclass.class));
    }

    @Test
    void testSuscripcionArtista() throws EmailInvalidoException, PasswordDebilException {

        Artista artista = new Artista("Bad Bunny", "Benito", "PR");
        SuscripcionArtista suscripcion = new SuscripcionArtista(
                "Fans VIP",
                TipoSuscripcionPremium.PRO,
                artista
        );

        UsuarioPremium user1 = new UsuarioPremium("Juan", "juan@test.com", "password123");
        UsuarioPremium user2 = new UsuarioPremium("Maria", "maria@test.com", "password123");

        suscripcion.suscribirUsuario(user1);
        suscripcion.suscribirUsuario(user2);

        assertEquals(2, suscripcion.getNumeroSuscriptores());
        assertTrue(suscripcion.estaSuscrito(user1));
        assertEquals(artista, suscripcion.getArtista());

        double esperado = 2 * TipoSuscripcionPremium.PRO.getPrecioMensual();
        assertEquals(esperado, suscripcion.calcularIngresosMensuales());
    }

    @Test
    void testSuscripcionMasterclass() throws EmailInvalidoException, PasswordDebilException {

        SuscripcionMasterclass suscripcion = new SuscripcionMasterclass(
                "Masterclass Premium",
                TipoSuscripcionPremium.ELITE,
                "Carlos Instructor"
        );

        UsuarioPremium user = new UsuarioPremium("Ana", "ana@test.com", "password123");

        suscripcion.suscribirUsuario(user);

        assertEquals(1, suscripcion.getNumeroSuscriptores());
        assertEquals("Carlos Instructor", suscripcion.getInstructor());

        double esperado = 1 * TipoSuscripcionPremium.ELITE.getPrecioMensual();
        assertEquals(esperado, suscripcion.calcularIngresosMensuales());
    }

    @Test
    void testNoPermiteUsuariosDuplicados() throws EmailInvalidoException, PasswordDebilException {

        Artista artista = new Artista("Shakira", "Shakira", "CO");
        SuscripcionArtista suscripcion = new SuscripcionArtista(
                "Club Oficial",
                TipoSuscripcionPremium.BASICA,
                artista
        );

        UsuarioPremium user = new UsuarioPremium("Pedro", "pedro@test.com", "password123");

        suscripcion.suscribirUsuario(user);

        assertThrows(IllegalArgumentException.class, () ->
                suscripcion.suscribirUsuario(user)
        );
    }

    @Test
    void testCancelarSuscripcion() throws EmailInvalidoException, PasswordDebilException {

        Artista artista = new Artista("Taylor", "Taylor", "USA");
        SuscripcionArtista suscripcion = new SuscripcionArtista(
                "Swifties",
                TipoSuscripcionPremium.PRO,
                artista
        );

        UsuarioPremium user = new UsuarioPremium("Lucia", "lucia@test.com", "password123");

        suscripcion.suscribirUsuario(user);
        suscripcion.cancelarSuscripcion(user);

        assertFalse(suscripcion.estaSuscrito(user));
        assertEquals(0, suscripcion.getNumeroSuscriptores());
    }

    @Test
    void testEncapsulacionListaSuscriptores() throws EmailInvalidoException, PasswordDebilException {

        Artista artista = new Artista("Drake", "Drake", "CA");
        SuscripcionArtista suscripcion = new SuscripcionArtista(
                "Drake Club",
                TipoSuscripcionPremium.PRO,
                artista
        );

        UsuarioPremium user = new UsuarioPremium("Carlos", "carlos@test.com", "password123");

        suscripcion.suscribirUsuario(user);

        var lista = suscripcion.getSuscriptores();
        lista.clear();

        // La lista interna no debe verse afectada
        assertEquals(1, suscripcion.getNumeroSuscriptores());
    }
}