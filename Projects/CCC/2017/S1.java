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
public class SumGame {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] swifts = new int[n];
        int[] k = new int[n];
        int a = 0;
        int b = 0;
        for(int i = 0; i<n; i++){
            swifts[i]=s.nextInt();
        }
        int[] semaphores = new int[n];
        for(int i = 0; i<n; i++){
            semaphores[i]=s.nextInt();
        }
        for(int i = 0; i<n; i++){
            a += swifts[i];
            b += semaphores[i];
            if(a==b){
                k[i]=i+1;
            }
        }
        Arrays.sort(k);
        System.out.println(k[n-1]);
    }
}
