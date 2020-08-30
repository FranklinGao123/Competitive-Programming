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

public class PinballRanking {
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
    
    static int MM = 100005;
    static long[] BIT = new long[MM];
    
    static long query(int x) {
        long ret = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            ret += BIT[i];
        }
        return ret;
    }
    
    static void update(int x, int v) { //X is the index    Y is the amount you want to update by
        for (int i = x; i <= MM; i += (i & -i)) {
            BIT[i] += v;
        }
    }
    
    static class rank{
        int value;
        int index;
        int rk;
        
        public rank(int value, int index, int rk){
            this.value = value;
            this.index = index;
            this.rk = rk;
        }
    }
    
    static class sortByValue implements Comparator<rank>{
        public int compare(rank x, rank y){
            return y.value-x.value;
        }
    }
    
    static class sortByIndex implements Comparator<rank>{
        public int compare(rank x, rank y){
            return x.index-y.index;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int n = s.nextInt();
        ArrayList<rank> arr = new ArrayList<rank>();
        for(int i = 0; i<n; i++){
            arr.add(new rank(s.nextInt(), i, 0));
        }
        Collections.sort(arr,new sortByValue());
        int cur = 1;
        for(int i = 0; i<n; i++){
            if(i!=0 && arr.get(i).value==arr.get(i-1).value)
                arr.get(i).rk = arr.get(i-1).rk;
            else{
                arr.get(i).rk = cur;
                cur++;
            }
        }
        Collections.sort(arr, new sortByIndex());
        double total = 0;
        for(int i = 1; i<n+1; i++){
            if(arr.get(i-1).rk!=1)
                total+=query(arr.get(i-1).rk-1)+1;
            else
                total++;
            update(arr.get(i-1).rk,1);
        }
        total/=n;
        total*=100;
        total = Math.rint(total);
        total/=100;
        System.out.printf("%.2f",total);
    }
    
}
