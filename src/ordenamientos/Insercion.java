package ordenamientos;

public class Insercion {
    public void ordenar(int[] datos, Metricas metricas) {
        for (int i = 1; i < datos.length; i++) {
            int clave = datos[i];
            int j = i - 1;
            metricas.sumarAsignaciones(2);

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

            datos[j + 1] = clave;
            metricas.sumarAsignaciones(1);
        }
    }
}
