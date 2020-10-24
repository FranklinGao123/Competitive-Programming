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
public class Waterpark {
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
        int n = s.nextInt();
        ArrayList<Integer>[] map = new ArrayList[n];
        for(int i = 0; i<n; i++){
            map[i] = new ArrayList<Integer>();
        }
        while(true){
            int a = s.nextInt()-1, b = s.nextInt()-1;
            if(a==b && a==-1){
                break;
            }
            map[a].add(b);
        }
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(0);
        int[] total = new int[n];
        total[0] = 1;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur==n-1){
                continue;
            }
            for(int i:map[cur]){
                if(visited[i]){
                    total[i] += total[cur];
                    continue;
                }else{
                    visited[i] = true;
                    total[i] = total[cur];
                    queue.add(i);
                }
            }
        }
        System.out.println(total[n-1]);
    }
}
