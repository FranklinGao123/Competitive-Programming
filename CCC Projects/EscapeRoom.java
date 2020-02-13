/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author frank
 */
public class EscapeRoom {
    public static int R;
    public static int C;
    public static int[][] step;
    public static Stack<Integer> queuer;
    public static Stack<Integer> queuec;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());
        R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer (bf.readLine());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++){
            st = new StringTokenizer (bf.readLine());
            for (int c = 0; c<C; c++){
                map[i][c]=Integer.parseInt(st.nextToken());
            }
        }
        step = new int[R][C];
        for(int i = 0; i<step.length; i++)
            Arrays.fill(step[i], Integer.MAX_VALUE);
        step[0][0] = 0;
        queuer = new Stack<Integer>();
        queuer.add(0);
        queuec = new Stack<Integer>();
        queuec.add(0);
        while(!queuer.isEmpty()){
            int r = queuer.pop();
            int c = queuec.pop();
            int cur = map[r][c];
            find(cur,r,c);
            if(step[R-1][C-1]!= Integer.MAX_VALUE){
                System.out.println("yes");
                return;
            }
            
        }
        System.out.println("no");
        
        
        
        
    }
    public static void find(int i,int r, int q){
        for(int c = 1; c<Math.sqrt(i)+1; c++){
            if(i%c==0){
                if(c-1<R && i/c-1<C && step[c-1][i/c-1]== Integer.MAX_VALUE){
                    queuer.add(c-1);
                    queuec.add(i/c-1);
                    step[c-1][i/c-1]=step[r][q]+1;
                }
                if(i/c-1<R && c-1<C && step[i/c-1][c-1]== Integer.MAX_VALUE){
                    queuer.add(i/c-1);
                    queuec.add(c-1);
                    step[i/c-1][c-1]=step[r][q]+1;
                }
            }
        }
    }
}
