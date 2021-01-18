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
public class AbsolutelyAcidic {

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

    static class pair implements Comparable<pair> {

        int index;
        int num;

        public pair(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(pair o) {
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        pair[] arr = new pair[10001];
        for (int i = 0; i < 10001; i++) {
            arr[i] = new pair(i, 0);
        }
        for (int i = 0; i < n; i++) {
            arr[s.nextInt()].num++;
        }
        Arrays.sort(arr);
        int i = 1;
        boolean ha = false;
        int min = arr[i - 1].index, max = arr[i - 1].index;
        while (arr[i].num == arr[i - 1].num) {
            min = Math.min(min, arr[i].index);
            max = Math.max(max, arr[i].index);
            i++;
            ha = true;
        }
        if (ha) {
            System.out.println(Math.abs(max - min));
        } else {
            i++;
            ha = false;
            int Min = arr[i - 1].index, Max = arr[i - 1].index;
            while (arr[i].num == arr[i - 1].num) {
                Min = Math.min(Min, arr[i].index);
                Max = Math.max(Max, arr[i].index);
                i++;
                ha = true;
            }
            if(ha){
                System.out.println(Math.max(Math.abs(min-Min), Math.abs(min-Max)));
            }else{
                 System.out.println(Math.abs(min-Min));
            }
        }
    }
}
