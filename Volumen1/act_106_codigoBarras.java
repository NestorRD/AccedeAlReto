package Volumen1;
import java.util.Scanner;
public class act_106_codigoBarras {

	public static void main(String[] args) {
		boolean control = false;
		
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Introduce número de barras EAN-8 o EAN-13.");
		System.out.println("Introduce 0 si no quieres introducir más números.");
		
		do {
			try {
				int [] EAN8 = {0,0,0,0,0,0,0,0}, EAN13 = {0,0,0,0,0,0,0,0,0,0,0,0,0};
				String introducido = "";
				byte auxiliar;
				byte contador13=13, contador8=8;
				introducido = lector.next();
				auxiliar = (byte) introducido.length();
				
				if (auxiliar<=8) {
					for(int i=introducido.length()-1; i>=0; i--) {
						EAN8[contador8-1]= Byte.parseByte(introducido.valueOf(introducido.charAt(i)));
						contador8--;
					}
					for(int i=0; i<EAN8.length; i++) {
						System.out.print(EAN8[i]);
					}
					System.out.println();
				}
				
				if (auxiliar>8 && auxiliar<=13) {
					for(int i=introducido.length()-1; i>=0; i--) {
						EAN13[contador13-1]= Byte.parseByte(introducido.valueOf(introducido.charAt(i)));
						contador13--;
					}
					for(int i=0; i<EAN13.length; i++) {
						System.out.print(EAN13[i]);
					}
					System.out.println();
				} 
				
				if (auxiliar>13){
					System.out.println("Error, no es un número válido.");
				}
				if (auxiliar == 0) {
					control = true;
				}
			} 
			catch (Exception e) {
				System.out.println("Error, introduce número" + e);
			}
		} while (!control);

	}

}
