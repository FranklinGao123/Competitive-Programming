/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.*;
/**
 *
 * @author frank
 */
public class HighTideLowTide {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] tide = new int[n];
        int[] Ltide = new int[n/2];
        int[] Htide = new int[n/2];
        for(int i = 0; i<n; i++){
            tide[i] = s.nextInt();
        }
        Arrays.sort(tide);
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                System.out.print(tide[n/2-i-1] + " ");
                System.out.print(tide[n/2+i] + " ");
               
            }
        }else{
            for(int i=0; i<n/2; i++){
                System.out.print(tide[n/2-i] + " ");
                System.out.print(tide[n/2+i+1] + " ");
            }
            System.out.println(tide[0]);
        }
    }
}
