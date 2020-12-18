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
public class dmpg19s6 {

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
        FastReader sc = new FastReader();
        int n = sc.nextInt(), q = sc.nextInt();
        int[] psa = new int[n + 1];
        TreeSet<Integer> ones = new TreeSet<>();
        psa[0] = 0;
        for (int i = 1; i <= n; i++) {
            int next = sc.nextInt();
            psa[i] = next + psa[i - 1];
            if (next == 1) {
                ones.add(i);
            }
        }
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt(), val = sc.nextInt();
            int sum = psa[r] - psa[l - 1];
            if (sum < val) {
                System.out.println("NO");
            } else if ((val - sum) % 2 == 0) {
                System.out.println("YES");
            } else {
                Integer low = ones.higher(l - 1);
                Integer high = ones.lower(r + 1);
                if (low != null && low <= r && psa[r] - psa[low - 1] >= val) {
                    System.out.println("YES");
                } else if (high != null && high >= l && psa[high] - psa[l - 1] >= val) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
