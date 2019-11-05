/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
/**
 *
 * @author frank
 */
public class RoboThieves {
    public static void main(String[] args){
        //step 1: Store map into array of ArrayList (Adjacent list)
        //store map into 2D array
        //step 2: Initialize step array with Integer.MAX_VALUE;
        //step 3: Create a queue LinkedList to store the processing
        //order
        //step 4: poll value one by one from queue
        //step 5: continue looking through the neighbor, if not been visited yet update neighbor step value, also add the neighbor into queue.
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] map = new char[R][C];
        for (int r=0; r<R; r++){
            map[r] = sc.next().toCharArray();
        }
        int[][] step = new int[R][C];
        for (int r=0; r<R; r++) {
            Arrays.fill(step[r],Integer.MAX_VALUE);
        }
 
        //set step value to -1 if the position can not be reached
        int br = 0;
        int bc = 0;
        for(int r=0; r<R; r++){
            for (int c=0; c<C; c++){
                if (map[r][c] == 'C'){
                    step[r][c] = -1;
                    //go up change r value
                    for (int row=r; row>=0; row--) {
                        if (map[row][c]=='W'){
                            break;
                        } else {
                            if(map[row][c]=='.'||map[row][c]=='S'){
                                step[row][c] = -1;
                            }
                        }                  
                    }
                    //go down
                    for (int row=r; row<R; row++) {
                        if (map[row][c]=='W'){
                            break;
                        } else {
                            if(map[row][c]=='.'||map[row][c]=='S'){
                                step[row][c] = -1;
                            }
                        }                  
                    }
                    //go left
                    for (int col=c; col>=0; col--) {
                        if (map[r][col]=='W'){
                            break;
                        } else {
                            if(map[r][col]=='.'||map[r][col]=='S'){
                                step[r][col] = -1;
                            }
                        }                  
                    }
                    //go right
                    for (int col=c; col<C; col++) {
                        if (map[r][col]=='W'){
                            break;
                        } else {
                            if(map[r][col]=='.'||map[r][col]=='S'){
                                step[r][col] = -1;
                            }
                        }                  
                    }
                }
                if (map[r][c]=='W') {
                    step[r][c] = -1;
                } else if (map[r][c] == 'S') {
                    br = r;
                    bc = c;
                }
            }
        }
 
        if (step[br][bc]==-1) {
            for(int r=0; r<R; r++){
                for(int c=0;c<C; c++){
                    if(map[r][c] == '.'){
                        System.out.println(-1);
                    }
                }
            }
            return;
        }
 
        step[br][bc] = 0;
        LinkedList<Integer> rq = new LinkedList<Integer>();
        LinkedList<Integer> cq = new LinkedList<Integer>();
        rq.add(br);
        cq.add(bc);
 
        while (!rq.isEmpty()){
            int cR = rq.poll();
            int cC = cq.poll();
            //go up one step  -- row -1
            if (map[cR][cC]=='.'||map[cR][cC]=='S'||map[cR][cC]=='U') {
                if(cR-1>=0) {
                    if (map[cR-1][cC]=='U' || map[cR-1][cC]=='D' || map[cR-1][cC]=='L' || map[cR-1][cC]=='R'){
                        if (step[cR-1][cC]>step[cR][cC]){
                            step[cR-1][cC] = step[cR][cC];
                            rq.add(cR-1);
                            cq.add(cC);
                        }
                    } else if (step[cR-1][cC]>step[cR][cC]+1){
                        step[cR-1][cC] = step[cR][cC]+1;
                        rq.add(cR-1);
                        cq.add(cC);
                    }
                }
            }
 
            //go down one step   row+1
            if (map[cR][cC]=='.'||map[cR][cC]=='S'||map[cR][cC]=='D') {
                if(cR+1<R) {
                    if (map[cR+1][cC]=='U' || map[cR+1][cC]=='D' || map[cR+1][cC]=='L' || map[cR+1][cC]=='R'){
                        if (step[cR+1][cC]>step[cR][cC]){
                            step[cR+1][cC] = step[cR][cC];
                            rq.add(cR+1);
                            cq.add(cC);
                        }
                    } else if (step[cR+1][cC]>step[cR][cC]+1){
                        step[cR+1][cC] = step[cR][cC]+1;
                        rq.add(cR+1);
                        cq.add(cC);
                    }
                }
            }
            //go left one step   col-1
            if (map[cR][cC]=='.'||map[cR][cC]=='S'||map[cR][cC]=='L') {
                if(cC-1>=0) {
                    if (map[cR][cC-1]=='U' || map[cR][cC-1]=='D' || map[cR][cC-1]=='L' || map[cR][cC-1]=='R'){
                        if (step[cR][cC-1]>step[cR][cC]){
                            step[cR][cC-1] = step[cR][cC];
                            rq.add(cR);
                            cq.add(cC-1);
                        }
                    } else if (step[cR][cC-1]>step[cR][cC]+1){
                        step[cR][cC-1] = step[cR][cC]+1;
                        rq.add(cR);
                        cq.add(cC-1);
                    }
                }
            }
            //go right one step  col+1cur
            if (map[cR][cC]=='.'||map[cR][cC]=='S'||map[cR][cC]=='R') {
                if(cC+1<C) {
                    if (map[cR][cC+1]=='U' || map[cR][cC+1]=='D' || map[cR][cC+1]=='L' || map[cR][cC+1]=='R'){
                        if (step[cR][cC+1]>step[cR][cC]){
                            step[cR][cC+1] = step[cR][cC];
                            rq.add(cR);
                            cq.add(cC+1);
                        }
                    } else if (step[cR][cC+1]>step[cR][cC]+1){
                        step[cR][cC+1] = step[cR][cC]+1;
                        rq.add(cR);
                        cq.add(cC+1);
                    }
                }
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0;c<C; c++){
                if(map[r][c] == '.'){
                    if(step[r][c] == Integer.MAX_VALUE) {
                        System.out.println(-1);
                    } else {
                        System.out.println(step[r][c]);
                    }
                }
            }
        }
         
        
    }
}
