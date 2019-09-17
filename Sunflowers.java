/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class Sunflowers {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] sunflower = new int[n][n];
        for(int i = 0; i<n; i++) {
            for(int c = 0; c<n; c++){
                sunflower[i][c]=s.nextInt();
            }
        }
        if(sunflower[0][1]>sunflower[0][0]&&sunflower[1][0]>sunflower[0][0]){
            for(int i = 0; i<n; i++) {
                for(int c = 0; c<n; c++){
                    System.out.print(sunflower[i][c]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }else if(sunflower[n-1][1]>sunflower[n-1][0]&&sunflower[n-2][0]>sunflower[n-1][0]){
            for(int i = 0; i<n; i++) {
                for(int c = n-1; c>=0; c--){
                    System.out.print(sunflower[c][i]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }else if(sunflower[n-2][n-1]>sunflower[n-1][n-1]&&sunflower[n-1][n-2]>sunflower[n-1][n-1]){
            for(int i = n-1; i>=0; i--) {
                for(int c = n-1; c>=0; c--){
                    System.out.print(sunflower[i][c]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }else{
            for(int i = n-1; i>=0; i--) {
                for(int c = 0; c<n; c++){
                    System.out.print(sunflower[c][i]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        
    }
}
