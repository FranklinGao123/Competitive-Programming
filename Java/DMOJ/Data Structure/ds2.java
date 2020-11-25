/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//pastebin.com/HZbfqtfh
package java3;
//Disjoint Set Test
import java.util.*;
import java.io.*;
/**
 *
 * @author frank
 */
public class ds2 {
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
    
    public static class Edge{//Edge compares with an Edge
        //Data Members

        int bv;
        int ev;

        //Constructer
        public Edge(int bv, int ev) {
            this.bv = bv;
            this.ev = ev;
        }
    }
    
    
    public static void main(String[] args){
        FastReader s = new FastReader();
        int V = s.nextInt();
        int E = s.nextInt();
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            //Input Edge
            int bv = s.nextInt()-1;
            int ev = s.nextInt()-1;

            //Create Edge Object and STore into 1-D array
            edges[i] = new Edge(bv, ev);

        }
        //read edge one by one from edges array
        ArrayList<Integer> MST = new ArrayList<Integer>();
        parent = new int[V];
        Arrays.fill(parent, -1);
        int index = 1;
        for (Edge e : edges) {
            int pb = find(e.bv); //parent of beginning vertex
            int pe = find(e.ev); //parent of ending vertex
            if (pb != pe) {
                MST.add(index);
                union(pb, pe);
            }
            index++;
        }
        int n = find(0);
        for (int i = 1; i<V; i++){
            if(n!=find(i)){
                System.out.println("Disconnected Graph");
                return;
            }
        }
        for(int i: MST){
            System.out.println(i);
        }
        
        
    }
    public static int parent[];

    public static int find(int v) {
        if (parent[v] == -1) {
            return v;
        } else {
            parent[v] = find(parent[v]);
            return parent[v];
        }
    }

    public static void union(int pb, int pe) {
        parent[pb] = pe;
    }
}
