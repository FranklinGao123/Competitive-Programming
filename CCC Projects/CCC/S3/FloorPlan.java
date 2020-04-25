/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import  java.util.*;
import java.io.*;
/**
 *
 * @author frank
 */
public class FloorPlan {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return Integer.parseInt(st.nextToken());
    }
    
    public static String nextLine() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return st.nextToken();
    }
    
    static int[][] map;
    static int r;
    static int c;
    static LinkedList<Integer> iqueue = new LinkedList<Integer>();
    static LinkedList<Integer> jqueue = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        int flooring = nextInt();
        r = nextInt();
        c = nextInt();
        map = new int[r][c];
        ArrayList<Integer> rooms = new ArrayList<Integer>();
        for(int i = 0; i<r; i++){
            String temp = nextLine();
            for(int j = 0; j<c; j++){
                if(temp.charAt(j)=='I'){
                    map[i][j]=-1;
                }else{
                    map[i][j]=0;
                }
            }
        }

        while(find()){
            int count = 1;
            while(!iqueue.isEmpty()){
                int i = iqueue.pop();
                int j = jqueue.pop();
                if(i!=0 && map[i-1][j]!=-1){
                    map[i-1][j]=-1;
                    iqueue.add(i-1);
                    jqueue.add(j);
                    count++;
                }
                if(i!=r-1 && map[i+1][j]!=-1){
                    map[i+1][j]=-1;
                    iqueue.add(i+1);
                    jqueue.add(j);
                    count++;
                }
                if(j!=0 && map[i][j-1]!=-1){
                    map[i][j-1]=-1;
                    iqueue.add(i);
                    jqueue.add(j-1);
                    count++;
                }
                if(j!=c-1 && map[i][j+1]!=-1){
                    map[i][j+1]=-1;
                    iqueue.add(i);
                    jqueue.add(j+1);
                    count++;
                }
            }
            rooms.add(count);
        }
        Collections.sort(rooms, Collections.reverseOrder());
        int num = 0;
        for(int i = 0; i<rooms.size();i++){
            if(flooring-rooms.get(i)>=0){
                num++;
                flooring-=rooms.get(i);
            }else
                break;
        }
        if(num==1)
            System.out.println("1 room, "+flooring+" square metre(s) left over");  
        else
            System.out.println(num+" rooms, "+flooring+" square metre(s) left over");  
        
        
    }
    
    public static boolean find(){
        iqueue.clear();
        jqueue.clear();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(map[i][j]==0){
                    iqueue.add(i);
                    jqueue.add(j);
                    map[i][j]=-1;
                    return true;
                }
            }
        }
        return false;
    }

}
