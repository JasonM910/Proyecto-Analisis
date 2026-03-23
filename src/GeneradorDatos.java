import java.util.Random;

public class GeneradorDatos {
    public int[] generarDatos(TipoEntrada tipoEntrada, int tamano) {
        if (tipoEntrada == TipoEntrada.ORDENADO) {
            return construirOrdenado(tamano);
        }
        if (tipoEntrada == TipoEntrada.INVERSO) {
            return construirInverso(tamano);
        }
        if (tipoEntrada == TipoEntrada.ALEATORIO) {
            return construirAleatorioSinRepetidos(tamano);
        }
        if (tipoEntrada == TipoEntrada.ALEATORIO_CON_REPETIDOS) {
            return construirAleatorioConRepetidos(tamano);
        }
        throw new IllegalStateException("Tipo de entrada no soportado: " + tipoEntrada);
    }

    private int[] construirOrdenado(int tamano) {
        int[] datos = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            datos[i] = i + 1;
        }
        return datos;
    }

    private int[] construirInverso(int tamano) {
        int[] datos = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            datos[i] = tamano - i;
        }
        return datos;
    }

    private int[] construirAleatorioSinRepetidos(int tamano) {
        int[] datos = construirOrdenado(tamano);
        Random aleatorio = new Random();

        for (int i = datos.length - 1; i > 0; i--) {
            int indiceIntercambio = aleatorio.nextInt(i + 1);
            int temporal = datos[i];
            datos[i] = datos[indiceIntercambio];
            datos[indiceIntercambio] = temporal;
        }
        return datos;
    }

    private int[] construirAleatorioConRepetidos(int tamano) {
        int[] datos = construirAleatorioSinRepetidos(tamano);
        if (tamano == 0) {
            return datos;
        }

        Random aleatorio = new Random();
        int cantidadCambiosRepetidos = Math.max(1, tamano / 10);

        for (int i = 0; i < cantidadCambiosRepetidos; i++) {
            int indiceDestino = aleatorio.nextInt(tamano);
            int indiceOrigen = aleatorio.nextInt(tamano);
            while (indiceOrigen == indiceDestino) {
                indiceOrigen = aleatorio.nextInt(tamano);
            }
            datos[indiceDestino] = datos[indiceOrigen];
        }

        return datos;
    }
}
