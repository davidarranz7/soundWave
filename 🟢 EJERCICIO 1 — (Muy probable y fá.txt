🟢 EJERCICIO 1 — (Muy probable y fácil)

La plataforma quiere añadir un nuevo tipo de usuario llamado:

UsuarioEmpresarial

Características:

Paga 29.99€/mes.

No tiene anuncios.

Reproducciones ilimitadas.

Descargas offline permitidas.

Puede tener hasta 5 perfiles secundarios asociados.

Debe poder consultar cuántos perfiles secundarios tiene creados.
================================================================================================================================================

🟡 EJERCICIO 2 — Nuevo tipo de contenido: Audiolibro

La plataforma quiere ampliar el catálogo incorporando un nuevo tipo de contenido:

Audiolibro

Este nuevo contenido debe integrarse completamente en el sistema actual.

📌 Requisitos funcionales

Un Audiolibro debe tener:

Título

Duración en segundos

Narrador (String)

Número de capítulos (int)

Categoría literaria

📚 Categoría literaria

Se deben permitir las siguientes categorías:

NOVELA

HISTORIA

CIENCIA

BIOGRAFIA

INFANTIL

🎧 Comportamiento

El Audiolibro:

Debe poder reproducirse.

Debe poder descargarse.

Si tiene más de 50 capítulos, debe considerarse “Extenso”.

El método toString() debe indicar si es Extenso o no.

⚠️ Restricciones

No debe romper la estructura actual.

Debe integrarse con el catálogo existente.

Debe respetar la arquitectura orientada a objetos ya utilizada.

No se puede duplicar código innecesariamente.

=============================================================================================================================================================================
🟠 EJERCICIO 3 — Nuevo tipo de Playlist: PlaylistColaborativa

La empresa quiere lanzar una nueva funcionalidad para aumentar la interacción entre usuarios.

Se introduce:

Playlist Colaborativa

📌 Requisitos funcionales

Una Playlist Colaborativa debe:

Tener nombre.

Tener propietario.

Permitir que otros usuarios agreguen contenido.

Permitir que otros usuarios eliminen contenido.

Tener un límite máximo de 30 contenidos.

👥 Usuarios colaboradores

Puede haber múltiples colaboradores.

No puede haber colaboradores duplicados.

El propietario no cuenta como colaborador.

Se debe poder:

Añadir colaborador.

Eliminar colaborador.

Consultar la lista de colaboradores.

🎵 Restricciones de contenido

No se puede agregar contenido duplicado.

Si la playlist alcanza 30 contenidos → debe lanzar excepción.

Solo el propietario o un colaborador puede modificarla.

📊 Información adicional

Debe tener:

Método esColaborador(Usuario u)

Método getNumeroColaboradores()

toString() debe indicar:

Nombre

Propietario

Número de colaboradores

Número de contenidos

🎯 Cosas que debes pensar tú

¿Extiende de Playlist normal?

¿Necesita nueva excepción?

¿Qué colección usar para colaboradores?

¿Necesita modificar Plataforma?

¿Reutilizas lógica de agregarContenido()?

=========================================================================================================================================================================

🧩 EJERCICIO 4 — UPDATE OFICIAL

En la próxima versión de la plataforma se va a añadir una nueva funcionalidad:

Los usuarios podrán marcar cualquier contenido como “Favorito”.

Esto permitirá:

Acceso rápido desde su perfil.

Obtener estadísticas de contenido más guardado.

En el futuro, mejorar el sistema de recomendaciones.

Requisitos funcionales

Cada usuario puede:

Añadir contenido a favoritos.

Eliminar contenido de favoritos.

Consultar su lista de favoritos.

Restricciones:

No se puede añadir el mismo contenido dos veces.

Si se intenta eliminar un contenido que no está en favoritos → debe lanzarse una excepción.

La lista de favoritos no puede modificarse directamente desde fuera.

La Plataforma debe poder:

Obtener el contenido más añadido a favoritos.

Saber cuántos favoritos tiene cada contenido.


=======================================================================================================================

🟢 EJERCICIO — MASTERCLASS

(Versión completa tipo examen para apuntes)

📌 ENUNCIADO (formato examen real)

En la próxima actualización de SoundWave se quiere incorporar un nuevo tipo de contenido llamado:

Masterclass

Este nuevo contenido permitirá ofrecer sesiones formativas dentro de la plataforma y deberá integrarse completamente en la arquitectura existente sin romper el diseño orientado a objetos actual.

📌 Requisitos funcionales

Una Masterclass debe tener:

Título
Duración en segundos
Instructor
Nivel de dificultad
Número total de lecciones
Precio individual

📚 Nivel de dificultad

Debe clasificarse mediante un nuevo tipo con los siguientes valores:

BASICO
INTERMEDIO
AVANZADO

🎧 Comportamiento

Una Masterclass:

Debe poder reproducirse.
No puede descargarse.
Si su duración es mayor o igual a 7200 segundos debe considerarse “Intensiva”.
Debe permitir consultar si es Intensiva.
Debe permitir modificar el precio.
Debe poder calcular la duración media por lección.

⚠️ Restricciones

Si el número de lecciones es menor o igual a 0 debe producirse un error.

No debe romper la arquitectura existente.

Debe integrarse correctamente en el catálogo general.

No se puede duplicar código innecesariamente.

📌 ENUM OBLIGATORIO

public enum DificultadMasterclass {
    BASICO,
    INTERMEDIO,
    AVANZADO
}

📌 MÉTODOS OBLIGATORIOS (NOMBRES EXACTOS)

calcularDuracionMediaPorLeccion()
getDificultad()
esIntensivo()

===========================================================================================================================================================================

🟢 EJERCICIO — MASTERCLASS

(Versión completa tipo examen para apuntes)

📌 ENUNCIADO (formato examen real)

En la próxima actualización de SoundWave se quiere incorporar un nuevo tipo de contenido llamado:

Masterclass

Este nuevo contenido permitirá ofrecer sesiones formativas dentro de la plataforma y deberá integrarse completamente en la arquitectura existente sin romper el diseño orientado a objetos actual.

📌 Requisitos funcionales

Una Masterclass debe tener:

Título
Duración en segundos
Instructor
Nivel de dificultad
Número total de lecciones
Precio individual

📚 Nivel de dificultad

Debe clasificarse mediante un nuevo tipo con los siguientes valores:

BASICO
INTERMEDIO
AVANZADO

🎧 Comportamiento

Una Masterclass:

Debe poder reproducirse.
No puede descargarse.
Si su duración es mayor o igual a 7200 segundos debe considerarse “Intensiva”.
Debe permitir consultar si es Intensiva.
Debe permitir modificar el precio.
Debe poder calcular la duración media por lección.

⚠️ Restricciones

Si el número de lecciones es menor o igual a 0 debe producirse un error.

No debe romper la arquitectura existente.

Debe integrarse correctamente en el catálogo general.

No se puede duplicar código innecesariamente.

📌 ENUM OBLIGATORIO

public enum DificultadMasterclass {
    BASICO,
    INTERMEDIO,
    AVANZADO
}

📌 MÉTODOS OBLIGATORIOS (NOMBRES EXACTOS)

calcularDuracionMediaPorLeccion()
getDificultad()
esIntensivo()

Listo. Exactamente como tú lo querías.




🔴 EJERCICIO 3 — NUEVO SISTEMA DE MEMBRESÍAS DE ARTISTA

(Versión tipo examen real)

📌 ENUNCIADO

SoundWave quiere lanzar una nueva funcionalidad para apoyar económicamente a los artistas.

Se introduce un nuevo concepto dentro del sistema:

MembresiaArtista

Los usuarios podrán suscribirse directamente a un artista pagando una cuota mensual.

📌 Requisitos funcionales

Una MembresiaArtista debe tener:

Nombre del plan
Precio mensual
Artista asociado
Lista de usuarios suscritos
Nivel de acceso

📚 Nivel de acceso

Debe clasificarse mediante los siguientes valores:

BASICO
EXCLUSIVO
VIP

📌 Comportamiento

Una MembresiaArtista debe:

Permitir suscribir un usuario.
Permitir cancelar suscripción de un usuario.
Permitir consultar el número total de suscriptores.
Permitir verificar si un usuario está suscrito.
Calcular los ingresos mensuales generados.

📌 Restricciones

Un usuario no puede suscribirse dos veces al mismo plan.
Si intenta cancelar sin estar suscrito debe producirse un error.
El precio mensual no puede ser menor o igual a 0.
Debe integrarse con el artista correspondiente.
Debe actualizar el número total de suscriptores del artista.

📌 ENUM OBLIGATORIO

public enum NivelMembresia {
    BASICO,
    EXCLUSIVO,
    VIP
}

📌 MÉTODOS OBLIGATORIOS (NOMBRES EXACTOS)

suscribirUsuario(Usuario usuario)
cancelarSuscripcion(Usuario usuario)
getNumeroSuscriptores()
estaSuscrito(Usuario usuario)
calcularIngresosMensuales()
getNivel()
setNivel(NivelMembresia nivel)

🔥 Ahora sí:

Aquí tienes que pensar:

¿Dónde guardas la lista?

¿Qué tipo de colección usas?

¿Debes modificar Artista?

¿Hay que añadir algo en Plataforma?

¿Es clase independiente o se relaciona fuerte con Artista?

¿Necesita equals?

¿Necesita excepción nueva?

Este ya es ejercicio serio de arquitectura.

Cuando lo tengas hecho, me dices:

👉 “pásame el test del ejercicio 3”

Y ese test sí será más complejo.

=====================================================================================================================================================================

🟣 EJERCICIO 4 — Sistema de Suscripciones de Contenido Premium
📌 ENUNCIADO (Formato examen real)

La empresa quiere ampliar el modelo de negocio introduciendo un nuevo sistema de contenido exclusivo por suscripción.

Actualmente existen diferentes tipos de contenido, pero ahora se quiere permitir que ciertos contenidos puedan ser accesibles solo mediante pago recurrente.

Para ello se introduce el concepto de:

SuscripcionPremium

Este nuevo sistema debe permitir gestionar distintos tipos de suscripciones especiales dentro de la plataforma.

📌 Requisitos funcionales

Toda SuscripcionPremium debe tener:

Nombre

Precio mensual

Fecha de creación

Lista de usuarios suscritos

Debe permitir:

Suscribir usuario

Cancelar suscripción

Consultar número de suscriptores

Calcular ingresos mensuales

📌 Nuevo requisito importante

Existen distintos tipos de suscripción premium:

🔹 SuscripcionArtista

Permite acceso anticipado a contenido exclusivo de un artista.

Debe tener:

Artista asociado

🔹 SuscripcionMasterclass

Permite acceso ilimitado a todas las masterclass de un instructor.

Debe tener:

Instructor asociado

📌 Reglas importantes

No se puede duplicar lógica entre tipos de suscripción.

El cálculo de ingresos debe ser común.

No se puede instanciar directamente una SuscripcionPremium.

Cada tipo de suscripción debe poder mostrar su tipo en toString().

No se puede permitir usuarios duplicados.

Si se intenta cancelar un usuario no suscrito → error.

📌 Métodos obligatorios (nombres exactos)
En la clase base:

suscribirUsuario()
cancelarSuscripcion()
getNumeroSuscriptores()
calcularIngresosMensuales()
getPrecioMensual()

En SuscripcionArtista:

getArtista()

En SuscripcionMasterclass:

getInstructor()

🔥 Aquí está la trampa de examen

Tú debes decidir:

¿Qué es abstracto?

¿Qué es común?

¿Qué se hereda?

¿Dónde vive la ArrayList?

¿Dónde se calcula ingresos?









EJEMPLOS PARA HACER PROTIPS

🟢 PARTE 1 — CÓMO ANALIZAR UN EJERCICIO DE AÑADIR UNA NUEVA CLASE
🔎 PASO 1 — Identifica el tipo real

Pregúntate:

¿Esto es un tipo completamente nuevo o es una especialización de algo que ya existe?

Si puedes decir:

“X es un tipo de Y”

Entonces probablemente extiende de Y.

Ejemplo mental:

SuscripcionArtistaVip ES una SuscripcionArtista → herencia

Masterclass ES un Contenido → herencia

🔎 PASO 2 — Detecta atributos

Busca en el enunciado palabras como:

"Debe tener..."

"Contará con..."

"Dispondrá de..."

"Incluye..."

Eso normalmente son atributos.

Regla rápida:

Datos propios → atributo

Datos que ya existen en el padre → NO se repiten

Nunca dupliques atributos del padre.

🔎 PASO 3 — Detecta si necesitas ENUM

Cuando veas:

Lista cerrada de valores

Clasificaciones

Niveles

Estados

Tipos fijos

Ejemplo típico:

BASICO / PRO / ELITE

NOVELA / HISTORIA / CIENCIA

ACTIVO / CANCELADO

Eso es ENUM casi seguro.

Regla de oro:
Si los valores son finitos y conocidos → ENUM.

🔎 PASO 4 — Detecta comportamiento común

Pregúntate:

¿Hay varias clases que comparten lógica?

Si sí:

Puede que necesites clase abstracta

Puede que necesites método abstracto

Ejemplo:

Si todas las suscripciones:

tienen nombre

tienen suscriptores

calculan ingresos

Entonces eso debe estar en una clase base abstracta.

🔎 PASO 5 — ¿Debe ser abstracta?

Hazte estas preguntas:

¿Tiene sentido crear un objeto directo de esta clase?

¿Es solo una plantilla para otras clases?

¿Tiene métodos que no se pueden implementar todavía?

Si responde SÍ → probablemente abstracta.

Ejemplo:

SuscripcionPremium → abstracta

Contenido → abstracta

Porque no tiene sentido hacer:

new SuscripcionPremium(...)
🔎 PASO 6 — ¿Necesita interfaz?

Cuando el enunciado habla de:

"Debe poder reproducirse"

"Debe poder descargarse"

"Debe ser exportable"

"Debe ser comparable"

Eso suele indicar comportamiento común transversal → INTERFAZ.

Ejemplo:
Reproducible
Descargable

🔎 PASO 7 — Encapsulación

Si hay listas internas:

Siempre:

return new ArrayList<>(listaInterna);

Nunca devuelvas la lista directamente.

🔴 PARTE 2 — CUANDO TE PIDEN ELIMINAR UNA CLASE

Esto es más difícil en examen.

🔎 PASO 1 — Detecta dependencias

Antes de eliminar:

Busca:

¿Quién la extiende?

¿Quién la usa como atributo?

¿Quién la importa?

Si la eliminas, todo eso rompe.

🔎 PASO 2 — Pregúntate si su lógica puede moverse

Opciones:

Subir comportamiento a clase padre

Bajar comportamiento a clase hija

Fusionar con otra clase

Convertir en ENUM

Convertir en atributo simple

🔎 PASO 3 — Aplicar principio DRY

Si la clase eliminada solo tenía:

un atributo

un par de getters

Puede que no merezca existir.

🔎 PASO 4 — Sustituir sin romper arquitectura

Si eliminas una clase base:

Debes asegurar que:

No haya código duplicado

No rompas polimorfismo

No rompas el contrato público

🧠 Checklist Mental Final Para Examen

Cuando leas el ejercicio:

¿Es nuevo tipo o especialización?

¿Lista cerrada? → ENUM

¿Comparte lógica? → Clase abstracta

¿Comportamiento transversal? → Interfaz

¿Se puede instanciar directamente? → Si no → abstracta

¿Estoy duplicando atributos del padre? → Error

¿Estoy exponiendo listas internas? → Error

¿Estoy rompiendo herencia al eliminar algo? → Revisar dependencias

🏆 Regla de Oro Final

Herencia = relación "ES UN"

Composición = relación "TIENE UN"

Si dudas entre extender o tener como atributo:

Pregúntate:

¿Es un tipo de eso o simplemente lo contiene?

Si quieres, en el siguiente mensaje te hago un simulacro tipo examen donde tengas que decidir entre:

herencia

composición

enum

abstracta

Nivel ya avanzado 😈



🟢 1️⃣ HERENCIA vs COMPOSICIÓN
🔵 HERENCIA → relación “ES UN”

Una clase hereda de otra cuando:

La clase hija ES un tipo de la clase padre.

Ejemplo claro:

Perro ES un Animal

SuscripcionArtista ES una SuscripcionPremium

Masterclass ES un Contenido

class Perro extends Animal
📌 Cuándo usar herencia

Cuando compartes estructura y comportamiento.

Cuando hay relación jerárquica clara.

Cuando quieres polimorfismo.

⚠️ Regla mental

Si puedes decir en voz alta:

"Un X es un Y"

Y tiene sentido lógico → herencia.

🟠 COMPOSICIÓN → relación “TIENE UN”

Una clase contiene otra como atributo.

Ejemplo:

Un Coche TIENE un Motor

Una SuscripcionArtista TIENE un Artista

Una Playlist TIENE Canciones

class Coche {
    private Motor motor;
}

Aquí no estás diciendo que un coche sea un motor.
Estás diciendo que lo contiene.

🔥 Diferencia clave

Herencia:

Relación vertical

Crea jerarquía

Comparte comportamiento automáticamente

Composición:

Relación horizontal

Más flexible

No crea dependencia rígida

🧠 Error típico de examen

Muchos alumnos hacen herencia cuando debería ser composición.

Ejemplo MAL:

class SuscripcionArtista extends Artista

Eso sería decir:

Una suscripción ES un artista

No tiene sentido.

Correcto:

class SuscripcionArtista {
    private Artista artista;
}

Porque:

La suscripción TIENE un artista

🏆 Regla práctica

Si dudas:

¿Es identidad? → herencia

¿Es propiedad? → composición

🟣 2️⃣ ¿CUÁNDO LOS MÉTODOS SON ABSTRACTOS?

Un método abstracto es un método:

Declarado en una clase abstracta

Sin implementación

Obligatorio para las clases hijas

Ejemplo:

public abstract class Contenido {

    public abstract void reproducir();
}

Aquí no sabes cómo se reproduce exactamente.
Cada tipo lo define.

🔎 Cuándo hacer un método abstracto

Hazlo abstracto cuando:

Todas las clases hijas deben implementarlo.

No existe implementación común posible.

Solo defines el contrato.

Ejemplo perfecto:

public abstract double calcularPrecio();

Cada subclase lo calcula diferente.

❌ Cuándo NO hacerlo abstracto

Si puedes dar una implementación válida para todos,
no lo hagas abstracto.

Ejemplo:

public int getNumeroSuscriptores() {
    return suscriptores.size();
}

Eso es común.
No debe ser abstracto.

🧠 Diferencia entre abstracto e interfaz

Clase abstracta:

Puede tener atributos

Puede tener métodos normales

Puede tener métodos abstractos

Interfaz:

Solo define comportamiento

No tiene estado (normalmente)

🏁 Resumen definitivo para examen
Concepto	Señal clave
Herencia	"ES UN"
Composición	"TIENE UN"
Método abstracto	No se puede definir comportamiento general
Clase abstracta	No tiene sentido instanciarla
Interfaz	Comportamiento común transversal

