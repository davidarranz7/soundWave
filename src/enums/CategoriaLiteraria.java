package enums;

public enum CategoriaLiteraria {
    NOVELA("Novela", "Obra literaria en prosa, generalmente extensa, que narra hechos imaginarios o reales."),
    HISTORIA("Historia", "Relato de hechos reales o ficticios, generalmente en prosa, que se desarrolla en un tiempo y lugar determinados."),
    CIENCIA("Ciencia", "Conjunto de conocimientos sistemáticamente organizados que se obtienen mediante la observación y el razonamiento, y que se pueden verificar experimentalmente."),
    BIOGRAFIA("Biografía", "Relato de la vida de una persona, escrito por otra persona."),
    INFANTIL("Infantil", "Obra literaria destinada a los niños, que puede incluir cuentos, fábulas, poesía, entre otros géneros.");

    private String descripcion;
    private  String nombre;

    CategoriaLiteraria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
