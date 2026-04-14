package ordenamientos;

// Implementacion del algoritmo QuickSort
public class QuickSort {
    // Metodo principal que inicia el ordenamiento
    public void ordenar(int[] datos, Metricas metricas) {
        if (datos == null || datos.length <= 1) {
            return;
        }
        quickSort(datos, 0, datos.length - 1, metricas);
    }

    // Ordena el arreglo usando particion con pivote central
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

    // Intercambia dos elementos del arreglo
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