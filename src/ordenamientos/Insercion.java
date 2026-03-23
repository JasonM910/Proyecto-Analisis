package ordenamientos;

// Implementacion del algoritmo de ordenamiento por insercion
public class Insercion {
    // Ordena el arreglo y actualiza contadores de metricas
    public void ordenar(int[] datos, Metricas metricas) {
        // Toma cada elemento y lo inserta en su posicion dentro de la parte ya ordenada
        for (int i = 1; i < datos.length; i++) {
            int clave = datos[i];
            int j = i - 1;
            metricas.sumarAsignaciones(2);

            // Desplaza elementos hacia la derecha mientras sean mayores a la clave
            while (true) {
                metricas.sumarComparaciones(1);
                if (j < 0) {
                    break;
                }

                metricas.sumarComparaciones(1);
                if (datos[j] > clave) {
                    datos[j + 1] = datos[j];
                    j--;
                    metricas.sumarAsignaciones(2);
                } else {
                    break;
                }
            }

            // Coloca la clave en su posicion final
            datos[j + 1] = clave;
            metricas.sumarAsignaciones(1);
        }
    }
}
