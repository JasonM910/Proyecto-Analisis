import java.util.Random;

/**
 * Construye arreglos de prueba segun el tipo de entrada solicitado.
 *
 * <p>Esta clase centraliza la logica de generacion para garantizar que todos los algoritmos
 * se ejecuten sobre entradas comparables.</p>
 */
public class GeneradorDatos {
    /**
     * Genera un arreglo segun el tipo de entrada y el tamano solicitados.
     *
     * @param tipoEntrada tipo de distribucion de datos que se desea construir
     * @param tamano cantidad de elementos del arreglo
     * @return arreglo de enteros generado segun el tipo indicado
     */
    public int[] generarDatos(TipoEntrada tipoEntrada, int tamano) {
        if (tipoEntrada == TipoEntrada.ORDENADO) {
            return construirOrdenado(tamano);
        }
        if (tipoEntrada == TipoEntrada.INVERSO) {
            return construirInverso(tamano);
        }
        if (tipoEntrada == TipoEntrada.ALEATORIO) {
            return construirAleatorioSinRepetidos(tamano);
        }
        if (tipoEntrada == TipoEntrada.ALEATORIO_CON_REPETIDOS) {
            return construirAleatorioConRepetidos(tamano);
        }
        throw new IllegalStateException("Tipo de entrada no soportado: " + tipoEntrada);
    }

    /**
     * Crea una secuencia ordenada ascendente: 1, 2, 3, ..., n.
     *
     * @param tamano cantidad de elementos
     * @return arreglo ordenado de forma ascendente
     */
    private int[] construirOrdenado(int tamano) {
        int[] datos = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            datos[i] = i + 1;
        }
        return datos;
    }

    /**
     * Crea una secuencia ordenada descendente: n, n-1, ..., 1.
     *
     * @param tamano cantidad de elementos
     * @return arreglo ordenado de forma descendente
     */
    private int[] construirInverso(int tamano) {
        int[] datos = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            datos[i] = tamano - i;
        }
        return datos;
    }

    /**
     * Genera un arreglo aleatorio sin repetidos usando mezcla Fisher-Yates.
     *
     * @param tamano cantidad de elementos
     * @return arreglo permutado sin elementos repetidos
     */
    private int[] construirAleatorioSinRepetidos(int tamano) {
        int[] datos = construirOrdenado(tamano);
        Random generadorAleatorio = new Random();

        for (int i = datos.length - 1; i > 0; i--) {
            int indiceIntercambio = generadorAleatorio.nextInt(i + 1);
            int temporal = datos[i];
            datos[i] = datos[indiceIntercambio];
            datos[indiceIntercambio] = temporal;
        }
        return datos;
    }

    /**
     * Genera un arreglo aleatorio e introduce repetidos en alrededor del 10% de posiciones.
     *
     * @param tamano cantidad de elementos
     * @return arreglo aleatorio con algunos valores repetidos
     */
    private int[] construirAleatorioConRepetidos(int tamano) {
        int[] datos = construirAleatorioSinRepetidos(tamano);
        if (tamano == 0) {
            return datos;
        }

        Random generadorAleatorio = new Random();
        int cantidadCambiosRepetidos = Math.max(1, tamano / 10);

        for (int i = 0; i < cantidadCambiosRepetidos; i++) {
            int indiceDestino = generadorAleatorio.nextInt(tamano);
            int indiceOrigen = generadorAleatorio.nextInt(tamano);
            while (indiceOrigen == indiceDestino) {
                indiceOrigen = generadorAleatorio.nextInt(tamano);
            }
            datos[indiceDestino] = datos[indiceOrigen];
        }

        return datos;
    }
}
