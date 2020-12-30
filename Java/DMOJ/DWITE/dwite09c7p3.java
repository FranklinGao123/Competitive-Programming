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
public class dwite09c7p3 {

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
        int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int count = 0; count < 5; count++) {
            int[][] map = new int[10][10];
            int[] start = new int[2];
            for (int i = 0; i < 10; i++) {
                String temp = s.next();
                for(int j = 0; j<10; j++){
                    if(temp.charAt(j)=='#'){
                        map[i][j]=1;
                    }else if(temp.charAt(j)=='A'){
                        start[0]=i;
                        start[1]=j;
                        map[i][j]=1;
                    }
                }
            }
//            for(int i = 0; i<10; i++){
//                for(int j = 0; j<10; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println("");
//            }
            LinkedList<Integer> rq = new LinkedList<Integer>();
            LinkedList<Integer> cq = new LinkedList<Integer>();
            rq.add(start[0]);
            cq.add(start[1]);
            int area = 1;
            boolean[][] stepList = new boolean[10][10];
            for(int i = 0; i<10; i++){
                Arrays.fill(stepList[i], false);
            }
            stepList[start[0]][start[1]] = true;
            while(!rq.isEmpty()){
                int cr = rq.poll();
                int cc = cq.poll();
                for(int i = 0; i<4; i++){
                    if(cr+step[i][0]>=0 && cr+step[i][0]<10 && cc+step[i][1]>=0 && cc+step[i][1]<10
                            && map[cr+step[i][0]][cc+step[i][1]]==1 && stepList[cr+step[i][0]][cc+step[i][1]]==false){
                        rq.add(cr+step[i][0]);
                        cq.add(cc+step[i][1]);
                        stepList[cr+step[i][0]][cc+step[i][1]]=true;
                        area++;
                    }
                }
            }
            System.out.println(area);
            s.next();
        }
    }
}
