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
public class ShopAndShip {

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

    static class pair implements Comparable<pair> {

        int queue;
        int cost;

        public pair(int to, int weight) {
            this.queue = to;
            this.cost = weight;
        }

        public int compareTo(pair other) {
            if (other.cost < this.cost) {
                return 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int t = s.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < t; i++) {
            int x = s.nextInt() - 1, y = s.nextInt() - 1, cost = s.nextInt();
            map[x][y] = cost;
            map[y][x] = cost;
        }
        int k = s.nextInt();
        HashMap<Integer, Integer> stores = new HashMap<>();
        int[] store = new int[k];
        for (int i = 0; i < k; i++) {
            int z = s.nextInt() - 1, p = s.nextInt();
            store[i] = z;
            stores.put(z, p);
        }
        int d = s.nextInt() - 1;
        int[] costs = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<pair> queue = new PriorityQueue<>();
        queue.add(new pair(d, 0));
        while (!queue.isEmpty()) {
            pair q = queue.poll();
            if(visited[q.queue])
                continue;
            for (int j = 0; j < n; j++) {
                if (map[q.queue][j] != 0 && costs[j] > q.cost+map[q.queue][j]) {
                    queue.add(new pair(j, q.cost+map[q.queue][j]));
                    visited[q.queue] = true;
                    costs[j] = q.cost+map[q.queue][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, costs[store[i]] + stores.get(store[i]));
        }
        if (stores.containsKey(d)) {
            min = Math.min(stores.get(d), min);
        }
        System.out.println(min);
    }
}

