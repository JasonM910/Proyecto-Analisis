package ordenamientos;

/**
 * Implementa el algoritmo QuickSort con pivote central.
 */
public class QuickSort {
    /**
     * Ordena un arreglo de enteros en orden ascendente.
     *
     * @param datos arreglo de enteros a ordenar
     * @param metricas acumulador de asignaciones y comparaciones
     */
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length <= 1) {
            return;
        }
        quickSort(datos, 0, datos.length - 1, metricas);
    }

    /**
     * Aplica QuickSort recursivo sobre un segmento del arreglo.
     *
     * @param datos arreglo con los valores a ordenar
     * @param inicio indice inicial del segmento
     * @param fin indice final del segmento
     * @param metricas acumulador de asignaciones y comparaciones
     */
    private void quickSort(int[] datos, int inicio, int fin, Metricas metricas) {
        metricas.sumarComparaciones(1);
        if (inicio >= fin) {
            return;
        }

        int i = inicio;
        int j = fin;
        int pivote = datos[(inicio + fin) / 2];
        metricas.sumarAsignaciones(3);

        while (i <= j) {
            metricas.sumarComparaciones(1);
            while (datos[i] < pivote) {
                metricas.sumarComparaciones(1);
                i++;
                metricas.sumarAsignaciones(1);
            }

            metricas.sumarComparaciones(1);
            while (datos[j] > pivote) {
                metricas.sumarComparaciones(1);
                j--;
                metricas.sumarAsignaciones(1);
            }

            metricas.sumarComparaciones(1);
            if (i <= j) {
                intercambiar(datos, i, j, metricas);
                i++;
                j--;
                metricas.sumarAsignaciones(2);
            }
        }

        metricas.sumarComparaciones(1);
        if (inicio < j) {
            quickSort(datos, inicio, j, metricas);
        }

        metricas.sumarComparaciones(1);
        if (i < fin) {
            quickSort(datos, i, fin, metricas);
        }
    }

    /**
     * Intercambia dos posiciones del arreglo si son diferentes.
     *
     * @param datos arreglo objetivo
     * @param indice1 primer indice
     * @param indice2 segundo indice
     * @param metricas acumulador de asignaciones y comparaciones
     */
    private void intercambiar(int[] datos, int indice1, int indice2, Metricas metricas) {
        metricas.sumarComparaciones(1);
        if (indice1 != indice2) {
            int temporal = datos[indice1];
            datos[indice1] = datos[indice2];
            datos[indice2] = temporal;
            metricas.sumarAsignaciones(3);
        }
    }
}