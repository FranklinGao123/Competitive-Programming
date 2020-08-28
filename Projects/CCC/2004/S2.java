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
public class TopYodeller {
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
        int n = s.nextInt(), k = s.nextInt();
        int[] worst = new int[n];
        int[] score = new int[n];
        LinkedList<Integer> place = new LinkedList<Integer>();
        int max = 0;
        for(int i = 0; i<k; i++){
            max = Integer.MIN_VALUE;
            for(int j = 0; j<n; j++){
                score[j] += s.nextInt();
                place.add(score[j]);
                max = Math.max(max, score[j]);
            }
            Collections.sort(place, Collections.reverseOrder());
            for(int j = 0; j<n; j++){
                worst[j] = Math.max(worst[j], place.indexOf(score[j])+1);
            }
            place.clear();
        }
        for(int i = 0; i<n; i++){
            if(score[i]==max)
                System.out.printf("Yodeller %d is the TopYodeller: score %d, worst rank %d\n", i+1, score[i], worst[i]);
        }
        
        
    }
}
