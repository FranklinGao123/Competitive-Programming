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
public class ModernArt {
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
        int m = s.nextInt(), n = s.nextInt();
        int[] row = new int[m];
        int[] col = new int[n];
        int k = s.nextInt();
        int rows = 0;
        int cols = 0;
        for(int i = 0; i<k; i++){
            String temp = s.next();
            int j = s.nextInt()-1;
            if(temp.equals("R")){
                row[j]++;
            }else{
                col[j]++;
            }
        }
        int intersection = 0;
        for(int i = 0; i<m; i++){
            if(row[i]%2 != 0){
                rows++;
            }
        }
        for(int i = 0; i<n; i++){
            if(col[i]%2 != 0){
                cols++;
            }
        }
        System.out.println(cols*m+rows*n - rows*cols*2);
        
        

    }
}
