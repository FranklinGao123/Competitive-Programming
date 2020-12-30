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
public class ccc96s1 {
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
        for(int i = 0; i<n; i++){
            int temp = s.nextInt();
            int sum = 0;
            for(int j = 1; j<Math.sqrt(temp); j++){
                if(temp%j==0){
                    sum+=temp/j;
                    sum+=j;
                }
            }
            sum-=temp;
            if(sum<temp){
                System.out.printf("%d is a deficient number.\n", temp);
            }else if(sum== temp){
                System.out.printf("%d is a perfect number.\n", temp);
            }else{
                System.out.printf("%d is a abundant number.\n", temp);
            }
        }
    }
}
