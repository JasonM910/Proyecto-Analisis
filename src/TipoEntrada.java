/**
 * Enum con los tipos de entrada usados en las pruebas de ordenamiento.
 */
public enum TipoEntrada {
    ORDENADO("ordenado"),
    INVERSO("inverso"),
    ALEATORIO("aleatorio"),
    ALEATORIO_CON_REPETIDOS("aleatorio_10_repetidos");

    private final String etiqueta;

    /**
     * Crea un tipo de entrada con su etiqueta de impresion.
     *
     * @param etiqueta texto que se muestra en consola para este tipo
     */
    TipoEntrada(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Obtiene la etiqueta asociada al tipo de entrada.
     *
     * @return etiqueta para reportes en consola
     */
    public String obtenerEtiqueta() {
        return etiqueta;
    }
}
