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
public class SideScrollingSimulator {

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
        for(int u = 0; u<10; u++){
        int J = fr.nextInt();
        int W = fr.nextInt();
        int H = fr.nextInt();
        int start = -1;
        int end = -1;
        char[][] grid = new char[H][W];
        for (int i = H - 1; i >= 0; i--) {
            String next = fr.next();
            grid[i] = next.toCharArray();
            if (i == 1) {
                start = next.indexOf('L');
                end = next.indexOf('G');
            }
        }
        start++;
        for (; start < W; start++) {
            if (start == end) {
                System.out.println("CLEAR");
                break;
            } else if (grid[1][start] == '.') {
                continue;
            } else {
                boolean success = false;
                for (int j = 1; j < H && j <= 1 + J && grid[j][start + 1] != '@' && grid[j][start - 1] != '@'; j++) {
                    if (grid[j][start] == '.') {
                        success = true;
                        break;
                    }
                }
                if (!success) {
                    System.out.println(start + 1);
                    break;
                }
            }
        }
        }
    }
}
