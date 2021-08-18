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
public class gfssoc1j5 {

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
        int n = s.nextInt(), m = s.nextInt(), t = s.nextInt();
        ArrayList<Integer>[] map = new ArrayList[n];
        for(int i = 0; i<n; i++){
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int a = s.nextInt()-1, b = s.nextInt()-1;
            map[a].add(b);
        }
        int[][] step = new int[n][n];
        for(int j = 0; j<n; j++){
            Arrays.fill(step[j], Integer.MAX_VALUE);
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(j);
            step[j][j] = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if(map[cur].size() == 0){
                    continue;
                }
                for(int i: map[cur]){
                    if(step[j][i]>step[j][cur]+t){
                        queue.add(i);
                        step[j][i] = step[j][cur]+t;
                    }
                }
            }
        }
        int q = s.nextInt();
        for (int p = 0; p < q; p++) {
            int a = s.nextInt()-1, b = s.nextInt()-1;
            if (step[a][b] != Integer.MAX_VALUE) {
                System.out.println(step[a][b]);
            } else {
                System.out.println("Not enough hallways!");
            }
        }
    }
}
