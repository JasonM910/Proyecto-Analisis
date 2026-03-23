import proyectoanalisis.EjecutorExperimentos;
import proyectoanalisis.ordenamientos.Insercion;
import proyectoanalisis.ordenamientos.Seleccion;

public class Main {
    public static void main(String[] args) {
        Seleccion algoritmoSeleccion = new Seleccion();
        Insercion algoritmoInsercion = new Insercion();

        System.out.println("=== Proyecto Analisis de Algoritmos ===");
        System.out.println("Algoritmos implementados: Seleccion, Insercion");
        System.out.println("Tamaños de prueba: 10, 100, 200, 300, 400, 500, 600, 700, 1000, 10000, 20000, 40000, 80000");
        System.out.println();

        EjecutorExperimentos ejecutor = new EjecutorExperimentos();

        ejecutor.ejecutar(algoritmoSeleccion, algoritmoInsercion);
    }
}
