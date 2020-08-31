/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgdouble.dice;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class DoubleDice {

    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int rounds = s.nextInt();
    int i=0;
    int A = 100;
    int D = 100;
    Scanner scanner = new Scanner(System.in);

    while(i<rounds)
    {
        int[] integers = new int[3];
        for(int k = 0; k <= 1; k++)
        {
            integers[k] = s.nextInt();
        }
        
        if (integers[0]<integers[1])
            A-=integers[1];
        if (integers[0]>integers[1])
            D-=integers[0];
        if (integers[0]==integers[1])
        {
        }
        i++;
        
    }
    System.out.println(A);
    System.out.println(D);
    }
    
}
