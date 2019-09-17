/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle.times;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class TriangleTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int first = s.nextInt();
        int second = s.nextInt();
        int third = s.nextInt();
        if(first+second+third!=180){
            System.out.println("Error");
            System.exit(0);
        }
        else if (first==second && second == third)
            System.out.println("Equilateral");
        else if (first!=second && second != third && third != first)
            System.out.println("Scalene");
        else
            System.out.println("Isosceles");
    }
    
}
