/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author frank
 */
public class KnightHop {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] step = new int[8][8];
        int bvR = s.nextInt()-1;
        int bvC = s.nextInt()-1;
        for(int i = 0; i < 8; i++){
            Arrays.fill(step[i], Integer.MAX_VALUE);
        }
        step[bvR][bvC] = 0;
        
        int evR = s.nextInt();
        int evC = s.nextInt();
        
        LinkedList<Integer> queueR = new LinkedList<Integer>();
        LinkedList<Integer> queueC = new LinkedList<Integer>();
        queueR.add(bvR);
        queueC.add(bvC);
        
        while(!queueR.isEmpty()){
            int curR = queueR.poll();
            int curC = queueC.poll();
            if(curR <= 5 && curC <= 6){
                if(step[curR+2][curC+1]>step[curR][curC]+1){ //1
                    queueR.add(curR+2);
                    queueC.add(curC+1);
                    step[curR+2][curC+1]=step[curR][curC]+1;
                }
            }
            if(curR <= 5 && curC >= 1){
                if(step[curR+2][curC-1]>step[curR][curC]+1){//8
                    queueR.add(curR+2);
                    queueC.add(curC-1);
                    step[curR+2][curC-1]=step[curR][curC]+1;
                }
            }
            if(curR <= 6 && curC <= 5){
                if(step[curR+1][curC+2]>step[curR][curC]+1){//2
                    queueR.add(curR+1);
                    queueC.add(curC+2);
                    step[curR+1][curC+2]=step[curR][curC]+1;
                }
            }
            if(curR <= 6 && curC >= 2){
                if(step[curR+1][curC-2]>step[curR][curC]+1){//7
                    queueR.add(curR+1);
                    queueC.add(curC-2);
                    step[curR+1][curC-2]=step[curR][curC]+1;
                }
            }
            if(curR >=1 && curC <= 5){
                if(step[curR-1][curC+2]>step[curR][curC]+1){//3
                    queueR.add(curR-1);
                    queueC.add(curC+2);
                    step[curR-1][curC+2]=step[curR][curC]+1;
                }
            }
            if(curR >=1 && curC >= 2){
                if(step[curR-1][curC-2]>step[curR][curC]+1){//6
                    queueR.add(curR-1);
                    queueC.add(curC-2);
                    step[curR-1][curC-2]=step[curR][curC]+1;
                }
            }
            if(curR >=2 && curC >= 1){
                if(step[curR-2][curC-1]>step[curR][curC]+1){//5
                    queueR.add(curR-2);
                    queueC.add(curC-1);
                    step[curR-2][curC-1]=step[curR][curC]+1;
                }
            }
            if(curR >=2 && curC <= 6){
                if(step[curR-2][curC+1]>step[curR][curC]+1){//4
                    queueR.add(curR-2);
                    queueC.add(curC+1);
                    step[curR-2][curC+1]=step[curR][curC]+1;
                }
            }
        }
        
        System.out.println(step[evR-1][evC-1]);
        
    }
}
