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
public class SheepAndCoyotes {
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
    
    static class pair{
        double x;
        double y;
        
        public pair(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    
    static double dist(double x, double y, double wolf){
        return Math.sqrt((double)Math.pow(Math.abs(x-wolf), 2)+Math.pow(y, 2));
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int num = s.nextInt();
        pair[] sheep = new pair[num];
        LinkedList<pair> eaten = new LinkedList<pair>();
        for(int i = 0; i<num; i++){
            double x = s.nextDouble();
            double y = s.nextDouble();
            sheep[i] = new pair(x,y);
        }
        for(double i = 0; i<1000; i+=0.01){
            double min = Double.MAX_VALUE;
            LinkedList<pair> eat = new LinkedList<pair>();
            for(int j = 0; j<num; j++){
                double temp = dist(sheep[j].x, sheep[j].y, i);
                if(temp == min){
                    eat.add(sheep[j]);
                }else if(temp<min){
                    eat.clear();
                    eat.add(sheep[j]);
                    min = temp;
                } 
            }
            for(int j = 0; j<eat.size(); j++){
                if(!eaten.contains(eat.get(j))){
                    eaten.add(eat.get(j));
                }
            }
            eat.clear();
        }
        for(int i = 0; i<eaten.size(); i++){
            System.out.printf("The sheep at (%.2f, %.2f) might be eaten.%n", eaten.get(i).x, eaten.get(i).y);
        }
        
    }
}
