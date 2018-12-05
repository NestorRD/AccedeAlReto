/*
 * Néstor Romero Díaz
 * Fecha finalización: 15-11-2018
 * Link to challenge: https://www.aceptaelreto.com/problem/statement.php?id=106
 * Programa que dado un código de barras, calcula si este es válido según si es EAN8 O EAN13 y en último caso dice pais de procedencia o Desconocido si se da el caso
 */
package Volumen1;

import java.util.Scanner;

public class act_106_codigoBarras {

	public static void main(String[] args) {
		
		boolean control = false; //Para control del bucle. Solo será true si usuario introduce: 0
		
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Introduce número de barras EAN-8 o EAN-13.");
		System.out.println("Introduce 0 si no quieres introducir más números.");
		
		
		do { //Bucle que se repite hasta que el usuario introduce el número 0
			
			try { //Try para comprobar que el dato introducido es un número.
				
				int [] EAN8 = {0,0,0,0,0,0,0,0}, EAN13 = {0,0,0,0,0,0,0,0,0,0,0,0,0}; //Definimos espacio para almacenar codigos de barra segun su EAN
				String prefijoStr =""; //Obtener prefijos.
				int controlCodigo = 0; //Realizar la suma de comprobación
				boolean par = false; //Saber si el número que sumamos es par o impar para cumplir la formula. Empieza impar debido a que analiza el primer numero despues del control
				String introducido = ""; //Almacenar el número introducido que posteriormente se parsea a int
				byte auxiliar; //Usada para saber la longitud del código introducido
				byte contador13=13, contador8=8; //Contadores para cada EAN
				
				introducido = lector.next();
				auxiliar = (byte) introducido.length();
				
				if (introducido.equalsIgnoreCase("0")) { //Si el valor introducido es un 0, pondrá auxiliar como 0 para finalizar el programa.
					auxiliar = 0;
				}
				
//--------------[EAN-8]-------------------------------------------------------------------------------------------------------------------------------------------------------//
				
				if (auxiliar>0 && auxiliar<=8) {
					for(int i=introducido.length()-1; i>=0; i--) { //Introducimos números en array...
						EAN8[contador8-1]= Byte.parseByte(introducido.valueOf(introducido.charAt(i)));
						contador8--;
					}
					
					for(int i=7; i>=0; i--) { //sumamos los números para la posterior comprobación
						if (i < 7 && par == false) {
							controlCodigo = controlCodigo + (EAN8[i] * 3);
							par = true;
						} else {
							if (i < 7 && par == true) {
								controlCodigo = controlCodigo + (EAN8[i] * 1);
								par = false;
							}
						}
					}
					
					controlCodigo = controlCodigo + EAN8[7]; 
					if (controlCodigo%10 == 0) { //calcular si es correcto o no (SI: es multiplo de 10. N0: no es multiplo de 10)
						System.out.println("SI");
					} else System.out.println("NO");
				}				
				
//--------------[EAN-13]------------------------------------------------------------------------------------------------------------------------------------------------------//

				if (auxiliar>8 && auxiliar<=13) {
					for(int i=introducido.length()-1; i>=0; i--) { //Introducimos números en array...
						EAN13[contador13-1]= Byte.parseByte(introducido.valueOf(introducido.charAt(i)));
						contador13--;
					}
					
					for(int i=12; i>=0; i--) { //sumamos los números para la posterior comprobación
						if (i < 12 && par == false) {
							controlCodigo = controlCodigo + (EAN13[i] * 3);
							par = true;
						} else {
							if (i < 12 && par == true) {
								controlCodigo = controlCodigo + (EAN13[i] * 1);
								par = false;
							}
						}
					}
					
					controlCodigo = controlCodigo + EAN13[12];
					if (controlCodigo%10 == 0) { //calcular si es correcto o no (SI: es multiplo de 10. N0: no es multiplo de 10)
						System.out.print("SI ");
					} else System.out.print("NO ");
					
					StringBuilder prefijo = new StringBuilder(); //Necesario para obtener el prefijo del código de barras
					prefijo.append(EAN13[0]).append(EAN13[1]).append(EAN13[2]);
					prefijoStr = prefijo.toString(); //necesario para comparar como si fuese una tabla.
					
					switch(prefijoStr) {
					case "380": System.out.println("Bulgaria"); break;
					case "539": System.out.println("Irlanda"); break;
					case "560": System.out.println("Portugal"); break;
					case "759": System.out.println("Venezuela"); break;
					case "850": System.out.println("Cuba"); break;
					case "890": System.out.println("India"); break;
					default: //si no está en los anteriores...
						switch(prefijoStr.substring(0, 2)) { //obvia el 3r número
						case "50": System.out.println("Inglaterra"); break;
						case "70": System.out.println("Noruega"); break;
						default: //si no está en los anteriores...
							switch(prefijoStr.substring(0, 1)) { //obvia el 2o número
							case "0": System.out.println("EEUU"); break;
							default: System.out.println("Desconocido"); break; //No está en el sistema
							}
						}
					}					
				}
				
//--------------[Números > EAN-13]--------------------------------------------------------------------------------------------------------------------------------------------//
				
				if (auxiliar>13){
					System.out.println("Error, no es un número válido.");
				}
				
//--------------[FIN PROGRAMA]------------------------------------------------------------------------------------------------------------------------------------------------//
				if (auxiliar == 0) {
					control = true;
					System.out.println("Bye");
				}
				
			} 
			
			catch (Exception e) {
				System.out.println("Error: " + e);
			}
			
		} while (!control);

	}

}
