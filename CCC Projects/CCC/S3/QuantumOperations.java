/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.*;
/**
 *
 * @author frank
 */
public class QuantumOperations {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int rT = 1;
        int cT = 1;
        int r = s.nextInt();
        rT*=r;
        int c = s.nextInt();
        cT*=c;
        int[][] A = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int q = 0; q<c; q++){
                A[i][q]=s.nextInt();
            }
        }
        for(int i = 0;i<n-1; i++){
            r = s.nextInt();
            rT*=r;
            c = s.nextInt();
            cT*=c;
            int[][] result = new int[rT][cT];
            int[][] B = new int[r][c];
            for(int e = 0; e<r; e++){
                for(int q = 0; q<c; q++){
                    B[e][q]=s.nextInt();
                }
                
            }
            for(int e = 0; e<rT; e++){
                for(int q = 0; q<cT; q++){
                    result[e][q]=A[e/r][q/c]*B[e%r][q%c];
                }
                
            }
            A=result.clone();
            
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int sumR = 0;
        int sumC = 0;
        for(int i = 0; i<A.length; i++){
            for(int q = 0; q<A[i].length; q++){
                max = Math.max(A[i][q],max);
                min = Math.min(A[i][q],min);
                sumR+=A[i][q];
                
            }
            maxR = Math.max(sumR,maxR);
            minR = Math.min(sumR,minR);
            
            sumR=0;
        }
        for(int i = 0; i<A[0].length; i++){
            for(int q = 0; q<A.length; q++){
                sumC+=A[q][i];
            }
            maxC = Math.max(sumC,maxC);
            minC = Math.min(sumC,minC);
            sumC=0;
            
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(maxR);
        System.out.println(minR);
        System.out.println(maxC);
        System.out.println(minC);
    }
}
