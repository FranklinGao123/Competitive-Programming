/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
//Binary Index Tree Test
import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class ds1 {

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

    static int n;
    static int MM = 100005;
    static int[] arr = new int[MM];
    static long[] BIT = new long[MM];
    static long[] BIT2 = new long[MM];

    static long query(int x, long[] BIT) {
        long ret = 0;
        for (int i = x; i!=0; i -= (i & -i)) {
            ret += BIT[i];
        }
        return ret;
    }

    static void update(int x, int v, long[] BIT) { //X is the index    Y is the amount you want to update by
        for (int i = x; i <= MM; i += (i & -i)) {
            BIT[i] += v;
        }
    }


    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        n = s.nextInt();
        long m = s.nextLong();
        for (int i = 1; i < n+1; i++) {
            arr[i] = s.nextInt();
            update(i, arr[i], BIT);
            update(arr[i], 1, BIT2);
        }
        for (long i = 0; i < m; i++) {
            String temp = s.next();
            if (temp.equals("C")) {
                int x = s.nextInt(), v = s.nextInt();
                update(x, v - arr[x], BIT);
                update(arr[x], -1, BIT2);
                update(v, 1, BIT2);
                arr[x] = v;

            } else if (temp.equals("S")) {
                int l = s.nextInt(), r = s.nextInt();
                System.out.println(query(r, BIT) - query(l - 1, BIT));
            } else {
                int v = s.nextInt();
                System.out.println(query(v, BIT2));
            }
        }

    }
}



