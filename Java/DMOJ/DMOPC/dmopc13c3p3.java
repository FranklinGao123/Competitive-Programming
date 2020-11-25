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
public class dmopc13c3p3 {
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
        int n = s.nextInt(), h = s.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                map[i][j] = s.nextInt();
            }
        }
        LinkedList<Integer> rq = new LinkedList<Integer>();
        rq.add(0);
        LinkedList<Integer> cq = new LinkedList<Integer>();
        cq.add(0);
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!rq.isEmpty()){
            int rc = rq.poll();
            int cc = cq.poll();
            if(cc>0 && Math.abs(map[rc][cc]-map[rc][cc-1])<=h && visited[rc][cc-1]==false){
                rq.add(rc);
                cq.add(cc-1);
                visited[rc][cc-1] = true;
            }
            if(cc<n-1 && Math.abs(map[rc][cc]-map[rc][cc+1])<=h && visited[rc][cc+1]==false){
                rq.add(rc);
                cq.add(cc+1);
                visited[rc][cc+1] = true;
            }
            if(rc>0 && Math.abs(map[rc][cc]-map[rc-1][cc])<=h && visited[rc-1][cc]==false){
                rq.add(rc-1);
                cq.add(cc);
                visited[rc-1][cc] = true;
            }
            if(rc<n-1 && Math.abs(map[rc][cc]-map[rc+1][cc])<=h && visited[rc+1][cc]==false){
                rq.add(rc+1);
                cq.add(cc);
                visited[rc+1][cc] = true;
            }
        }
        if(visited[n-1][n-1]){
            System.out.println("yes");
        }else
            System.out.println("no");
    }
}
