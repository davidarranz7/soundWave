import excepciones.playlist.ContenidoDuplicadoException;
import modelo.plataforma.Plataforma;
import modelo.plataforma.PlaylistColaborativa;
import modelo.usuarios.Usuario;
import modelo.contenido.Cancion;
import enums.GeneroMusical;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Ejercicio3PlaylistColaborativaTest {

    private static Plataforma plataforma;
    private static Usuario owner;
    private static Usuario colaborador;

    @BeforeAll
    static void setup() throws Exception {
        Plataforma.reiniciarInstancia();
        plataforma = Plataforma.getInstancia("Test");

        owner = plataforma.registrarUsuarioPremium(
                "Owner", "owner@test.com", "password123");

        colaborador = plataforma.registrarUsuarioPremium(
                "Colab", "colab@test.com", "password123");
    }

    @AfterAll
    static void tearDown() {
        Plataforma.reiniciarInstancia();
    }

    // ==============================
    // TEST 1 - Creación básica
    // ==============================

    @Test
    @Order(1)
    void testCrearPlaylist() {

        PlaylistColaborativa playlist =
                new PlaylistColaborativa("Mix", owner);

        assertNotNull(playlist);
        assertEquals("Mix", playlist.getNombre());
        assertEquals(owner, playlist.getPropietario());
        assertEquals(0, playlist.getNumeroColaboradores());
    }

    // ==============================
    // TEST 2 - Agregar colaborador
    // ==============================

    @Test
    @Order(2)
    void testAgregarColaborador() {

        PlaylistColaborativa playlist =
                new PlaylistColaborativa("Test", owner);

        playlist.agregarColaborador(colaborador);

        assertTrue(playlist.esColaborador(colaborador));
        assertEquals(1, playlist.getNumeroColaboradores());
    }

    // ==============================
    // TEST 3 - Límite máximo 30 colaboradores
    // ==============================

    @Test
    @Order(3)
    void testLimiteColaboradores() throws Exception {

        PlaylistColaborativa playlist =
                new PlaylistColaborativa("Test", owner);

        for (int i = 0; i < 30; i++) {
            Usuario u = plataforma.registrarUsuarioPremium(
                    "User" + i,
                    "user" + i + "@test.com",
                    "password123"
            );
            playlist.agregarColaborador(u);
        }

        Usuario extra = plataforma.registrarUsuarioPremium(
                "Extra", "extra@test.com", "password123");

        playlist.agregarColaborador(extra);

        // No debe superar 30
        assertEquals(30, playlist.getNumeroColaboradores());
    }

    // ==============================
    // TEST 4 - No permitir duplicados
    // ==============================

    @Test
    @Order(4)
    void testContenidoDuplicado() throws Exception {

        PlaylistColaborativa playlist =
                new PlaylistColaborativa("Test", owner);

        Cancion c = new Cancion("Song", 200, GeneroMusical.POP);

        playlist.agregarContenido(c, owner);

        assertThrows(ContenidoDuplicadoException.class, () -> {
            playlist.agregarContenido(c, owner);
        });
    }

    // ==============================
    // TEST 5 - Control de permisos
    // ==============================

    @Test
    @Order(5)
    void testPermisos() throws Exception {

        PlaylistColaborativa playlist =
                new PlaylistColaborativa("Test", owner);

        Usuario otro =
                plataforma.registrarUsuarioPremium(
                        "Otro", "otro@test.com", "password123");

        Cancion c = new Cancion("Song", 200, GeneroMusical.POP);

        assertThrows(SecurityException.class, () -> {
            playlist.agregarContenido(c, otro);
        });
    }
}