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

public class Surfing {

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

    static class pair {

        String start;
        String end;

        public pair(String start, String end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        ArrayList<String> urls = new ArrayList<String>();
        ArrayList<pair> link = new ArrayList<pair>();
        String template = "<A HREF=\"";
        for (int i = 0; i < n; i++) {
            String a = s.nextLine();
            if (!urls.contains(a)) {
                urls.add(a);
            }
            String temp = s.nextLine();
            while (true) {
                if (temp.contains(template)) {
                    for (int j = 0; j < temp.length() - 9; j++) {
                        if (temp.substring(j, j + 9).equals(template)) {
                            for (int k = j + 9; k < temp.length(); k++) {
                                if (temp.charAt(k) == '\"') {
                                    link.add(new pair(a, temp.substring(j + 9, k)));
                                    if (!urls.contains(temp.substring(j + 9, k))) {
                                        urls.add(temp.substring(j + 9, k));
                                    }
                                    System.out.println("Link from "+a+" to "+temp.substring(j + 9, k));
                                    break;
                                }
                            }
                        }
                    }
                }
                if(temp.contains("</HTML>")){
                    break;
                }
                temp = s.nextLine();
            }
        }
        boolean[][] map = new boolean[urls.size()][urls.size()];
        for (int i = 0; i < link.size(); i++) {
            map[urls.indexOf(link.get(i).start)][urls.indexOf(link.get(i).end)] = true;
        }
        while(true){
            String temp = s.nextLine();
            if(temp.equals("The End")){
                return;
            }
            int startPos = urls.indexOf(temp);
            int endPos = urls.indexOf(s.nextLine());
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(startPos);
            boolean[] visited = new boolean[n];
            visited[startPos] = true;
            while(!queue.isEmpty()){
                int curr = queue.pop();
                for(int i = 0; i<n; i++){
                    if(map[curr][i]==true && !visited[i]){
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            if(visited[endPos]){
                System.out.println("Can surf from "+urls.get(startPos)+" to "+urls.get(endPos)+".");
            }else{
                System.out.println("Can't surf from "+urls.get(startPos)+" to " + urls.get(endPos)+".");
            }
        }
    }
}
