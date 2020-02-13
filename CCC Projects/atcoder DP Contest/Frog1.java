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
public class Frog1 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] h = new int[n];
        for (int i = 0; i<n; i++){
            h[i]=s.nextInt();
        }
        int[] cost = new int[n];
        cost[0]=0;
        for(int i = 1; i<n; i++){
            cost[i] = cost[i-1]+Math.abs(h[i]-h[i-1]);
            if(i>1)
                cost[i] = Math.min(cost[i-2]+Math.abs(h[i]-h[i-2]), cost[i-1]+Math.abs(h[i]-h[i-1]));
        }
        System.out.println(cost[n-1]);
    }
}
