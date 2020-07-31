/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.s.cold.here;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class ItSColdHere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int h = 0;
        int hi = 200;
        String hi2 ="";
        String[] Temps = new String[10000];
        String[] parts;
        while (h<10000){
            Temps[h] = s.nextLine();
            parts = Temps[h].split("\\s+");
            System.out.println(parts[0]);
            int k = Integer.valueOf(parts[1]);
            if (k<hi) {
                hi2=parts[0]; 
                hi=k;
            }
            if ("Waterloo".equals(parts[0])){
                
                break;
            }
        }
        System.out.println(hi2);
    }
    
}
