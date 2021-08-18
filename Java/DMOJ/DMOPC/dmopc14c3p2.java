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
public class dmopc14c3p2 {
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
        ArrayList<String> a = new ArrayList<String>();
        int WA = 0;
        for(int i = 0; i<n; i++){
            String temp = s.next();
            a.add(temp);
            if(temp.equals("WA")){
                WA++;
            }
        }
        WA*=(double)0.3;
        int IR = 0;
        for(int i = 0; i<n; i++){
            if(a.get(i).equals("WA") && WA >0){
                System.out.println("AC");
                WA--;
            }else if(a.get(i).equals("WA")){
                System.out.println("WA");
            }else if(a.get(i).equals("AC")){
                System.out.println("AC");
            }else if(a.get(i).equals("TLE")){
                System.out.println("WA");
            }else if(a.get(i).equals("IR") && IR <10){
                System.out.println("AC");
                IR++;
            }else if(a.get(i).equals("IR") && IR <20){
                System.out.println("WA");
                IR++;
            }else{
                System.out.println("IR");
            }
        }
        
    }
}
