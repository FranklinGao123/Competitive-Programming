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
public class MountainPassage {

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
        FastReader s = new FastReader();
        int trips = s.nextInt();
        for (int o = 0; o < trips; o++) {
            int n = s.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.nextInt();
                }
            }
            LinkedList<Integer> rq = new LinkedList<Integer>();
            LinkedList<Integer> cq = new LinkedList<Integer>();
            rq.add(0);
            cq.add(0);

            int[][] oxygen = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(oxygen[i], Integer.MAX_VALUE);
            }
            oxygen[0][0] = 0;

            while (!rq.isEmpty()) {
                int r = rq.poll();
                int c = cq.poll();
                if (r+1<n && map[r + 1][c] <= map[r][c] + 2 && map[r + 1][c] >= map[r][c] - 2 
                        && oxygen[r + 1][c] == Integer.MAX_VALUE) {
                    if(map[r+1][c]>map[0][0]|| map[r][c]>map[0][0])
                        oxygen[r + 1][c] = oxygen[r][c] + 1;
                    else{
                        oxygen[r + 1][c] = oxygen[r][c];
                    }
                    rq.add(r + 1);
                    cq.add(c);
                }
                if (r-1>=0 && map[r - 1][c] <= map[r][c] + 2 && map[r - 1][c] >= map[r][c] - 2 
                        && oxygen[r - 1][c] == Integer.MAX_VALUE) {
                    if(map[r-1][c]>map[0][0]|| map[r][c]>map[0][0])
                        oxygen[r - 1][c] = oxygen[r][c] + 1;
                    else{
                        oxygen[r - 1][c] = oxygen[r][c];
                    }
                    rq.add(r - 1);
                    cq.add(c);
                }
                if (c-1>=0 && map[r][c-1] <= map[r][c] + 2 && map[r][c-1] >= map[r][c] - 2 
                        && oxygen[r][c-1] == Integer.MAX_VALUE) {
                    if(map[r][c-1]>map[0][0]|| map[r][c]>map[0][0])
                        oxygen[r][c-1] = oxygen[r][c] + 1;
                    else{
                        oxygen[r][c-1] = oxygen[r][c];
                    }
                    rq.add(r);
                    cq.add(c-1);
                }
                if (c+1<n && map[r][c+1] <= map[r][c] + 2 && map[r][c+1] >= map[r][c] - 2 
                        && oxygen[r][c+1] == Integer.MAX_VALUE) {
                    if(map[r][c+1]>map[0][0] || map[r][c]>map[0][0])
                        oxygen[r][c+1] = oxygen[r][c] + 1;
                    else{
                        oxygen[r][c+1] = oxygen[r][c];
                    }
                    rq.add(r);
                    cq.add(c+1);
                }
                if(oxygen[n-1][n-1]!=Integer.MAX_VALUE){
                    System.out.println(oxygen[n-1][n-1]);
                    break;
                }
            }
            if(oxygen[n-1][n-1]==Integer.MAX_VALUE){
                System.out.println("CANNOT MAKE THE TRIP");
            }
            System.out.println();
        }
    }
}
