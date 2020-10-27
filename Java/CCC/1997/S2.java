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
public class NastyNumbers {
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
    
    static ArrayList<pair> pairs;
    
    static class pair{
        int a;
        int b;
        
        public pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    static void factors(int a){
        for(int i = 1; i<Math.sqrt(a)+1; i++){
            if(a%i==0){
                pairs.add(new pair(i,a/i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        for(int p = 0; p<n; p++){
            pairs = new ArrayList<pair>();
            int temp = s.nextInt();
            factors(temp);
            int h = 0;
            int k = 1;
            boolean done = false;
            while(h<k){
                if(pairs.get(h).b-pairs.get(h).a==pairs.get(k).a+pairs.get(k).b){
                    done = true;
                    break;
                }
                if(pairs.get(k).b-pairs.get(k).a==pairs.get(k).a+pairs.get(k).b){
                    done = true;
                    break;
                }
                h++;
                if(h==k){
                    k++;
                    h=0;
                }
                if(k==pairs.size())
                    break;
            }
            if(done)
                System.out.println(temp + " is nasty");
            else
                System.out.println(temp + " is not nasty");
        }
    }
}
