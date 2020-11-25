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
public class DMOPC14C1P5 {

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

    static class pair {

        int r;
        int c;

        public pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int r = s.nextInt(), c = s.nextInt();
        int startr = s.nextInt(), startc = s.nextInt(), endr = s.nextInt(), endc = s.nextInt();
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String temp = s.next();
            for (int j = 0; j < c; j++) {
                if (temp.charAt(j) == 'X') {
                    map[i][j] = 1;
                }
            }
        }
        int t = s.nextInt();
        pair[] teleport = new pair[t];
        boolean skip = false;
        int a1 = 0;
        for (int i = 0; i < t; i++) {
            int tempr = s.nextInt(), tempc = s.nextInt();
            teleport[i] = new pair(tempr, tempc);
            if(tempr==startr && tempc==startc){
                skip = true;
            }
        }
        LinkedList<Integer> rq = new LinkedList<Integer>();
        LinkedList<Integer> cq = new LinkedList<Integer>();
        rq.add(startr);
        cq.add(startc);
        int[][] step = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(step[i], Integer.MAX_VALUE);
        }
        step[startr][startc] = 0;
        if(skip==false){
        while (!rq.isEmpty()) {
            int cr = rq.poll();
            int cc = cq.poll();
            boolean[] tel = new boolean[4];
            if (cr > 0 && map[cr - 1][cc] == 0 && step[cr - 1][cc] > step[cr][cc] + 1) {
                for (int i = 0; i < t; i++) {
                    if (teleport[i].r == cr - 1 && teleport[i].c == cc) {
                        tel[0] = true;
                        if (step[endr][endc] > step[cr][cc] + 1) {
                            step[endr][endc] = step[cr][cc] + 1;
                        }
                        break;
                    }
                }
                if (tel[0] == false) {
                    step[cr - 1][cc] = step[cr][cc] + 1;
                    rq.add(cr - 1);
                    cq.add(cc);
                }
            }
            if (cr < r - 1 && map[cr + 1][cc] == 0 && step[cr + 1][cc] > step[cr][cc] + 1) {
                for (int i = 0; i < t; i++) {
                    if (teleport[i].r == cr + 1 && teleport[i].c == cc) {
                        tel[1] = true;
                        if (step[endr][endc] > step[cr][cc] + 1) {
                            step[endr][endc] = step[cr][cc] + 1;
                        }
                        break;
                    }
                }
                if (tel[1] == false) {
                    step[cr + 1][cc] = step[cr][cc] + 1;
                    rq.add(cr + 1);
                    cq.add(cc);
                }
            }
            if (cc > 0 && map[cr][cc - 1] == 0 && step[cr][cc - 1] > step[cr][cc] + 1) {
                for (int i = 0; i < t; i++) {
                    if (teleport[i].r == cr && teleport[i].c == cc - 1) {
                        tel[2] = true;
                        if (step[endr][endc] > step[cr][cc] + 1) {
                            step[endr][endc] = step[cr][cc] + 1;
                        }
                        break;
                    }
                }
                if (tel[2] == false) {
                    step[cr][cc - 1] = step[cr][cc] + 1;
                    rq.add(cr);
                    cq.add(cc - 1);
                }
            }
            if (cc < c - 1 && map[cr][cc + 1] == 0 && step[cr][cc + 1] > step[cr][cc] + 1) {
                for (int i = 0; i < t; i++) {
                    if (teleport[i].r == cr && teleport[i].c == cc + 1) {
                        tel[3] = true;
                        if (step[endr][endc] > step[cr][cc] + 1) {
                            step[endr][endc] = step[cr][cc] + 1;
                        }
                        break;
                    }
                }
                if (tel[3] == false) {
                    step[cr][cc + 1] = step[cr][cc] + 1;
                    rq.add(cr);
                    cq.add(cc + 1);
                }
            }
            if(step[endr][endc]!=Integer.MAX_VALUE){
                break;
            }
        }
        a1 = step[endr][endc];
        rq = new LinkedList<Integer>();
        cq = new LinkedList<Integer>();
        rq.add(startr);
        cq.add(startc);
        step = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(step[i], Integer.MAX_VALUE);

        }
        step[startr][startc] = 0;
        }
        while (!rq.isEmpty()) {
            int cr = rq.poll();
            int cc = cq.poll();
            boolean[] tel = new boolean[4];
            if (cr > 0 && map[cr - 1][cc] == 0 && step[cr - 1][cc] > step[cr][cc] + 1) {
                step[cr - 1][cc] = step[cr][cc] + 1;
                rq.add(cr - 1);
                cq.add(cc);
            }
            if (cr < r - 1 && map[cr + 1][cc] == 0 && step[cr + 1][cc] > step[cr][cc] + 1) {
                step[cr + 1][cc] = step[cr][cc] + 1;
                rq.add(cr + 1);
                cq.add(cc);
            }
            if (cc > 0 && map[cr][cc - 1] == 0 && step[cr][cc - 1] > step[cr][cc] + 1) {
                step[cr][cc - 1] = step[cr][cc] + 1;
                rq.add(cr);
                cq.add(cc - 1);
            }
            if (cc < c - 1 && map[cr][cc + 1] == 0 && step[cr][cc + 1] > step[cr][cc] + 1) {
                step[cr][cc + 1] = step[cr][cc] + 1;
                rq.add(cr);
                cq.add(cc + 1);
            }
            if(step[endr][endc]!=Integer.MAX_VALUE){
                break;
            }
        }
        int a2 = step[endr][endc];
        System.out.println(a2 - a1);

    }
}
