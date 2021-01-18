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
public class ccc02s4 {

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
        int m = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[q + 1];
        int[] dp = new int[q + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] backtrack = new int[q + 1];
        String[] people = new String[q + 1];
        for (int i = 1; i < m + 1; i++) {
            people[i] = s.next();
            arr[i] = s.nextInt();
            dp[i] = Math.max(dp[i - 1], arr[i]);
            backtrack[i] = i;
        }
        for (int i = m + 1; i < q + 1; i++) {
            people[i] = s.next();
            arr[i] = s.nextInt();
            for (int j = 0; j < m; j++) {
                int max = 0;
                for (int k = 0; k < j + 1; k++) {
                    max = Math.max(max, arr[i - k]);
                }
                if (dp[i] > dp[i - j - 1] + max) {
                    dp[i] = dp[i - j - 1] + max;
                    backtrack[i] = i - j - 1;
                }
            }
        }
        System.out.println("Total Time: " + dp[q]);
        ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
        int i = q;
        int index = 0;
        while (backtrack[i] != i) {
            if (backtrack[i] == i) {
                break;
            } else {
                for (int j = i; j > backtrack[i]; j--) {
                    names.add(new ArrayList<String>());
                    names.get(index).add(people[j]);
                }
            }
            i=backtrack[i];
            index++;
        }
        for (int j = i; j > 0; j--) {
            names.add(new ArrayList<String>());
            names.get(index).add(people[j]);
        }
        for(i = names.size()-1; i>=0; i--){
            for(int j = names.get(i).size()-1; j>=0; j--){
                System.out.print(names.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }
}
