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
public class dmopc18c2p4 {

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
        long m = s.nextLong();
        long[] dam = new long[n];
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            dam[i] = s.nextLong();
        }
        int length = 500001;
        long sum = dam[0];
        while (start <= end) {
            if (sum >= m) {
                length = Math.min(length, end - start + 1);
                sum -= dam[start];
                start++;
            } else {
                end++;
                if (end >= n) {
                    break;
                }
                sum += dam[end];
            }
        }
        if (length == 500001) {
            System.out.println("-1");
        } else {
            System.out.println(length);
        }

    }
}
