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
public class Golf {
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
        int dist = s.nextInt();
        int n = s.nextInt();
        int[] club = new int[n];
        int[] dp = new int[dist+1];
        Arrays.fill(dp, 5281);
        dp[0] = 0;
        for(int j = 0; j<n; j++){
            club[j] = s.nextInt();
        }
        for(int j = 0; j<n; j++){
            for(int i= 0; i<=dist; i++){
                if(i >= club[j]){
                    dp[i] = Math.min(dp[i], dp[i-club[j]]+1);
                }
            }
        }
        if(dp[dist]!=5281)
            System.out.printf("Roberta wins in %d strokes.", dp[dist]);
        else{
            System.out.println("Roberta acknowledges defeat.");
        }
        //dp[i] = Math.min(dp[i], dp[i-value[i]]+1;
        
    }
}
