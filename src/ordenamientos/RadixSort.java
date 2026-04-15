package ordenamientos;

/**
 * Implementa el algoritmo RadixSort en base 10 para enteros no negativos.
 */
public class RadixSort {
    /**
     * Ordena el arreglo en orden ascendente aplicando CountingSort por digitos.
     *
     * @param datos arreglo de enteros a ordenar
     * @param metricas acumulador de asignaciones y comparaciones
     */
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length == 0) {
            return;
        }

        int valorMaximo = obtenerMaximo(datos, metricas);

        for (int exponente = 1; valorMaximo / exponente > 0; exponente *= 10) {
            metricas.sumarComparaciones(1);
            countingSortPorDigito(datos, exponente, metricas);
            metricas.sumarAsignaciones(1);
        }
    }

    /**
     * Obtiene el valor maximo presente en el arreglo.
     *
     * @param datos arreglo de entrada
     * @param metricas acumulador de asignaciones y comparaciones
     * @return valor maximo del arreglo
     */
    private int obtenerMaximo(int[] datos, Metricas metricas) {
        int valorMaximo = datos[0];
        metricas.sumarAsignaciones(1);

        for (int i = 1; i < datos.length; i++) {
            metricas.sumarComparaciones(1);
            if (datos[i] > valorMaximo) {
                valorMaximo = datos[i];
                metricas.sumarAsignaciones(1);
            }
        }

        return valorMaximo;
    }

    /**
     * Aplica una pasada de CountingSort sobre un digito especifico.
     *
     * @param datos arreglo de entrada y salida
     * @param exponente posicion decimal actual (1, 10, 100, ...)
     * @param metricas acumulador de asignaciones y comparaciones
     */
    private void countingSortPorDigito(int[] datos, int exponente, Metricas metricas) {
        int tamano = datos.length;
        int[] salida = new int[tamano];
        int[] conteo = new int[10];

        metricas.sumarAsignaciones(3);

        for (int i = 0; i < tamano; i++) {
            int indice = (datos[i] / exponente) % 10;
            conteo[indice]++;
            metricas.sumarAsignaciones(2);
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
            metricas.sumarAsignaciones(1);
        }

        for (int i = tamano - 1; i >= 0; i--) {
            int indice = (datos[i] / exponente) % 10;
            salida[conteo[indice] - 1] = datos[i];
            conteo[indice]--;
            metricas.sumarAsignaciones(3);
        }

        for (int i = 0; i < tamano; i++) {
            datos[i] = salida[i];
            metricas.sumarAsignaciones(1);
        }
    }
}
