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
public class dmopc13c1p4 {
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
        int number = s.nextInt();
        int[][] steps = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int count = 0; count<number; count++){
            int l = s.nextInt(), w = s.nextInt();
            boolean[][] map = new boolean[w][l];
            int[] start = new int[2];
            int[] end = new int[2];
            for(int i = 0; i<w; i++){
                String temp = s.next();
                for(int j = 0; j<l; j++){
                    if(temp.charAt(j)=='O'){
                        map[i][j] = true;
                    }else if(temp.charAt(j)=='C'){
                        map[i][j] = true;
                        start[0] = i;
                        start[1] = j;
                    }else if(temp.charAt(j)=='W'){
                        map[i][j] = true;
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
            LinkedList<Integer> rq = new LinkedList<Integer>();
            rq.add(start[0]);
            LinkedList<Integer> cq = new LinkedList<Integer>();
            cq.add(start[1]);
            int[][] step = new int[w][l];
            for(int i = 0; i<w; i++){
                Arrays.fill(step[i], Integer.MAX_VALUE);
            }
            step[start[0]][start[1]] = 0;
            while(!rq.isEmpty()){
                int curR = rq.poll();
                int curC = cq.poll();
                for(int i = 0; i<4; i++){
                    if(curR+steps[i][0]>=0 && curR+steps[i][0]<=w-1 && curC+steps[i][1]>=0 && curC+steps[i][1]<=l-1){
                        if(map[curR+steps[i][0]][curC+steps[i][1]] && step[curR+steps[i][0]][curC+steps[i][1]]> step[curR][curC]+1){
                            rq.add(curR+steps[i][0]);
                            cq.add(curC+steps[i][1]);
                            step[curR+steps[i][0]][curC+steps[i][1]] = step[curR][curC]+1;
                        }
                    }
                }
            }
            if(step[end[0]][end[1]]>=60){
                System.out.println("#notworth");
            }else{
                System.out.println(step[end[0]][end[1]]);
            }
        }
    }
}
