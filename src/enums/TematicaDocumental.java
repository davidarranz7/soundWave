package enums;

public enum TematicaDocumental {

    NATURALEZA("Contenidos relacionados con la naturaleza, el medio ambiente y la vida silvestre."),
    CIENCIA("Contenidos relacionados con la ciencia, la tecnología y el conocimiento científico."),
    HISTORIA("Contenidos relacionados con la historia, los eventos históricos y las civilizaciones."),
    SOCIEDAD("Contenidos relacionados con la sociedad, la cultura y las relaciones humanas."),
    TECNOLOGIA("Contenidos relacionados con la tecnología, la innovación y el desarrollo tecnológico.");

    private String descripcion;

    TematicaDocumental(String descripcion) {
        this.descripcion = descripcion;
    }
}
