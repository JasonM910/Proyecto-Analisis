import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class Main {
    private static final int[] tamanos = {10, 100, 200, 300, 400, 500, 600, 700, 1000, 10000, 20000, 40000, 80000};

    public static void main(String[] args) {
        Seleccion algoritmoSeleccion = new Seleccion();
        Insercion algoritmoInsercion = new Insercion();
        GeneradorDatos generadorDatos = new GeneradorDatos();

        System.out.println("=== Proyecto Analisis de Algoritmos ===");
        System.out.println("Algoritmos implementados: Seleccion, Insercion");
        System.out.println("Tamanos de prueba: 10, 100, 200, 300, 400, 500, 600, 700, 1000, 10000, 20000, 40000, 80000");
        System.out.println();

        ejecutarExperimentos(algoritmoSeleccion, algoritmoInsercion, generadorDatos);
    }

    private static void ejecutarExperimentos(Seleccion algoritmoSeleccion, Insercion algoritmoInsercion,
            GeneradorDatos generadorDatos) {
        String[] nombresAlgoritmos = {"Seleccion", "Insercion"};
        boolean primerTamano = true;

        for (int tamano : tamanos) {
            if (!primerTamano) {
                System.out.println();
            }
            System.out.println("---- Tamano " + tamano + " ----");
            primerTamano = false;

            Map<TipoEntrada, int[]> casos = generadorDatos.generarCasos(tamano);

            for (TipoEntrada tipoEntrada : TipoEntrada.values()) {
                int[] datosBase = casos.get(tipoEntrada);

                for (String nombreAlgoritmo : nombresAlgoritmos) {
                    int[] copiaTrabajo = Arrays.copyOf(datosBase, datosBase.length);
                    MetricasOrdenamiento metricas = new MetricasOrdenamiento();

                    if (tamano == 10 && esEntradaAleatoria(tipoEntrada)) {
                        System.out.println("  Entrada:   " + Arrays.toString(copiaTrabajo));
                    }

                    long tiempoInicioNano = System.nanoTime();
                    if (nombreAlgoritmo.equals("Seleccion")) {
                        algoritmoSeleccion.ordenar(copiaTrabajo, metricas);
                    } else if (nombreAlgoritmo.equals("Insercion")) {
                        algoritmoInsercion.ordenar(copiaTrabajo, metricas);
                    }
                    long tiempoFinNano = System.nanoTime();

                    metricas.establecerTiempoMilisegundos((tiempoFinNano - tiempoInicioNano) / 1_000_000.0);
                    imprimirResultado(nombreAlgoritmo, tipoEntrada, metricas);

                    if (tamano == 10) {
                        System.out.println("  Ordenados: " + Arrays.toString(copiaTrabajo));
                    }
                }
            }
        }
    }

    private static void imprimirResultado(String nombreAlgoritmo, TipoEntrada tipoEntrada,
            MetricasOrdenamiento metricas) {
        String linea = String.format(Locale.US,
                "%-10s | %-22s | asig=%-12d | comp=%-12d | lineas=%-12d | tiempo(ms)=%8.3f",
                nombreAlgoritmo,
                tipoEntrada.obtenerEtiqueta(),
                metricas.obtenerAsignaciones(),
                metricas.obtenerComparaciones(),
                metricas.obtenerLineasEjecutadas(),
                metricas.obtenerTiempoMilisegundos());
        System.out.println(linea);
    }

    private static boolean esEntradaAleatoria(TipoEntrada tipoEntrada) {
        return tipoEntrada == TipoEntrada.ALEATORIO || tipoEntrada == TipoEntrada.ALEATORIO_CON_REPETIDOS;
    }
}
