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
public class Poetry {
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
        int n = s.nextInt();
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0; i<n; i++){
            String[] p = new String[4];
            for(int j = 0; j<4; j++){
                String temp = s.nextLine().toLowerCase();
                for(int o = temp.length()-1; o>=0; o--){
                    if(vowels.contains((temp.charAt(o)))){
                        p[j] = temp.substring(o, temp.length());
                        break;
                    }
                    if(temp.charAt(o)==' '){
                        p[j] = temp.substring(o+1, temp.length());
                        break;
                    }
                    if(o==0){
                        p[j] = temp.substring(o, temp.length());
                    }
                }
            }
            if(p[0].equals(p[1])&&p[0].equals(p[2])&&p[0].equals(p[3])){
                System.out.println("perfect");
            }else if(p[0].equals(p[1]) && p[2].equals(p[3])){
                System.out.println("even");
            }else if(p[0].equals(p[3]) && p[1].equals(p[2])){
                System.out.println("shell");
            }else if(p[0].equals(p[2]) && p[1].equals(p[3])){
                System.out.println("cross");
            }else{
                System.out.println("free");
            }
            
        }
    }
}
