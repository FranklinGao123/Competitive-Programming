/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbangsecrets;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class BigBangSecrets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String j = s.nextLine();
            String cipher = s.nextLine();
            int k = Integer.valueOf(j);
            String poop = "";
            for(int i=0; i<cipher.length(); i++){
                int shift = (3*(i+1)) + k;
                int l = (int)cipher.charAt(i) - 64;
                int a = l - shift;

                while (a<1){
                    a = a + 26;
                }
                poop = poop + (char)(a + 64);
            }
            System.out.println(poop);
        
    }
    
}
