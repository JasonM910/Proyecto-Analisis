import proyectoanalisis.EjecutorExperimentos;
import proyectoanalisis.OrdenamientoInsercion;
import proyectoanalisis.OrdenamientoSeleccion;

public class Main {
    public static void main(String[] args) {
        OrdenamientoSeleccion algoritmoSeleccion = new OrdenamientoSeleccion();
        OrdenamientoInsercion algoritmoInsercion = new OrdenamientoInsercion();

        System.out.println("=== Proyecto Analisis de Algoritmos ===");
        System.out.println("Algoritmos implementados: Seleccion, Insercion");
        System.out.println("Tamanos de prueba: 10, 100, 200, 300, 400, 500, 600, 700, 1000, 10000, 20000, 40000, 80000");
        System.out.println();

        EjecutorExperimentos ejecutor = new EjecutorExperimentos();

        ejecutor.ejecutar(algoritmoSeleccion, algoritmoInsercion);
    }
}
