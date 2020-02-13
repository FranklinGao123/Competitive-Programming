/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
/**
 *
 * @author frank
 */
public class ChooseYourOwnPath {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int pages = s.nextInt();
        LinkedList<Integer> endpages = new LinkedList<Integer>();
        boolean[][] map = new boolean[pages+1][pages+1];
        for(int i = 1; i<pages+1; i++){
            int n = s.nextInt();
            if(n==0){
                endpages.add(i);
            }
            for(int k = 0; k<n; k++){
                int c = s.nextInt();
                map[i][c] = true;
            }
        }
        int[] step = new int[pages+1];
        Arrays.fill(step, Integer.MAX_VALUE);
        step[1]=1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int page = queue.poll();
            for(int i = 1; i< pages+1; i++){
                if(map[page][i]){
                    if(step[i]>step[page]+1){
                        step[i]=step[page]+1;
                        queue.add(i);
                    }
                }
                
            }
        }    
        boolean endpage = true;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=pages; i++){
            if(step[i]==Integer.MAX_VALUE){
                endpage = false;
            }
            if(endpages.contains(i)){
                if(step[i]<min){
                    min=step[i];
                }
            }
        }
        if(endpage){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
        System.out.println(min);
        
    }
}
