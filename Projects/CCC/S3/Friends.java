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
public class Friends {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //boolean[][] map = new boolean[9999][9999];
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int first = s.nextInt() - 1;
            int second = s.nextInt() - 1;
            map.put(first, second);
        }
        while (true) {
            int start = s.nextInt() - 1;
            int end = s.nextInt() - 1;
            if (start == -1 && end == -1) {
                return;
            } else {
                int[] step = new int[9999];
                Arrays.fill(step, Integer.MAX_VALUE);
                step[start] = 0;
                LinkedList<Integer> q = new LinkedList<Integer>();
                q.add(start);
                while (!q.isEmpty()) {
                    int V = q.pop();
                    int c = map.get(V);
                    if (step[c] > step[V] + 1) {
                        step[c] = step[V] + 1;
                        q.add(c);
                    }
                    if (step[end] != Integer.MAX_VALUE) {
                        int answer = step[end] - 1;
                        System.out.println("Yes " + answer);
                        break;
                    }
                }
                if (step[end] == Integer.MAX_VALUE) {
                    System.out.println("No");
                }
            }

        }

    }
}
