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
public class TreasureHunt {
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
        FastReader fr = new FastReader();
        for(int y = 0; y<10; y++){
        int n = fr.nextInt();
        char[][] grid = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        int startr = -1;
        int startc = -1;
        for(int i = 0; i<n; i++){
            String temp = fr.next();
            grid[i]=temp.toCharArray();
            if(temp.contains("S")){
                startr = i;
                startc = temp.indexOf("S");
            }
        }
        grid[startr][startc]='.';
        
        LinkedList<Integer> rq = new LinkedList<>();
        LinkedList<Integer> cq = new LinkedList<>();
        rq.add(startr);
        cq.add(startc);
        
        int keys = 0;
        int treasure = 0;
        
        while(!rq.isEmpty()){
            int r = rq.poll();
            int c = cq.poll();
            if(r-1>=0 && visited[r-1][c]==false && grid[r-1][c]!='#'){
                if(grid[r-1][c]=='.' || grid[r-1][c]=='T'){
                    rq.add(r-1);
                    cq.add(c);
                    if(grid[r-1][c]=='T'){
                        grid[r-1][c]='.';
                        treasure++;
                    }
                }else if(grid[r-1][c]=='K'){
                    rq.clear();
                    cq.clear();
                    rq.add(r-1);
                    cq.add(c);
                    grid[r-1][c]='.';
                    visited = new boolean[n][n];
                    keys++;
                }else{
                    if(grid[r-1][c]-'0'<=keys){
                        rq.add(r-1);
                        cq.add(c);
                        grid[r-1][c]='.';
                    }
                }
                visited[r-1][c]=true;
            }
            if(r+1<n && visited[r+1][c]==false && grid[r+1][c]!='#'){
                if(grid[r+1][c]=='.' || grid[r+1][c]=='T'){
                    rq.add(r+1);
                    cq.add(c);
                    if(grid[r+1][c]=='T'){
                        grid[r+1][c]='.';
                        treasure++;
                    }
                }else if(grid[r+1][c]=='K'){
                    rq.clear();
                    cq.clear();
                    rq.add(r+1);
                    cq.add(c);
                    grid[r+1][c]='.';
                    visited = new boolean[n][n];
                    keys++;
                }else{
                    if(grid[r+1][c]-'0'<=keys){
                        rq.add(r+1);
                        cq.add(c);
                        grid[r+1][c]='.';
                    }
                }
                visited[r+1][c]=true;
            }
            if(c-1>=0 && visited[r][c-1]==false && grid[r][c-1]!='#'){
                if(grid[r][c-1]=='.' || grid[r][c-1]=='T'){
                    rq.add(r);
                    cq.add(c-1);
                    if(grid[r][c-1]=='T'){
                        grid[r][c-1]='.';
                        treasure++;
                    }
                }else if(grid[r][c-1]=='K'){
                    rq.clear();
                    cq.clear();
                    rq.add(r);
                    cq.add(c-1);
                    grid[r][c-1]='.';
                    visited = new boolean[n][n];
                    keys++;
                }else{
                    if(grid[r][c-1]-'0'<=keys){
                        rq.add(r);
                        cq.add(c-1);
                        grid[r][c-1]='.';
                    }
                }
                visited[r][c-1]=true;
            } 
            if(c+1<n && visited[r][c+1]==false && grid[r][c+1]!='#'){
                if(grid[r][c+1]=='.' || grid[r][c+1]=='T'){
                    rq.add(r);
                    cq.add(c+1);
                    if(grid[r][c+1]=='T'){
                        grid[r][c+1]='.';
                        treasure++;
                    }
                }else if(grid[r][c+1]=='K'){
                    rq.clear();
                    cq.clear();
                    rq.add(r);
                    cq.add(c+1);
                    grid[r][c+1]='.';
                    visited = new boolean[n][n];
                    keys++;
                }else{
                    if(grid[r][c+1]-'0'<=keys){
                        rq.add(r);
                        cq.add(c+1);
                        grid[r][c+1]='.';
                    }
                }
                visited[r][c+1]=true;
            }
        }
        System.out.println(treasure);
        }
    }
}
