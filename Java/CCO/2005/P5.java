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
public class Segments {

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
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int left = 0, right = 0;
        boolean l = true, r = false;
        int LPrev = 1, RPrev = 1;
        for (int i = 0; i < n; i++) {
            // System.out.println(l+" "+r);
            int from = sc.nextInt(), to = sc.nextInt(), tempr = 1000000000, templ = 1000000000;
            boolean tl = false, tr = false;
            if (i == n - 1) {
                to = n;
            }
            if (l) {
                if (LPrev <= from) {
                    tr = true;
                    tempr = left + Math.abs(LPrev - to);
                } else if (LPrev >= to) {
                    tl = true;
                    templ = left + Math.abs(LPrev - from);
                } else {
                    tl = true;
                    templ = left + Math.abs(LPrev - to) + Math.abs(to - from);
                    tr = true;
                    tempr = left + Math.abs(LPrev - from) + Math.abs(to - from);
                }
            }
            if (r) {
                if (RPrev <= from) {
                    tr = true;
                    tempr = Math.min(tempr, right + Math.abs(RPrev - to));
                } else if (RPrev >= to) {
                    tl = true;
                    templ = Math.min(templ, right + Math.abs(RPrev - from));
                } else {
                    tl = true;
                    templ = Math.min(templ, right + Math.abs(RPrev - to) + Math.abs(to - from));
                    tr = true;
                    tempr = Math.min(tempr, right + Math.abs(RPrev - from) + Math.abs(to - from));
                }
            }
            l = false;
            r = false;
            if (tl) {
                l = true;
                left = templ;
            }
            if (tr) {
                r = true;
                right = tempr;
            }
            LPrev = from;
            RPrev = to;
            // System.out.println(left+" "+right);
        }
        right += n - 1;
        left += n - 1 + Math.abs(LPrev - n);
        if (l && r) {
            System.out.println(Math.min(right, left));
        } else if (l) {
            System.out.println(left);
        } else {
            System.out.println(right);
        }
    }
}
