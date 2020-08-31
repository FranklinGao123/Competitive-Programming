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
public class WhoIsTaller {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] map = new ArrayList[N];
        for (int i=0; i<N; i++) {
            map[i] = new ArrayList<Integer>();
        }
 
        //Repeat M time to input M comparison
        for (int i=0; i<M; i++) {
            S = br.readLine();
            st = new StringTokenizer(S, " ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x].add(y);
        }
 
        //Start BFS
 
        st = new StringTokenizer(br.readLine());
        Integer p = Integer.parseInt(st.nextToken())-1;
        Integer q = Integer.parseInt(st.nextToken())-1;
        ArrayList<Integer> queue = new ArrayList<Integer>();
        boolean [] visited = new boolean [N];
        queue.add(p);   //Add begin to the queue
        while(! queue.isEmpty()){
            int size = queue.size();
            //Read person from queue and add all the neighbor's into queue
            for(int i = 0; i < size; i++){
                int cur = queue.get(i);
                //below get all the neighbor of cur
                for(int j = 0; j < map[cur].size(); j++){
                    if(visited[map[cur].get(j)] == false){
                        visited[map[cur].get(j)] = true;
                        queue.add(map[cur].get(j));
                    }
                }
            }
            for(int i = 0; i < size; i++) queue.remove(0);
        }
        if(visited[q] == true) System.out.println("yes");
        else{
            //Reverse BFS
            queue = new ArrayList<Integer>();
            visited = new boolean [N];
            queue.add(q);    //
            while(! queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.get(i);
                    for(int j = 0; j < map[cur].size(); j++){
                        if(visited[map[cur].get(j)] == false){
                            visited[map[cur].get(j)] = true;
                            queue.add(map[cur].get(j));
                        }
                    }
                }
                for(int i = 0; i < size; i++) queue.remove(0);
            }
            if(visited[p] == true) System.out.println("no");
            else System.out.println("unknown");
        }
        
    }
    

}

/* Out of Memory Error


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
        int n = s.nextInt(), m = s.nextInt();
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int p = s.nextInt()-1, q = s.nextInt()-1;
            map[p][q] = true;
        }
        int p = s.nextInt()-1, q = s.nextInt()-1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        queue.add(p);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < n; i++) {
                if (visited[i] == false && map[cur][i]==true) {
                    visited[i] = true;
                    queue.add(i);
                }

            }
        }
        if (visited[q] == true) {
            System.out.println("yes");
        } else {
            //Reverse BFS
            queue = new LinkedList<Integer>();
            visited = new boolean[n];
            queue.add(q);    
            while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < n; i++) {
                if (visited[i] == false && map[cur][i]==true) {
                    visited[i] = true;
                    queue.add(i);
                }

            }
        }
            if (visited[p] == true) {
                System.out.println("no");
            } else {
                System.out.println("unknown");
            }
        }

    }
*/
