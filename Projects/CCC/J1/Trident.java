/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trident;

import java.util.Scanner;

/**
 *
 * @author Franklin
 */
public class Trident {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
   int n = s.nextInt();
   int k = s.nextInt();
   int h = s.nextInt();
   for (int q=0; q<n; q++){
     System.out.print("*");
     for(int e=0; e<2;e++){
     for(int w=0;w<k;w++){
       System.out.print(" ");
     }
     System.out.print("*");
     
     }
     System.out.println(" ");
     
   }
   for(int r =0; r<3+(k*2);r++){
     System.out.print("*");
   }
     
   for(int t=0;t<h;t++){
     System.out.println("");
     for(int y=0;y<1+k;y++){
       System.out.print(" ");
     }
     System.out.print("*");
   }
    }
    
}
