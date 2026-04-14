package ordenamientos;

public class CountingSort {
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length == 0) {
            return;
        }

        int n = datos.length;
        metricas.sumarAsignaciones(1);

        // Encontrar el valor máximo
        int max = datos[0];
        metricas.sumarAsignaciones(1);

        for (int i = 1; i < n; i++) {
            metricas.sumarComparaciones(1);
            if (datos[i] > max) {
                max = datos[i];
                metricas.sumarAsignaciones(1);
            }
        }

        // Crear arreglo de conteo
        int[] conteo = new int[max + 1];
        metricas.sumarAsignaciones(1);

        // Contar ocurrencias
        for (int i = 0; i < n; i++) {
            conteo[datos[i]]++;
            metricas.sumarAsignaciones(1);
        }

        // Reconstruir el arreglo ordenado
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
