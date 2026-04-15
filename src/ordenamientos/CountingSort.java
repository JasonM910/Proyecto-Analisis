package ordenamientos;

/**
 * Implementa el algoritmo CountingSort para enteros no negativos.
 */
public class CountingSort {
    /**
     * Ordena el arreglo en orden ascendente usando conteo de ocurrencias.
     *
     * @param datos arreglo de enteros a ordenar
     * @param metricas acumulador de asignaciones y comparaciones
     */
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length == 0) {
            return;
        }

        int tamano = datos.length;
        metricas.sumarAsignaciones(1);

        int valorMaximo = datos[0];
        metricas.sumarAsignaciones(1);

        for (int i = 1; i < tamano; i++) {
            metricas.sumarComparaciones(1);
            if (datos[i] > valorMaximo) {
                valorMaximo = datos[i];
                metricas.sumarAsignaciones(1);
            }
        }

        int[] conteo = new int[valorMaximo + 1];
        metricas.sumarAsignaciones(1);

        for (int i = 0; i < tamano; i++) {
            conteo[datos[i]]++;
            metricas.sumarAsignaciones(1);
        }

        int indice = 0;
        metricas.sumarAsignaciones(1);

        for (int i = 0; i < conteo.length; i++) {
            metricas.sumarComparaciones(1);
            while (conteo[i] > 0) {
                metricas.sumarComparaciones(1);
                datos[indice++] = i;
                conteo[i]--;
                metricas.sumarAsignaciones(2);
            }
        }
    }
}
