package ordenamientos;

public class RadixSort {
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length == 0) {
            return;
        }

        int max = obtenerMaximo(datos, metricas);

        // Aplicar counting sort por cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            metricas.sumarComparaciones(1);
            countingSortPorDigito(datos, exp, metricas);
            metricas.sumarAsignaciones(1);
        }
    }

    // Obtener el valor máximo
    private int obtenerMaximo(int[] datos, Metricas metricas) {
        int max = datos[0];
        metricas.sumarAsignaciones(1);

        for (int i = 1; i < datos.length; i++) {
            metricas.sumarComparaciones(1);
            if (datos[i] > max) {
                max = datos[i];
                metricas.sumarAsignaciones(1);
            }
        }

        return max;
    }

    // CountingSort usado por cada dígito
    private void countingSortPorDigito(int[] datos, int exp, Metricas metricas) {
        int n = datos.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        metricas.sumarAsignaciones(3);

        // Contar ocurrencias
        for (int i = 0; i < n; i++) {
            int indice = (datos[i] / exp) % 10;
            conteo[indice]++;
            metricas.sumarAsignaciones(2);
        }

        // Acumular conteo
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
            metricas.sumarAsignaciones(1);
        }

        // Construir salida
        for (int i = n - 1; i >= 0; i--) {
            int indice = (datos[i] / exp) % 10;
            salida[conteo[indice] - 1] = datos[i];
            conteo[indice]--;
            metricas.sumarAsignaciones(3);
        }

        // Copiar al arreglo original
        for (int i = 0; i < n; i++) {
            datos[i] = salida[i];
            metricas.sumarAsignaciones(1);
        }
    }
}
