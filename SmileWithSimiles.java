/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smile.with.similes;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class SmileWithSimiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner (System.in);
   String adjectives=s.nextLine();
   String nouns = s.nextLine();
   int a = Integer.valueOf(adjectives);
   int n = Integer.valueOf(nouns);
   int i =1;
   String[] adjective= new String[6];
   String[] noun= new String[6];
   while(i<=a){
     adjective[i]=s.nextLine();
     i++;
   }
   i=1;
   while(i<=n){
     noun[i]=s.nextLine();
     i++;
   }
   i=1;
   int p =1;
   while (i<=a){
     while (p<=n){
       System.out.println(adjective[i]+" as "+noun[p]);
       p++;
     }
     p=1;
     i++;
    }
    }
}
