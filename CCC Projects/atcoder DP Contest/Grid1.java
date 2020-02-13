/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.util.*;

/**
 *
 * @author frank
 */
public class Grid1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int w = s.nextInt();
        boolean[][] map = new boolean[h][w];
        long[][] step = new long[h][w];
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String tempString = s.next();
            char[] temp = tempString.toCharArray();
            for (int c = 0; c < w; c++) {
                if (temp[c] == '#') {
                    map[i][c] = false;
                } else {
                    map[i][c] = true;
                }
            }
        }
        LinkedList<Integer> rq = new LinkedList<Integer>();
        LinkedList<Integer> cq = new LinkedList<Integer>();
        cq.add(0);
        rq.add(0);
        step[0][0] = 1;
        boolean skip = true;
        while (!rq.isEmpty()) {
            int r = rq.pop();
            int c = cq.pop();
            if (visited[r][c] == false) {
                if (r == 0 && skip == false) {
                    step[r][c] += step[r][c - 1];
                }
                if (c == 0 && skip == false) {
                    step[r][c] += step[r - 1][c];
                }
                if (r != 0 && c != 0) {
                    if (map[r][c - 1] == true) {
                        step[r][c] += step[r][c - 1];
                    }
                    if (map[r - 1][c] == true) {
                        step[r][c] += step[r - 1][c];
                    }
                }

                if (w - 1 != c && map[r][c + 1] == true) {
                    cq.add(c + 1);
                    rq.add(r);
                }
                if (h - 1 != r && map[r + 1][c] == true) {
                    cq.add(c);
                    rq.add(r + 1);
                }
                skip = false;
                visited[r][c] = true;
                step[r][c] = step[r][c] % (1000000007);
            }
        }
        System.out.println(step[h - 1][w - 1]);

    }
}
