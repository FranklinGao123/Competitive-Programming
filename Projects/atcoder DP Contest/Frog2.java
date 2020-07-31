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
public class Frog2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] h = new int[n];
        for (int i = 0; i<n; i++){
            h[i]=s.nextInt();
        }
        int[] cost = new int[n];
        cost[0]=0;
        for(int i = 1; i<n; i++){
            int min = Integer.MAX_VALUE;
            //cost[i] = Math.min(cost[i-2]+Math.abs(h[i]-h[i-2]), cost[i-1]+Math.abs(h[i]-h[i-1]));
            for(int j = k; j>0;j--){
                if(i-j>=0)
                    min = Math.min(cost[i-j]+Math.abs(h[i]-h[i-j]),min);
            }
            cost[i]=min;
        }
        System.out.println(cost[n-1]);
    }
}
