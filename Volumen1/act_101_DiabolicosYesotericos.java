//N�stor Romero D�az
//Finish date: 10-11-2018
//Link to challenge: https://www.aceptaelreto.com/problem/statement.php?id=101
//Use: Programa que definiendo el tama�o de columnas/filas de un cuadrado, introducimos valores y obtenemos si es un cuadrado m�gico o no, y si lo es, si es diabolico o diabiolico + esoterico.

package Volumen1;

import java.util.Scanner;
import java.math.*;

public class act_101_DiabolicosYesotericos {

	public static void main(String[] args) {
		boolean control=false;
		
		do { //bucle para repetir cuadrados hasta que se indique 0.
			
			String datoIntroducido; //para obtener n�mero del usuario.
			int n=0, n2=0, cm, cm2; //n = numero de digitos por fila/columna //n2 = n elevado al cuadrado //cm = connstante m�gica //cm2 = constante magica2.
			int sumaFila=0, sumaColumn=0, sumaDiago=0, sumaEsquinas=0, sumaCentro=0, sumaCentroLados=0; //Usamos las sumas para comprobar si son diabolicos o esotericos.
			
			Scanner lector = new Scanner(System.in);
			
			//Pedimos el numero de filas/columnas y obtenemos el cuadrado.
			try {
				System.out.println("Introduce n�mero de filas/columnas del cuadrado:");
				datoIntroducido = lector.next();
				n = Integer.parseInt(datoIntroducido);
				n2 = (int) Math.pow(n, 2);
				if (n==0) {
					System.out.println("Bye");
					System.exit(1);
				}
			} catch(NumberFormatException ex) {
				System.out.println("No es un n�mero");
			}
			
			//Creamos la array que contendr� los d�gitos del cuadrado.
			int [][] cuadrado = new int [n][n]; 
			
			//Introducci�n de n�meros dentro del cuadrado.
			System.out.println("Introduce n�meros hasta que se diga basta:");
			for(int i=0; i<n; i++) {
				for(int j=0;j<n; j++) {
					do {
						try {
							datoIntroducido = lector.next();
							cuadrado[i][j] = Integer.parseInt(datoIntroducido);
							control=true;
						} catch(NumberFormatException ex) {
							System.out.println("No es un n�mero");
						}
					} while (!control);
					control=false;
				}
			}
			control = false; //ponemos control de nuevo a predeterminado.
			
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
			
			System.out.println(sumaFila + " " + sumaColumn + " " + sumaDiago); //comprobamos sumas
			
			if (sumaFila == sumaColumn && sumaFila == sumaDiago) {
				cm = sumaColumn; //obtenemos la Constante m�gica
				System.out.print("Es un cuadrado m�gico diabolico.");
				cm2 = (4 * cm)/n; //obtenemos valor de Constante m�gica 2
				sumaEsquinas = sumaEsquinas + cuadrado[0][0] + cuadrado[0][n-1] + cuadrado[n-1][0] + cuadrado[n-1][n-1];
				
				if(n%2==0) {
					//sumamos los centros de cada lado.
					sumaCentroLados = cuadrado[0][(n-1)/2] + cuadrado[0][n/2]; //suma 1a fila
					sumaCentroLados = sumaCentroLados + cuadrado[n-1][(n-1)/2] + cuadrado[n-1][n/2]; //suma ultima fila
					sumaCentroLados = sumaCentroLados + cuadrado[(n-1)/2][0] + cuadrado[n/2][0];//suma 1a columna
					sumaCentroLados = sumaCentroLados + cuadrado[(n-1)/2][n-1] + cuadrado[n/2][n-1];//suma ultima columna
					
					//sumamos cuatro casillas centrales
					sumaCentro = cuadrado[(n-1)/2][(n-1)/2] + cuadrado[(n-1)/2][n/2] + cuadrado[n/2][(n-1)/2] + cuadrado[n/2][n/2];
					
					if (sumaCentro==cm2 && sumaCentroLados == cm2*2 && sumaEsquinas ==cm2) { //comprobamos si es esoterico
						System.out.println(" Tambi�n es un cuadrado par m�gico esot�rico.");
					}
				} else {
					//sumamos la casilla central de cada lado
					sumaCentroLados =sumaCentroLados + cuadrado[0][(n-1)/2] + cuadrado[(n-1)/2][0] + cuadrado[(n-1)/2][n-1] + cuadrado[n-1][(n-1)/2];
					
					sumaCentro = sumaCentro + cuadrado[(n-1)/2][(n-1)/2]*4;
					
					if (sumaCentro==cm2 && sumaCentroLados ==cm2 && sumaEsquinas ==cm2) { //comprobamos si es esoterico
						System.out.println(" Tembi�n es un cuadrado impar m�gico esot�rico.");
					}
				}
				
				
			} else System.out.println("NO");
		} while (!control);
	}
}
