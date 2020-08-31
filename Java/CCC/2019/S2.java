/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author frank
 */
public class PrettyAveragePrimes {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0; i<t; i++){
            int n = s.nextInt();
            for(int a=2; a<n; a++){
                if(prime(a)&&prime(2*n-a)){
                    System.out.print(a);
                    System.out.print(" ");
                    System.out.println(2*n-a);
                    break;
                }
            }
        }
       
       
    }
   
    public static boolean prime(int n){
        if(n%2==0 || n==1)
            return false;
        else{
            for(int i = 3; i<Math.sqrt(n)+1; i+=2){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    
    
}
