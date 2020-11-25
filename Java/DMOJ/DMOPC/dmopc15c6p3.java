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
public class dmopc15c6p3 {

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
    static int[][] diff;

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int m = s.nextInt();
        long k = s.nextLong();
        if (k == 0) {
            System.out.println("0");
            return;
        }
        int[] diff = new int[n + 1];
        diff[0] = m;
        diff[n] = -m;
        for (int i = 0; i < m; i++) {
            int a = s.nextInt() - 1, b = s.nextInt() - 1;
            diff[a]--;
            diff[b + 1]++;
        }
        int prev = 0;
        for (int i = 0; i < n; i++) {
            prev += diff[i];
            diff[i] = prev;
        }
        int min = 0;
        int max = 0;
        long sum = diff[0];
        int output = 300000;
        while (min <= max) {
            if (sum >= k) {
                output = Math.min(output, max - min + 1);
                sum -= diff[min];
                min++;
            } else {
                max++;
                if (max >= n) {
                    break;
                }
                sum += diff[max];
            }
        }
        if (output == 300000) {
            System.out.println("-1");
        } else {
            System.out.println(output);
        }

    }
}
