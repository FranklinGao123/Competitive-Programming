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
public class gfssoc2j5 {
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
        int n = s.nextInt(), q = s.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i<=n; i++){
            a[i] = s.nextInt();
        }
        int[] pfx = new int[n+1];
        int[] pCount = new int[n+1];
        for(int i = 1; i<=n; i++){
            if(pfx[i-1]<a[i]){
                pfx[i] = a[i];
                pCount[i] = 1;
            }else if(pfx[i-1] == a[i]){
                pCount[i] = pCount[i-1]+1;
                pfx[i] = pfx[i-1];
            }else{
                pfx[i] = pfx[i-1];
                pCount[i] = pCount[i-1];
            }
        }
        int[] sfx = new int[n+2];
        int[] sCount = new int[n+2];
        for(int i = n; i>=1; i--){
            if(sfx[i+1]<a[i]){
                sfx[i] = a[i];
                sCount[i] = 1;
            }else if(sfx[i+1] == a[i]){
                sCount[i] = sCount[i+1]+1;
                sfx[i] = sfx[i+1];
            }else{
                sfx[i] = sfx[i+1];
                sCount[i] = sCount[i+1];
            }
        }
        for(int i = 0; i<q; i++){
            int start = s.nextInt(), end = s.nextInt();
            if(pfx[start-1]==sfx[end+1]){
                System.out.println(pfx[start-1]+" "+(pCount[start-1]+sCount[end+1]));
            }else if(pfx[start-1]<sfx[end+1]){
                System.out.println(sfx[end+1]+" "+sCount[end+1]);
            }else{
                System.out.println(pfx[start-1]+" "+pCount[start-1]);
            }
        }
    }
}
