public enum TipoEntrada {
    ORDENADO("ordenado"),
    INVERSO("inverso"),
    ALEATORIO("aleatorio"),
    ALEATORIO_CON_REPETIDOS("aleatorio_10_repetidos");

    private final String etiqueta;

    TipoEntrada(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String obtenerEtiqueta() {
        return etiqueta;
    }
}
