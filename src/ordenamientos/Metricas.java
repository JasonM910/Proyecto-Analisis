package ordenamientos;

// Guarda los contadores
public class Metricas {
    private long asignaciones;
    private long comparaciones;
    private double tiempoMilisegundos;

    // Suma asignaciones realizadas por el algoritmo
    public void sumarAsignaciones(long valor) {
        asignaciones += valor;
    }

    // Suma comparaciones realizadas por el algoritmo
    public void sumarComparaciones(long valor) {
        comparaciones += valor;
    }

    // Cantidad total de asignaciones
    public long obtenerAsignaciones() {
        return asignaciones;
    }

    // Cantidad total de comparaciones
    public long obtenerComparaciones() {
        return comparaciones;
    }

    // Lineas ejecutadas = asignaciones + comparaciones
    public long obtenerLineasEjecutadas() {
        return asignaciones + comparaciones;
    }

    // Tiempo de ejecucion en milisegundos
    public double obtenerTiempoMilisegundos() {
        return tiempoMilisegundos;
    }

    // Guarda el tiempo medido
    public void establecerTiempoMilisegundos(double tiempoMilisegundos) {
        this.tiempoMilisegundos = tiempoMilisegundos;
    }
}
