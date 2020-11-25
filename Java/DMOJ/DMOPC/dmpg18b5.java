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
public class dmpg18b5 {

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

    static long SENTINEL = 27644437;
    static long[] powers;
    static ArrayList<Long> distinct = new ArrayList<Long>();

    static void init() {
        long pow = 1;
        for (int i = 0; i < powers.length; i++) {
            powers[i] = pow;
            pow = (pow * 26) % SENTINEL;
        }
    }

    static long hash(String in) {
        long hash = 0;
        for (int i = 0; i < in.length(); i++) {
            hash = (hash * 26) % SENTINEL;
            hash = (hash + in.charAt(i) - 'a') % SENTINEL;
        }
        return hash;
    }

    static long roll(long prev, char remove, char add, int length) {//the hashing function
        return (((prev + SENTINEL - (((remove - 'a') % SENTINEL) * ((powers[length - 1]) % SENTINEL)) % SENTINEL) * 26) % SENTINEL + (add - 'a') % SENTINEL) % SENTINEL;
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        String a = s.next();
        int len = s.nextInt();
        powers = new long[len];
        init();
        for (int i = 0; i < 26; i++) {
            long temp = 0;
            for (int j = 0; j < len; j++) {
                temp = (temp * 26) % SENTINEL;
                temp = (temp + i) % SENTINEL;
            }
            distinct.add(temp);
        }
        long hash = hash(a.substring(0, len));
        int answer = 0;
        for (int i = len; i < a.length(); i++) {
            if (distinct.contains(hash)) {
                answer++;
            }
            hash = roll(hash, a.charAt(i - len), a.charAt(i), len);
        }
        if (distinct.contains(hash)) {
            answer++;
        }
        System.out.println(answer);
    }
}
