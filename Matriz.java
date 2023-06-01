package MUltiplicarMatrices;

public class Matriz {
    private int[][] datos;

    public Matriz(int[][] datos) {
        this.datos = datos;
    }

    public int[][] getDatos() {
        return datos;
    }

    public int getFilas() {
        return datos.length;
    }

    public int getColumnas() {
        return datos[0].length;
    }

    public Matriz multiplicar(Matriz otraMatriz) {
        if (getColumnas() != otraMatriz.getFilas()) {
            throw new IllegalArgumentException("Las dimensiones de las matrices no son compatibles para la multiplicación.");
        }

        int[][] resultado = new int[getFilas()][otraMatriz.getColumnas()];

        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < otraMatriz.getColumnas(); j++) {
                int sum = 0;
                for (int k = 0; k < getColumnas(); k++) {
                    sum += datos[i][k] * otraMatriz.getDatos()[k][j];
                }
                resultado[i][j] = sum;
            }
        }

        return new Matriz(resultado);
    }
}
