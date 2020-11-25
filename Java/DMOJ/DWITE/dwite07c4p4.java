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
public class dwite07c4p4 {

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
        for (int p = 0; p < 5; p++) {
            int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
            int[][] map = new int[10][10];
            boolean first = true;
            for (int i = 0; i < 10; i++) {
                String temp = s.next();
                for (int j = 0; j < 10; j++) {
                    if (temp.charAt(j) == '#') {
                        map[i][j] = 1;
                    }
                    if (temp.charAt(j) == 'X') {
                        if (first) {
                            r1 = i;
                            c1 = j;
                            first = false;
                        } else {
                            r2 = i;
                            c2 = j;
                        }
                    }
                }
            }
            LinkedList<Integer> rq = new LinkedList<Integer>();
            rq.add(r1);
            LinkedList<Integer> cq = new LinkedList<Integer>();
            cq.add(c1);
            int[][] step = new int[10][10];
            for (int i = 0; i < 10; i++) {
                Arrays.fill(step[i], Integer.MAX_VALUE);
            }
            step[r1][c1] = 0;
            while (!rq.isEmpty()) {
                int rc = rq.poll();
                int cc = cq.poll();
                if (cc > 0 && map[rc][cc - 1] == 0 && step[rc][cc - 1] > step[rc][cc] + 1) {
                    rq.add(rc);
                    cq.add(cc - 1);
                    step[rc][cc - 1] = step[rc][cc] + 1;
                }
                if (cc < 9 && map[rc][cc + 1] == 0 && step[rc][cc + 1] > step[rc][cc] + 1) {
                    rq.add(rc);
                    cq.add(cc + 1);
                    step[rc][cc + 1] = step[rc][cc] + 1;
                }
                if (rc > 0 && map[rc - 1][cc] == 0 && step[rc - 1][cc] > step[rc][cc] + 1) {
                    rq.add(rc - 1);
                    cq.add(cc);
                    step[rc - 1][cc] = step[rc][cc] + 1;
                }
                if (rc < 9 && map[rc + 1][cc] == 0 && step[rc + 1][cc] > step[rc][cc] + 1) {
                    rq.add(rc + 1);
                    cq.add(cc);
                    step[rc + 1][cc] = step[rc][cc] + 1;
                }
                if (cc > 0 && rc > 0 && map[rc - 1][cc - 1] == 0 && step[rc - 1][cc - 1] > step[rc][cc] + 1) {
                    rq.add(rc - 1);
                    cq.add(cc - 1);
                    step[rc - 1][cc - 1] = step[rc][cc] + 1;
                }
                if (cc < 9 && rc < 9 && map[rc + 1][cc + 1] == 0 && step[rc + 1][cc + 1] > step[rc][cc] + 1) {
                    rq.add(rc + 1);
                    cq.add(cc + 1);
                    step[rc + 1][cc + 1] = step[rc][cc] + 1;
                }
                if (cc > 0 && rc < 9 && map[rc + 1][cc - 1] == 0 && step[rc + 1][cc - 1] > step[rc][cc] + 1) {
                    rq.add(rc + 1);
                    cq.add(cc - 1);
                    step[rc + 1][cc - 1] = step[rc][cc] + 1;
                }
                if (cc < 9 && rc > 0 && map[rc - 1][cc + 1] == 0 && step[rc - 1][cc + 1] > step[rc][cc] + 1) {
                    rq.add(rc - 1);
                    cq.add(cc + 1);
                    step[rc - 1][cc + 1] = step[rc][cc] + 1;
                }
            }
            System.out.println(step[r2][c2]);
            s.next();
        }
    }
}
