package ordenamientos;

/**
 * Implementa el algoritmo ShellSort usando saltos decrecientes.
 */
public class ShellSort {
    /**
     * Ordena un arreglo de enteros en orden ascendente mediante inserciones por salto.
     *
     * @param datos arreglo de enteros a ordenar
     * @param metricas acumulador de asignaciones y comparaciones
     */
    public void ordenar(int[] datos, Metricas metricas) {
        int tamano = datos.length;
        metricas.sumarAsignaciones(1);

        for (int salto = tamano / 2; salto > 0; salto /= 2) {
            metricas.sumarAsignaciones(1);

            for (int i = salto; i < tamano; i++) {
                metricas.sumarComparaciones(1);

                int temporal = datos[i];
                int j = i;
                metricas.sumarAsignaciones(2);

                while (true) {
                    metricas.sumarComparaciones(1);
                    if (j < salto) {
                        break;
                    }

                    metricas.sumarComparaciones(1);
                    if (datos[j - salto] > temporal) {
                        datos[j] = datos[j - salto];
                        j = j - salto;
                        metricas.sumarAsignaciones(2);
                    } else {
                        break;
                    }
                }

                datos[j] = temporal;
                metricas.sumarAsignaciones(1);
            }
        }
    }
}
