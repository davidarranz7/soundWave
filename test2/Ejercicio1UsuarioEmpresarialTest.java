import enums.TipoSuscripcion;
import modelo.plataforma.Plataforma;
import modelo.usuarios.UsuarioEmpresarial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Ejercicio1UsuarioEmpresarialTest {

    private static Plataforma plataforma;

    @BeforeAll
    static void setUp() {
        Plataforma.reiniciarInstancia();
        plataforma = Plataforma.getInstancia("Test Empresarial");
    }

    @Test
    @Order(1)
    @DisplayName("1.1 - Crear UsuarioEmpresarial correctamente")
    void testCrearUsuarioEmpresarial() throws Exception {

        UsuarioEmpresarial user = new UsuarioEmpresarial(
                "Empresa", "empresa@test.com", "password123");

        assertNotNull(user);
        assertEquals(TipoSuscripcion.EMPRESARIAL, user.getSuscripcion());
        assertEquals(29.99, user.getSuscripcion().getPrecioMensual());
    }

    @Test
    @Order(2)
    @DisplayName("1.2 - Debe permitir hasta 5 perfiles secundarios")
    void testLimitePerfilesSecundarios() throws Exception {

        UsuarioEmpresarial user = new UsuarioEmpresarial(
                "Empresa2", "empresa2@test.com", "password123");

        for (int i = 0; i < 5; i++) {
            user.agregarPerfilSecundario("Perfil " + i);
        }

        assertEquals(5, user.getNumeroPerfilesSecundarios());
    }
}