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
public class ChancesOfWinning {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<String> map = new LinkedList<String>();
        map.add("12");
        map.add("13");
        map.add("14");
        map.add("23");
        map.add("24");
        map.add("34");
        int fav = s.nextInt();
        int n = s.nextInt();
        char[] game = new char[6];
        for (int i = 0; i < n; i++) {
            int index = 0;
            int f = s.nextInt();
            int sec = s.nextInt();
            index = map.indexOf(Integer.toString(f) + Integer.toString(sec));
            int fp = s.nextInt();
            int sp = s.nextInt();
            if (fp > sp) {
                game[index] = 'W';
            } else if (fp < sp) {
                game[index] = 'L';
            } else {
                game[index] = 'T';
            }
        }
        LinkedList<char[]> queue = new LinkedList<char[]>();
        queue.add(game);
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] points = new int[4];
            int max = -1;
            int index = 0;
            ArrayList<Integer> ind = new ArrayList<Integer>();
            boolean skip = false;
            char[] temp = queue.poll();
            char[] c1 = Arrays.copyOf(temp, temp.length);
            char[] c2 = Arrays.copyOf(temp, temp.length);
            char[] c3 = Arrays.copyOf(temp, temp.length);
            for (int i = 0; i < 6; i++) {
                if (temp[i] != 'W' && temp[i] != 'L' && temp[i] != 'T') {
                    c1[i] = 'W';
                    queue.add(c1);
                    c2[i] = 'L';
                    queue.add(c2);
                    c3[i] = 'T';
                    queue.add(c3);
                    skip = true;
                    break;
                }
            }
            if (skip == false) {
                for (int i = 0; i < 6; i++) {
                    if (temp[i] == 'W') {
                        points[(int) (map.get(i).charAt(0)) - 49] += 3;
                    } else if (temp[i] == 'L') {
                        points[(int) (map.get(i).charAt(1)) - 49] += 3;
                    } else {
                        points[(int) (map.get(i).charAt(0)) - 49] += 1;
                        points[(int) (map.get(i).charAt(1)) - 49] += 1;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if (points[i] > max) {
                        max = points[i];
                        ind.clear();
                    }
                    if (points[i] == max) {
                        ind.add(i);
                    }

                }
                if (ind.size() == 1 && ind.get(0) + 1 == fav) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
