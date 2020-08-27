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
public class ItsToughBeingATeen {
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
    static int[] req = new int[7];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static void connect (int a, int b){
        a--;
        b--;
        graph.get(a).add(b);
        req[b]++;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        for(int i = 0; i<7; i++){
            graph.add(new ArrayList<>());
        }
        connect(1,7);
        connect(1,4);
        connect(2,1);
        connect(3,4);
        connect(3,5);
        int a = fr.nextInt();
        int b = fr.nextInt();
        while(a!=0){
            connect(a,b);
            a = fr.nextInt();
            b = fr.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i<7; i++){
            if(req[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        String output="";
        
        while(!queue.isEmpty()){
            int next = queue.poll();
            count++;
            output+=(next+1);
            if(count!=7){
                output+=" ";
            }
            for(int nextNode: graph.get(next)){
                req[nextNode]--;
                if(req[nextNode]==0){
                    queue.add(nextNode);
                }
            }
        }
        if(count ==7){
            System.out.println(output);
        }else{
            System.out.println("Cannot complete these tasks. Going to bed.");
        }
    }
}
