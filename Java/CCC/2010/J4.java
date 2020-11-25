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
public class GlobalWarming {
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
        while (true){
            int n = s.nextInt();
            if(n==0){
                break;
            }
            int start = s.nextInt();
            int[] diff = new int[n-1];
            for(int i = 0; i<n-1; i++){
                int cur = s.nextInt();
                diff[i] = cur-start;
                start = cur;
            }
            boolean done = true;
            if(n-1==0 || n-1==1){
                System.out.println(n-1);
                continue;
            }
            for(int i = 1; i<n-1; i++){
                done = true;
                for(int j = 0; j<i; j++){
                    for(int k = 1; k<=(n-1)/i; k++){
                        if(j+i*k<n-1 && diff[j]!= diff[j+i*k]){
                            done = false;
                            break;
                        }
                    }
                }
                if(done){
                    System.out.println(i);
                    break;
                }
            }
            if(done==false){
                System.out.println(n-1);
            }
        }
    }
}
