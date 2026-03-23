package ordenamientos;

public class Metricas {
    private long asignaciones;
    private long comparaciones;
    private double tiempoMilisegundos;

    public void sumarAsignaciones(long valor) {
        asignaciones += valor;
    }

    public void sumarComparaciones(long valor) {
        comparaciones += valor;
    }

    public long obtenerAsignaciones() {
        return asignaciones;
    }

    public long obtenerComparaciones() {
        return comparaciones;
    }

    public long obtenerLineasEjecutadas() {
        return asignaciones + comparaciones;
    }

    public double obtenerTiempoMilisegundos() {
        return tiempoMilisegundos;
    }

    public void establecerTiempoMilisegundos(double tiempoMilisegundos) {
        this.tiempoMilisegundos = tiempoMilisegundos;
    }
}
