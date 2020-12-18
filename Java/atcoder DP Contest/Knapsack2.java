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
public class Knapsack2 {
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
        //dp[1][i] = the min weight for value i
        int c = s.nextInt();
        int v = s.nextInt();
        long[][] dp = new long[2][100001];
        Arrays.fill(dp[0],1000000001);
        dp[0][0] = 0;
        for (int i = 1; i<c+1; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            dp[1][0]=0;
            for(int k = 1; k<100001; k++){
                if(k-b<0){
                    dp[1][k]=dp[0][k];
                }else{
                    dp[1][k]=Math.min(dp[0][k], dp[0][k-b]+a);
                }
            } 
            dp[0]=dp[1].clone();
        }
        for(int i = 100000; i>=0; i--){
            if(dp[1][i]<=v){
                System.out.println(i);
                return;
            }
        }
    }
}
