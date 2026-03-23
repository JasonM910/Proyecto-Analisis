// Tipos de entrada que se prueban en los algoritmos
public enum TipoEntrada {
    ORDENADO("ordenado"),
    INVERSO("inverso"),
    ALEATORIO("aleatorio"),
    ALEATORIO_CON_REPETIDOS("aleatorio_10_repetidos");

    private final String etiqueta;

    // Guarda la etiqueta que se imprime en consola
    TipoEntrada(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    // Devuelve el texto del tipo de entrada
    public String obtenerEtiqueta() {
        return etiqueta;
    }
}
