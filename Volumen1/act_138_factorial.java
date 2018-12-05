/*
 * Néstor Romero Díaz
 * Fecha finalización: 05-12-2018
 * Link to challenge: https://www.aceptaelreto.com/problem/statement.php?id=138
 * Programa para calcular el numero de 0 que tiene al final el factorial de un numero
 */
package Volumen1;
import java.util.*;

public class act_138_factorial {

    public static void main(String[] args) {
    	
        boolean control = false; //control de flujo
        int entradas=0; //para saber total de numeros a calcular
        int contador = 0; //para saber cuantos numeros hay calculados
        
        Scanner lector = new Scanner(System.in);
        
        //Introduccion de entradas.
        try{
                System.out.println("Introduce numero de entradas total:");
                entradas = lector.nextInt();
            }
            catch(Exception err){
                System.out.println("Error en la introduccion.");
            }
        
        //Calculo de ceros.
        do{
            int numero = 0; //numero que introduce usuario
            int ceroFactorial = 0; //donde se suma numero de ceros
            
            //Introduccion de numero.
            try{
                System.out.println("Introduce numero:");
                numero = lector.nextInt();
            }
            catch(Exception err){
                System.out.println("Error en la introduccion.");
            }
            
            //Para saber cuantos 0 tiene el factorial de un numero, es necesario dividir entre 5 el numero obtenido.
            //Si ese resultado es mayor que 5, se vuelve a dividir entre 5 hasta que el numero sea menor que 5.
            //Todos los resultados de las divisiones (sin contar el resto) se suman.
            //El total de la suma de todas las divisiones es el total de ceros que contiene el factorial de un numero.
            while(!control) {
            	numero = numero/5;
            	ceroFactorial= ceroFactorial+numero;
            	
            	if(numero<5) {
            		control = true;
            	}
            }
            control=false;
            System.out.println(ceroFactorial); //SALIDA
     
            contador++; //suma un contador por entrada calculada    
            if(contador == entradas){ //si contador llega a numero de entradas totales... programa acabado
                control=true;
            }
            
        } while(!control);
        
        System.out.println("bye");
                
    }
    
}
