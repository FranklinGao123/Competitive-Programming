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
public class Knapsack1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        int v = s.nextInt();
        long[][] dp = new long[2][v+1];
        Arrays.fill(dp[0],0);
        for (int i = 1; i<c+1; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            dp[1][0]=0;
            for(int k = 1; k<v+1; k++){
                if(k-a<0){
                    dp[1][k]=dp[0][k];
                }else{
                    dp[1][k]=Math.max(dp[0][k], dp[0][k-a]+b);
                }
            } 
            dp[0]=dp[1].clone();
        }
        System.out.println(dp[1][v]);
    }
}
