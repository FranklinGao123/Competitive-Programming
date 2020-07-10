/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author frank
 */
public class Wireless {
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
        int m = s.nextInt();
        int n = s.nextInt();
        diff = new int[m][n];
        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            int x = s.nextInt()-1, y = s.nextInt()-1, r = s.nextInt(), b = s.nextInt();
            for (int j = -r; j <= r; j++) {
                int nextY = y + j;
                if (nextY < 0 || nextY >= m) {
                    continue;
                }
                int gap = (int) Math.sqrt(Math.pow(r, 2) - Math.pow(j, 2));
                int leftX = x - gap;
                int rightX = x + gap + 1;
                diff[nextY][Math.max(0, leftX)] += b;
                if (rightX < n) {
                    diff[nextY][rightX] -= b;
                }
            }
        }

        int best = 0;
        int tally = 0;
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp += diff[i][j];
                if (best < temp) {
                    best = temp;
                    tally = 1;
                } else if (best == temp) {
                    tally++;
                }
            }
        }
        System.out.println(best);
        System.out.println(tally);

    }
}
