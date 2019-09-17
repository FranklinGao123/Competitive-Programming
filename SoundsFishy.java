/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sounds.fishy;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class SoundsFishy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        
        if (a==b && b==c && c==d)
            System.out.println("Fish At Constant Depth");
        else if(a<b && b<c && c<d)
            System.out.println("Fish Rising");
        else if(a>b && b>c &&c >d)
            System.out.println("Fish Diving");
        else
            System.out.println("No Fish");
        
    }
    
}
