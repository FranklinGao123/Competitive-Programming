/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icon.scaling;
import java.util.Scanner;

/**
 *
 * @author Franklin
 */
public class IconScaling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner (System.in);
   int scale = s.nextInt();
   int p =0;
   int o = 0;
   while (p<scale){
   System.out.println();
   while(o<scale){
     System.out.print("*");
     o++;
     }
     o=0;
      while(o<scale){
       System.out.print("x");
       o++;
       
     }
     o=0;
     while(o<scale){
       System.out.print("*");
       o++;
     }
     o=0;
     p++;
   }
   p=0;
   while (p<scale){
   System.out.println();
   while(o<scale){
     System.out.print(" ");
     o++;
     }
     o=0;
      while(o<scale){
       System.out.print("x");
       o++;
       
     }
     o=0;
     while(o<scale){
       System.out.print("x");
       o++;
     }
     o=0;
     p++;
   }
   p=0;
   while (p<scale){
   System.out.println();
   while(o<scale){
     System.out.print("*");
     o++;
     }
     o=0;
      while(o<scale){
       System.out.print(" ");
       o++;
       
     }
     o=0;
     while(o<scale){
       System.out.print("*");
       o++;
     }
     o=0;
     p++;
   }
    }
    
}
