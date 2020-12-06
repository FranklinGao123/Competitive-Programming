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
public class dmopc20c2p2 {
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
        int n = s.nextInt(), m = s.nextInt();
        int[] scarf = new int[n];
        int[] start = new int[1000001];
        Arrays.fill(start, Integer.MAX_VALUE);
        int[] end = new int[1000001];
        Arrays.fill(end, -1);
        for(int i = 0; i<n; i++){
            scarf[i] = s.nextInt();
        }
        for(int i = 0; i<n; i++){
            start[scarf[i]] = Math.min(start[scarf[i]], i);
            end[scarf[n-i-1]] = Math.max(end[scarf[n-i-1]], n-i-1);
        }
        int max = 0;
        for(int i = 0; i<m; i++){
            int a= s.nextInt(), b = s.nextInt();
            if(end[b]==-1 || start[a] == Integer.MAX_VALUE)
                continue;
            max = Math.max(max, end[b]-start[a]+1);
        }
        System.out.println(max);
    }
}
