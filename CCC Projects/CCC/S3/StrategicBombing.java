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
public class StrategicBombing {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static String nextLine() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        /* 
    disconnect a road, then dfs between A and B. If you can't reach B, add one to answer. Repeat for every road.
         */
        boolean[][] map = new boolean[26][26];
        int count = 0;
        ArrayList<String> road = new ArrayList<String>();
        while (true) {
            String temp = nextLine();
            if ("**".equals(temp)) {
                break;
            } else {
                map[temp.charAt(0) - 'A'][temp.charAt(1) - 'A'] = true;
                map[temp.charAt(1) - 'A'][temp.charAt(0) - 'A'] = true;
                count++;
                road.add(temp);
            }
        }
        int answer = 0;
        for (int i = 0; i < count; i++) {
            String temp = road.get(i);
            map[temp.charAt(0) - 'A'][temp.charAt(1) - 'A'] = false;
            map[temp.charAt(1) - 'A'][temp.charAt(0) - 'A'] = false;
            int[][] step = new int[26][26];
            for (int c = 0; c < 26; c++) {
                Arrays.fill(step[c], Integer.MAX_VALUE);
            }
            step[0][0] = 0;
            LinkedList<Integer> queuer = new LinkedList<Integer>();
            queuer.add(0);
            while (!queuer.isEmpty()) {
                int curR = queuer.poll();
                //get neighbours
                for (int c = 0; c < 26; c++) {
                    if (map[curR][c] == true) { //c is neighbour
                        //curV and c connected together
                        if (step[curR][c] > step[curR][curR] + 1) {
                            step[curR][c] = step[curR][curR] + 1;
                            step[c][c] = step[curR][curR] + 1;
                            queuer.add(c);
                        }
                    }
                }
            }
            if (step[1][1] == Integer.MAX_VALUE) {
                System.out.println(temp);
                answer++;
            }
            map[temp.charAt(0) - 'A'][temp.charAt(1) - 'A'] = true;
            map[temp.charAt(1) - 'A'][temp.charAt(0) - 'A'] = true;
        }
        System.out.println("There are " + answer + " disconnecting roads.");

    }

}
