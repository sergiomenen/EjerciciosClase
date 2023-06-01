package MUltiplicarMatrices;

import org.junit.Assert;
import org.junit.Test;

public class MatrizTest {
    @Test
    public void testMultiplicarMatrices() {
        int[][] datos1 = {{1, 2}, {3, 4}};
        int[][] datos2 = {{5, 6}, {7, 8}};

        Matriz matriz1 = new Matriz(datos1);
        Matriz matriz2 = new Matriz(datos2);

        Matriz resultado = matriz1.multiplicar(matriz2);

        int[][] expected = {{19, 22}, {43, 50}};

        Assert.assertArrayEquals(expected, resultado.getDatos());
    }
}

