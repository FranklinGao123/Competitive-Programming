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
public class SnakesAndLadders {
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
        int tile = 1;
        while(true){
            int temp = s.nextInt();
            if (temp==0){
                System.out.println("You Quit!");
                return;
            }
            tile+=temp;
            if(tile==9)
                tile=34;
            if(tile==40){
                tile=64;
            }
            if(tile==67){
                tile=86;
            }
            if(tile==99){
                tile=77;
            }
            if(tile==90){
                tile=48;
            }
            if(tile==54){
                tile = 19;
            }
            if(tile>100){
                tile-=temp;
            }
            System.out.println("You are now on square "+tile);
            if(tile==100){
                System.out.println("You Win!");
                return;
            }
        }
    }
}
