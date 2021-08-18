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
public class dmopc14c3p3 {
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
    
    static class Pair implements Comparable<Pair>{
        String name;
        int s;
        
        public Pair(String name, int s){
            this.name = name;
            this.s = s;
        }
        
        @Override
        public int compareTo(Pair o){
            return this.s-o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        ArrayList<Pair> employees = new ArrayList<Pair>();
        for(int i = 0; i<n; i++){
            String name = s.next();
            int skill = s.nextInt();
            employees.add(new Pair(name, skill));
        }
        int q = s.nextInt();
        for(int i = 0; i<q; i++){
            int score = s.nextInt();
            int d = s.nextInt();
            int min = Integer.MAX_VALUE;
            String name = "";
            for(int j = 0; j<n; j++){
                if(score<=employees.get(j).s &&score+d>=employees.get(j).s){
                    if(min>employees.get(j).s-score){
                        min = employees.get(j).s-score;
                        name = employees.get(j).name;
                    }
                }
            }
            if(!name.equals("")){
                System.out.println(name);
            }else{
                System.out.println("No suitable teacher!");
            }
        }
        
    }
}
