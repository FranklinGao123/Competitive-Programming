/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class RotatingLetters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String sign = s.nextLine();
        boolean yes = true;
        for(int i = 0; i < sign.length(); i++){
            if(sign.charAt(i) != 'I' && sign.charAt(i) != 'O' && sign.charAt(i) != 'S' && sign.charAt(i) != 'H' && sign.charAt(i) != 'Z' && sign.charAt(i) != 'X' && sign.charAt(i) != 'N'){
                yes = false;
                break;
            }

        }
        if (yes == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
