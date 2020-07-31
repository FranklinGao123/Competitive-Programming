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
public class LSystemsGo {
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
        FastReader fr = new FastReader();
        for(int o=0; o<10; o++){
        int a = fr.nextInt();
        int b = fr.nextInt();
        String v = fr.next();
        String[] rule = new String[26];
        long[] freq = new long[26];
        for(int i = 0; i<v.length(); i++){
            freq[v.charAt(i)-'A']++;
        }
        for(int i = 0; i<a; i++){
            char r = fr.next().charAt(0);
            String to = fr.next();
            rule[r-'A']=to;
        }
        char first = v.charAt(0);
        char last = v.charAt(v.length()-1);
        for(int i = 0; i<b; i++){
            long[] tempfreq = new long[26];
            for(int c = 0; c<rule.length; c++){
                if(freq[c]==0) continue;
                for(int u = 0; u<rule[c].length(); u++){
                    tempfreq[rule[c].charAt(u)-'A']+=freq[c];
                }
            }
            first = rule[first-'A'].charAt(0);
            last = rule[last-'A'].charAt(rule[last-'A'].length()-1);
            freq = tempfreq;
        }
        long total = 0;
        for(int i = 0; i<26; i++){
            total+=freq[i];
        }
        System.out.println(first+""+last+" "+total);
        }
    }
}
