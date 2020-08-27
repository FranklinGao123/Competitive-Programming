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
public class WizardsWindows {
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
    
    static ArrayList<rule> rules = new ArrayList<rule>();
    
    static class rule{
        char left;
        char right;
        char output;
        
        public rule(String rule){
            left = rule.charAt(0);
            right = rule.charAt(1);
            output = rule.charAt(3);
        }
    }
    
    static char getRule(char left, char right){
        for(int i = 0; i<4; i++){
            if(rules.get(i).left == left && rules.get(i).right == right){
                return rules.get(i).output;
            }
        }
        return 'a';
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        for(int count = 0; count<10; count++){
            int n = s.nextInt(), m = s.nextInt();
            for(int i = 0; i<4; i++){
                rules.add(new rule(s.nextLine()));
            }
            String start = s.nextLine();
            for(int i = 0; i<m-1; i++){
                String temp = "";
                temp += getRule(start.charAt(n-1),start.charAt(1));
                for(int j = 1; j<n-1; j++){
                    temp += getRule(start.charAt(j-1),start.charAt(j+1));
                }
                temp += getRule(start.charAt(n-2),start.charAt(0));
                start = temp;
            }
            System.out.println(start);
            s.next();
            rules.clear();
        }
    }
}
