/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrant.selection;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class QuadrantSelection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int p = s.nextInt();
        if(i>0 && p>0)
            System.out.println("1");
        if(i<0 && p>0)
            System.out.println("2");
        if(i<0 && p<0)
            System.out.println("3");
        if(i>0 && p<0)
            System.out.println("4");
    }
    
}
