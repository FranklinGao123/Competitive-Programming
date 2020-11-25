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
public class dmopc14c2p4 {
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] arr = new int[n + 1];// Prefix Sum Array
        for (int i = 1; i <= n; i++) {
            arr[i] = fr.nextInt();
            arr[i] += arr[i - 1];
        }
        int q = fr.nextInt();
        for (int i = 0; i < q; i++) {
            int l = fr.nextInt(), r = fr.nextInt();
            System.out.println(arr[r + 1] - arr[l]);
        }
    }
}
