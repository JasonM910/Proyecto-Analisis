package ordenamientos;

/**
 * Almacena las metricas recolectadas durante la ejecucion de un algoritmo.
 */
public class Metricas {
    private long asignaciones;
    private long comparaciones;
    private double tiempoMilisegundos;

    /**
     * Acumula asignaciones realizadas por un algoritmo.
     *
     * @param valor cantidad de asignaciones a agregar
     */
    public void sumarAsignaciones(long valor) {
        asignaciones += valor;
    }

    /**
     * Acumula comparaciones realizadas por un algoritmo.
     *
     * @param valor cantidad de comparaciones a agregar
     */
    public void sumarComparaciones(long valor) {
        comparaciones += valor;
    }

    /**
     * Obtiene la cantidad total de asignaciones registradas.
     *
     * @return total de asignaciones
     */
    public long obtenerAsignaciones() {
        return asignaciones;
    }

    /**
     * Obtiene la cantidad total de comparaciones registradas.
     *
     * @return total de comparaciones
     */
    public long obtenerComparaciones() {
        return comparaciones;
    }

    /**
     * Calcula una estimacion de lineas ejecutadas como suma de asignaciones y comparaciones.
     *
     * @return total estimado de lineas ejecutadas
     */
    public long obtenerLineasEjecutadas() {
        return asignaciones + comparaciones;
    }

    /**
     * Obtiene el tiempo de ejecucion medido en milisegundos.
     *
     * @return tiempo de ejecucion en milisegundos
     */
    public double obtenerTiempoMilisegundos() {
        return tiempoMilisegundos;
    }

    /**
     * Establece el tiempo de ejecucion medido en milisegundos.
     *
     * @param tiempoMilisegundos tiempo a registrar
     */
    public void establecerTiempoMilisegundos(double tiempoMilisegundos) {
        this.tiempoMilisegundos = tiempoMilisegundos;
    }
}
