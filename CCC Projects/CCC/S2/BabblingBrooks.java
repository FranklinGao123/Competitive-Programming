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
public class BabblingBrooks {
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
        ArrayList<Double> stream = new ArrayList<Double>();
        for(int i = 0; i<n; i++){
            stream.add(s.nextDouble());
        }
        while(true){
            int temp = s.nextInt();
            if(temp==77){
                break;
            }
            if(temp==99){
                int split = s.nextInt()-1;
                int percent = s.nextInt();
                stream.add(split+1, stream.get(split)*(100-percent)/100);
                stream.set(split, stream.get(split)*(percent)/100);
            }else{
                int join = s.nextInt()-1;
                stream.set(join, stream.get(join+1)+stream.get(join));
                stream.remove(join+1);
            }
        }
        for(int i = 0; i<stream.size(); i++){
            System.out.print(Math.round(stream.get(i))+" ");
        }
    }
}
