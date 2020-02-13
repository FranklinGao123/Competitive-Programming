/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combining.riceballs;
import java.util.*;
import java.io.*;

public class CombiningRiceballs{
    
    public static void main(String[]args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
        Integer N = Integer.parseInt(bf.readLine());
        int [] ai = new int [N];
        StringTokenizer st = new StringTokenizer (bf.readLine());
        for(int i = 0; i < N; i++)
            ai[i] = Integer.parseInt(st.nextToken());
        int [][] dp = new int [N][N];
        int out = Integer.MIN_VALUE;
        for(int i = N - 1; i >= 0; i--) {
            for(int j = i; j < N; j++) {
                if(i == j) dp[i][j] = ai[i];
                else {
                    for(int i1 = i, i2 = j; i1 < i2;) {
                        if(dp[i][i1] > dp[i2][j]) i2 --;
                        else if(dp[i][i1] < dp[i2][j]) i1 ++;
                        else if(dp[i][i1] == dp[i2][j]) {
                            if(dp[i][i1] == 0) {
                                i2 --; i1 ++;
                            }
                            else {
                                if(i1 + 1 == i2) dp[i][j] = 2 * dp[i][i1];
                                else if(dp[i1 + 1][i2 - 1] != 0) dp[i][j] = 2 * dp[i][i1] + dp[i1 + 1][i2 - 1];
                                else {
                                    i2--; i1 ++;
                                }
                            }
                        }
                        else {
                            i2--; i1 ++;
                        }
                        if(dp[i][j] != 0) break;
                    }
                }
                out = Math.max(out, dp[i][j]);
            }
        }
        System.out.println(out);
    }
}