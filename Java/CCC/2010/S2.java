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
public class HuffmanEncoding {
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
        char a;
        String b;
        
        public pair(char a, String b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        ArrayList<pair> arr = new ArrayList<pair>();
        for(int i = 0; i<n; i++){
            char a = s.next().charAt(0);
            arr.add(new pair(a, s.next()));
        }
        String temp = s.next();
        int j = 0;
        String output = "";
        while(j<temp.length()){
            int index = 0;
            for(pair i: arr){
                if(j+i.b.length()<=temp.length() && i.b.equals(temp.substring(j,j+i.b.length()))){
                    output+=i.a;
                    j+=i.b.length();
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
