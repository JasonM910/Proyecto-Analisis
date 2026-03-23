package ordenamientos;

// Implementacion del algoritmo de ordenamiento por seleccion
public class Seleccion {
    // Ordena el arreglo y actualiza contadores de metricas
    public void ordenar(int[] datos, Metricas metricas) {
        // Recorre cada posicion y coloca el minimo que encuentra
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

            // Si encontro un minimo distinto, hace el intercambio
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
