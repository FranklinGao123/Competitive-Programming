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
public class dmopc20c2p1 {

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
        ArrayList<Character[]> map = new ArrayList<Character[]>();
        map.add(new Character[n]);
        Arrays.fill(map.get(0), '.');
        String input = s.next();
        int r = 0;
        int c = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '^') {
                map.get(r)[c] = '/';
                r--;
                if(r<0){
                    map.add(0, new Character[n]);
                    Arrays.fill(map.get(0), '.');
                    r++;
                }
                c++;                
            } else if (input.charAt(i) == 'v') {
                r++;
                if(r>map.size()-1){
                    map.add(new Character[n]);
                    Arrays.fill(map.get(r), '.');
                }
                map.get(r)[c] = '\\';
                c++;
            } else {
                map.get(r)[c] = '_';
                c++;
            }
        }
        String temp = "";
        for(int i = 0; i<n; i++){
            temp+=".";
        }
        for (int i = 0; i < map.size(); i++) {
            boolean done = true;
            for(int j = 0; j<n; j++){
                if(map.get(i)[j]!='.'){
                    done = false;
                }
            }
            if(!done) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map.get(i)[j]);
                }
                System.out.println("");
            }
        }

    }
}
