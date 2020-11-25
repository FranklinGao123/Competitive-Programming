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
public class ecoo15r2p1 {

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
        for (int count = 0; count < 10; count++) {
            String temp = s.next();
            String Line = s.nextLine();
            if (temp.equals("encode")) {
                String[] lines = Line.split("\\s+");
                int[] size = new int[lines.length];
                for (int i = 0; i < lines.length; i++) {
                    size[i] = lines[i].length();
                }
                String ans = "";
                boolean done = false;
                while (!done) {
                    done = true;
                    for (int i = 0; i < lines.length; i++) {
                        if (lines[i].length() != 0) {
                            ans += lines[i].charAt(0);
                            lines[i] = lines[i].substring(1);
                            done = false;
                        }
                    }
                }
                int c = 0;
                for (int i = 0; i < lines.length; i++) {
                    for (int j = 0; j < size[i]; j++) {
                        System.out.print(ans.charAt(j + c));
                    }
                    c += size[i];
                    System.out.print(" ");
                }
                System.out.println("");
            } else {
                String ans = "";
                int spaces = 1;
                ArrayList<Integer> size = new ArrayList<Integer>();
                int sizes = 0;
                for(int i = 0; i<Line.length(); i++){
                    if(Line.charAt(i) == ' '){
                        spaces++;
                        size.add(sizes);
                        sizes = 0;
                    }else{
                        ans+=Line.charAt(i);
                        sizes++;
                    }
                }
                size.add(sizes);
                String[] words = new String[spaces];
                for(int i = 0; i<spaces; i++){
                    words[i]="";
                }
                int c = 0;
                int[] j = new int[spaces];
                for(int i = 0; i<ans.length(); i++){
                    if(j[c]<size.get(c)){
                        words[c]+=ans.charAt(i);
                    }else{
                        i--;
                    }
                    j[c]++;
                    c++;
                    if(c==spaces){
                        c=0;
                    }
                }
                for(int i = 0; i<spaces; i++){
                    System.out.print(words[i]);
                    if(i<spaces-1){
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
