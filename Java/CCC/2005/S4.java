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
public class PyramidMessageScheme {
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
        int count = s.nextInt();
        for(int p = 0; p<count; p++){
            int n = s.nextInt();
            ArrayList<Integer>[] map = new ArrayList[n];
            ArrayList<String> names = new ArrayList<String>();
            String temp = s.next().toLowerCase();
            String last = temp;
            int indexLast = 0;
            names.add(temp);
            map[0] = new ArrayList<Integer>();
            for(int i = 1; i<n; i++){
                temp = s.next().toLowerCase();
                if (!names.contains(temp)){
                    names.add(temp);
                    map[names.indexOf(temp)] = new ArrayList<Integer>();
                }
                int indexTemp = names.indexOf(temp);
                map[indexLast].add(indexTemp);
                indexLast = indexTemp;
                last = temp;
            }
            map[names.indexOf(temp)].add(0);
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(names.indexOf(temp));
            int[] step = new int[names.size()];
            Arrays.fill(step, Integer.MAX_VALUE);
            step[names.indexOf(temp)]=0;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int i = 0; i<map[cur].size(); i++){
                    if(step[map[cur].get(i)]>step[cur]+1){
                        step[map[cur].get(i)]=step[cur]+1;
                        queue.add(map[cur].get(i));
                    }
                }
            }
            int max = 0;
            for(int i = 0; i<names.size(); i++){
                max = Math.max(max, step[i]);
                //System.out.print(step[i]+" ");
            }
            System.out.println(n*10-max*20);
        }
    }
}
