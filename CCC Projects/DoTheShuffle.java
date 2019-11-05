/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotheshuffle;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author frank
 */
public class DoTheShuffle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] CCC = {'A','B','C','D','E',' '};
        while(true){
            int b = s.nextInt();
            int n=s.nextInt();
            if (b==4 && n==1)
                break;
            else{
                for(int u = 0; u<n; u++) {
                    if (b == 1) {
                        CCC[5] = CCC[0];
                        for (int i = 0; i < 5; i++) {
                            CCC[i] = CCC[i + 1];
                        }
                    } else if (b == 2) {
                        for (int i = 5; i > 0; i--) {
                            CCC[i] = CCC[i - 1];
                        }
                        CCC[0] = CCC[5];
                    } else if (b == 3) {
                        char temp = CCC[0];
                        CCC[0] = CCC[1];
                        CCC[1] = temp;
                    }
                }
            }
        }
        System.out.println(CCC[0] + " " + CCC[1] + " " + CCC[2] + " " + CCC[3] + " " + CCC[4]);
    }
}
    

