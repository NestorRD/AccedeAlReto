/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Volumen1;
import java.util.*;
/**
 *
 * @author AlumnoDAM
 */
public class vol1_act138_factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean control = false;
        int entradas=0, contador=0;
        Scanner lector = new Scanner(System.in);
        
        try{//Introducción de entradas.
                System.out.println("Introduce numero de entradas total:");
                entradas = lector.nextInt();
            }
            catch(Exception err){
                System.out.println("Error en la introducción.");
            }
        
        do{
            int factorial=0, numero=0;
            String auxiliar;
            
            try{//Introducción de entradas.
                System.out.println("Introduce numero:");
                factorial = lector.nextInt();
                numero = factorial -1;
            }
            catch(Exception err){
                System.out.println("Error en la introducción.");
            }
            
            while ( numero!=0) {
            factorial=factorial*numero;
            numero--;
            }
            System.out.println(factorial);
            auxiliar = Integer.toString(factorial);
            //for(int i=0; i<)
            
            
            contador++;    
            if(contador == entradas){
                control=true;
            }        
        } while(!control);
        System.out.println("bye");
                
    }
    
}
