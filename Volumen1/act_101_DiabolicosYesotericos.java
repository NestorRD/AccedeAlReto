package Volumen1;
import java.util.Scanner;
import java.math.*;

public class act_101_DiabolicosYesotericos {

	public static void main(String[] args) {
		String datoIntroducido;
		int n=0, n2=0, cm, cm2, sumaFila=0, sumaColumn=0, sumaDiago=0, sumaEsquinas=0, sumaCentro=0, sumaCentroLados=0;
		boolean diabolico = false, esoterico=false;
		boolean control=false;
		
		Scanner lector = new Scanner(System.in);
		
		//Pedimos el numero de filas/columnas y obtenemos el cuadrado.
		try {
			System.out.println("Introduce número de filas/columnas del cuadrado:");
			datoIntroducido = lector.next();
			n = Integer.parseInt(datoIntroducido);
			n2 = (int) Math.pow(n, 2);
		} catch(NumberFormatException ex) {
			System.out.println("No es un número");
		}
		
		//Creamos la array que contendrá los dígitos del cuadrado.
		int [][] cuadrado = new int [n][n]; 
		
		//Introducción de números dentro del cuadrado.
		System.out.println("Introduce números hasta que se diga basta:");
		for(int i=0; i<n; i++) {
			for(int j=0;j<n; j++) {
				do {
					try {
						datoIntroducido = lector.next();
						cuadrado[i][j] = Integer.parseInt(datoIntroducido);
						control=true;
					} catch(NumberFormatException ex) {
						System.out.println("No es un número");
					}
				} while (!control);
				control=false;
			}
		}
		
		//Calculamos la suma de columnas y filas
		for(int i=0; i<n;i++) {
			for (int j=0; j<n; j++) {
				if (i==0) {
					sumaFila = sumaFila + cuadrado[0][j];
				}
				
				if (j==0) {
					sumaColumn = sumaColumn + cuadrado[i][0];
				}
			}
		}
		//Calculamos la suma de la diagonal
		for (int k=0; k<n; k++) {
			sumaDiago = sumaDiago + cuadrado[k][k];
		}
		
		System.out.println(sumaFila + " " + sumaColumn + " " + sumaDiago);
		
		if (sumaFila == sumaColumn && sumaFila == sumaDiago) {
			diabolico = true;
			cm = sumaColumn; //obtenemos la Constante mágica
			System.out.println("Es un cuadrado mágico diabolico.");
			cm2 = 4*cm/n; //obtenemos valor de Constante mágica 2
			
			if(n%2==0) {
				
			}
			
			
		} else System.out.println("NO");
		
	}

}
