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
public class CaptchaFun {

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
        int t = s.nextInt();
        for (int y = 0; y < t; y++) {
            int m = s.nextInt();
            for (int r = 0; r < m; r++) {
                int w = s.nextInt(), h = s.nextInt();
                int startx = Integer.MAX_VALUE, endx = Integer.MIN_VALUE, starty = Integer.MAX_VALUE, endy = Integer.MIN_VALUE;
                char[][] map = new char[w][h];
                for (int i = 0; i < w; i++) {
                    String temp = s.next();
                    if (temp.contains("*")) {
                        starty = Math.min(starty, i);
                        endy = Math.max(endy, i);
                    }
                    for (int j = 0; j < h; j++) {
                        map[i][j] = temp.charAt(j);
                        if (temp.charAt(j) == '*') {
                            startx = Math.min(startx, j);
                            endx = Math.max(endx, j);
                        }
                    }
                }
                if(map[starty][endx]=='*' && map[starty][startx]=='*' && startx!=endx){
                    System.out.print("4");
                }
                else if(map[starty][endx]=='*'){
                    System.out.print("1");
                }
                else if(map[endy][endx]=='*'){
                    System.out.print("7");
                }
                else if(map[(starty+endy)/2][endx-1]=='-'){
                    System.out.print("0");
                }
                else{
                    if(map[starty+1][startx]=='*' && map[endy-1][startx]=='*' && map[starty +1][endx]=='*' && map[endy -1][endx]=='*'){
                        System.out.print("8");
                    }else if(map[starty+1][startx]=='*' && map[starty +1][endx]=='*' && map[endy -1][endx]=='*'){
                        System.out.print("9");
                    }else if(map[starty+1][startx]=='*' && map[endy-1][startx]=='*' && map[endy -1][endx]=='*'){
                        System.out.print("6");
                    }else if(map[endy-1][startx]=='*' && map[starty +1][endx]=='*'){
                        System.out.print("2");
                    }else if(map[starty+1][startx]=='*' && map[endy -1][endx]=='*'){
                        System.out.print("5");
                    }else{
                        System.out.print("3");
                    }
                }
            }
            System.out.println("");
        }
    }
}
