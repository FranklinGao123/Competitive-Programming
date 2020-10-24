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
public class Unfriend {

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

    static int[] num = new int[7];
    static ArrayList<Integer>[] map = new ArrayList[7];

    static void dfs(int v) {
        num[v] = 1;
        if (map[v] != null) {
            for (int i : map[v]) {
                dfs(i);
                num[v] *= num[i] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        for (int i = 1; i < n; i++) {
            int temp = s.nextInt();
            if (map[temp] == null) {
                map[temp] = new ArrayList<Integer>();
            }
            map[temp].add(i);
        }
        dfs(n);
        System.out.println(num[n]);
    }
}
