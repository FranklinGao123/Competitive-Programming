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
public class VoronoiVillages {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[] villages = new double[n];
        for(int i = 0; i<n; i++){
            villages[i]=s.nextInt();
        }
        Arrays.sort(villages);
        double[] neighbourhood = new double[n];
        neighbourhood[0]=Integer.MAX_VALUE;
        neighbourhood[n-1]=Integer.MAX_VALUE;
        for(int i = 1; i<n-1; i++){
            neighbourhood[i]=Math.abs((villages[i+1]-villages[i])/2 + (villages[i]-villages[i-1])/2);
        }
        Arrays.sort(neighbourhood);
        System.out.printf("%.1f", neighbourhood[0]);
        
    }
}
