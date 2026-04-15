package ordenamientos;

/**
 * Implementa el algoritmo de ordenamiento por seleccion.
 */
public class Seleccion {
    /**
     * Ordena el arreglo en orden ascendente y actualiza las metricas de operacion.
     *
     * @param datos arreglo de enteros a ordenar
     * @param metricas acumulador de asignaciones y comparaciones
     */
    public void ordenar(int[] datos, Metricas metricas) {
        for (int i = 0; i < datos.length - 1; i++) {
            int indiceMinimo = i;
            metricas.sumarAsignaciones(1);

            for (int j = i + 1; j < datos.length; j++) {
                metricas.sumarComparaciones(1);
                if (datos[j] < datos[indiceMinimo]) {
                    indiceMinimo = j;
                    metricas.sumarAsignaciones(1);
                }
            }

            metricas.sumarComparaciones(1);
            if (indiceMinimo != i) {
                int temporal = datos[i];
                datos[i] = datos[indiceMinimo];
                datos[indiceMinimo] = temporal;
                metricas.sumarAsignaciones(3);
            }
        }
    }
}
