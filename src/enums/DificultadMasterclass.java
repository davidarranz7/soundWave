package enums;

public enum DificultadMasterclass {
    BASICO("Nivel básico, ideal para principiantes."),
    INTERMEDIO("Nivel intermedio, para aquellos con algo de experiencia."),
    AVANZADO("Nivel avanzado, para expertos en la materia.");                                                          ;

    private String descripcion;

    DificultadMasterclass(String descripcion) {
        this.descripcion = descripcion;
    }
}
