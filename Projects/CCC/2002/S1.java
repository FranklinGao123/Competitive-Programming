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
public class TheStudentsCouncilBreakfast {
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
        int[] tickets = new int[4];
        String[] temp = {"PINK","GREEN","RED","ORANGE"};
        for(int i = 0; i<4; i++){
            tickets[i]=s.nextInt();
        }
        int[] original = tickets.clone();
        Arrays.sort(tickets);
        int a = tickets[0], b = tickets[1], c = tickets[2], d = tickets[3];
        int total = s.nextInt();
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = total/d; i>=0;i--){
            for(int j = (total-i*d)/c; j>=0; j--){
                for(int o = (total-i*d-j*c)/b; o>=0; o--){
                    for(int p = (total-i*d-j*c-o*b)/a;p>=0; p--){
                        if(i*d+j*c+o*b+p*a==total){
                            ans++;
                            for(int t = 0; t<4; t++){
                                if(original[t] == a){
                                    System.out.print("# of "+temp[t]+" is "+p+" ");
                                }else if(original[t] == b){
                                    System.out.print("# of "+temp[t]+" is "+o+" ");
                                }else if(original[t] == c){
                                    System.out.print("# of "+temp[t]+" is "+j+" ");
                                }else if(original[t] == d){
                                    System.out.print("# of "+temp[t]+" is "+i+" ");
                                }
                            }
                            min = Math.min(i+j+o+p, min);
                            System.out.println("");
                        }
                    }
                }
            }
        }
        System.out.println("Total combinations is "+ans+".");
        System.out.println("Minimum number of tickets to print is "+min+".");
    }
}
