/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.*;
import java.io.*;
/**
 *
 * @author frank
 */
public class dmopc18c3p2 {
    public static class FastReader {

        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        float nextFloat() {
            return Float.parseFloat(next());
        }
        
        String nextLine() {
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int[] french = new int[n];
        int[][] dp = new int[2][3];
        for(int i = 0; i <n; i++){
            french[i] = s.nextInt();
        }
        for(int i = 0; i<n; i++){
            int eng = s.nextInt();
            dp[1][0] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]))+eng;
            dp[1][1] = dp[0][0]+ french[i];
            dp[1][2] = dp[0][1] + french[i];
            dp[0] = dp[1].clone();
        }
        System.out.println(Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])));
    }
}
