/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipper;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class Flipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        int a =1;
        int b =2;
        int c =3;
        int d=4;
        int e;
        int f;
        for(int i = 0; i<string.length(); i++ ){
            if(string.charAt(i)=='H'){
                e=a;
                f=b;
                a=c;
                b=d;
                c=e;
                d=f;
                
            }else{
                e=a;
                f=c;
                a=b;
                c=d;
                b=e;
                d=f;
            }
        }
        System.out.println(a + " " + b);
        System.out.println(c + " " + d);
        
    }
    
}
