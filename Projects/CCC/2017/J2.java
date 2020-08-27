/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shifty.sum;
import java.util.Scanner;

/**
 *
 * @author Franklin
 */
public class ShiftySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int total = n;
        for(int i = 0; i<k; i++){
            total+=n*10;
            n*=10;
            
        }
        System.out.println(total);
        
    }
    
}
