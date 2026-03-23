import ordenamientos.Insercion;
import ordenamientos.Metricas;
import ordenamientos.Seleccion;

import java.util.Arrays;

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

            for (TipoEntrada tipoEntrada : TipoEntrada.values()) {
                int[] datosBase = generadorDatos.generarDatos(tipoEntrada, tamano);

                for (String nombreAlgoritmo : nombresAlgoritmos) {
                    int[] copiaTrabajo = Arrays.copyOf(datosBase, datosBase.length);
                    Metricas metricas = new Metricas();

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

                    metricas.establecerTiempoMilisegundos((tiempoFinNano - tiempoInicioNano) / 1000000.0);
                    imprimirResultado(nombreAlgoritmo, tipoEntrada, metricas);

                    if (tamano == 10) {
                        System.out.println("  Ordenados: " + Arrays.toString(copiaTrabajo));
                    }
                }
            }
        }
    }

    private static void imprimirResultado(String nombreAlgoritmo, TipoEntrada tipoEntrada, Metricas metricas) {
        System.out.println(nombreAlgoritmo
                + " | " + tipoEntrada.obtenerEtiqueta()
                + " | asig=" + metricas.obtenerAsignaciones()
                + " | comp=" + metricas.obtenerComparaciones()
                + " | lineas=" + metricas.obtenerLineasEjecutadas()
                + " | tiempo(ms)=" + metricas.obtenerTiempoMilisegundos());
    }

    private static boolean esEntradaAleatoria(TipoEntrada tipoEntrada) {
        return tipoEntrada == TipoEntrada.ALEATORIO || tipoEntrada == TipoEntrada.ALEATORIO_CON_REPETIDOS;
    }
}
