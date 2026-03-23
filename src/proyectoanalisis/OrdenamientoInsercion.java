package proyectoanalisis;

public class OrdenamientoInsercion {

    private static final int CANTIDAD_LINEAS_CODIGO = 20;

    public int obtenerCantidadLineasCodigo() {
        return CANTIDAD_LINEAS_CODIGO;
    }

    public void ordenar(int[] datos, MetricasOrdenamiento metricas) {
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
