package proyectoanalisis;

public class OrdenamientoSeleccion {

    private static final int CANTIDAD_LINEAS_CODIGO = 18;

    public int obtenerCantidadLineasCodigo() {
        return CANTIDAD_LINEAS_CODIGO;
    }

    public void ordenar(int[] datos, MetricasOrdenamiento metricas) {
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
