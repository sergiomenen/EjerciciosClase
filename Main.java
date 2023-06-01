package MUltiplicarMatrices;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// Ruta de los archivos de entrada y salida
		String archivoMatriz1 = "matriz1.txt";
		String archivoMatriz2 = "matriz2.txt";
		String archivoResultado = "resultado.txt";

		// Leer las matrices desde los archivos de texto
		Matriz matriz1 = leerMatrizDesdeArchivo(archivoMatriz1);
		Matriz matriz2 = leerMatrizDesdeArchivo(archivoMatriz2);

		// Multiplicar las matrices
		Matriz resultado = matriz1.multiplicar(matriz2);

		// Escribir el resultado en un archivo de texto
		escribirMatrizEnArchivo(resultado, archivoResultado);

		System.out.println(
				"Multiplicación de matrices completada. El resultado se encuentra en el archivo: " + archivoResultado);
	}

	private static Matriz leerMatrizDesdeArchivo(String archivo) {
		Matriz matriz = null;

		try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
			List<int[]> filas = new ArrayList<>(); // Utilizar una lista para almacenar temporalmente las filas

			String linea;
			int columnas = -1; // Variable para almacenar el número de columnas

			while ((linea = lector.readLine()) != null) {
				String[] elementos = linea.split(","); // Separar los elementos por coma (puedes elegir otro
														// delimitador)

				if (columnas == -1) {
					columnas = elementos.length;
				} else if (elementos.length != columnas) {
					throw new IllegalArgumentException("El número de elementos en las filas no es consistente.");
				}

				int[] fila = new int[columnas];
				for (int columna = 0; columna < columnas; columna++) {
					fila[columna] = Integer.parseInt(elementos[columna].trim()); // Eliminar los espacios en blanco
				}

				filas.add(fila);
			}

			int[][] datos = new int[filas.size()][columnas]; // Crear la matriz con el tamaño correcto

			for (int fila = 0; fila < filas.size(); fila++) {
				datos[fila] = filas.get(fila);
			}

			matriz = new Matriz(datos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriz;
	}

	private static void escribirMatrizEnArchivo(Matriz matriz, String archivo) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
			int filas = matriz.getFilas();
			int columnas = matriz.getColumnas();
			int[][] datos = matriz.getDatos();

			for (int fila = 0; fila < filas; fila++) {
				for (int columna = 0; columna < columnas; columna++) {
					escritor.write(String.valueOf(datos[fila][columna]));

					if (columna < columnas - 1) {
						escritor.write(",");
					}
				}

				escritor.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
