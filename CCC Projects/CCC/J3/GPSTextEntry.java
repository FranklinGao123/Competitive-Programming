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
public class GPSTextEntry {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        char[][] key = {{'A','B','C','D','E','F'},{'G','H','I','J','K','L'},{'M','N','O','P','Q','R'},{'S','T','U','V','W','X'},{'Y','Z',' ','-','.','e'}};
        String word = s.nextLine();
        int sum = 0;
        int[] current = new int[2];
        for(int k = 0; k<word.length(); k++){
            int a = 0;
            int b = 0;
            boolean hi = false;
            for(int i=0; i<5; i++){
                for(int c=0; c<6; c++){
                    if(word.charAt(k)==key[i][c]){
                        a=i;
                        b=c;
                        hi = true;
                        break;
                    }
                }
                if(hi)
                    break;
            }
            sum+= Math.abs(a-current[0]) + Math.abs(b-current[1]);
            current[0] = a;
            current[1] = b;
        }
        sum+= Math.abs(4-current[0]) + Math.abs(5-current[1]);
        System.out.println(sum);
    }
    
    
}


