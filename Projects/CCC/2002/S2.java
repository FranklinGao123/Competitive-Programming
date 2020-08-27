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
public class FractionAction {
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

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int num = s.nextInt(), denum = s.nextInt();
        if(num==0){
            System.out.println("0");
            return;
        }
        int mix = 0;
        if(num>=denum){
            if(num%denum==0){
                System.out.println(num/denum);
                return;
            }
            mix = num/denum;
            num=num%denum;
        }
        for(int i = num; i>=1; i--){
            if(num%i==0 && denum%(i)==0){
                num/=i;
                denum/=i;
            }
        }
        if(mix!=0){
            System.out.print(mix+" ");
        }
        System.out.println(num+"/"+denum);
        
    }
}
