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
public class Vacation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[3];
        int[] b = new int[3];
        boolean first = true;
        
        for (int i = 0; i < n; i++) {
            if (first) {
                for (int c = 0; c < 3; c++) {
                    a[c]=s.nextInt();
                }
                if(n==1){
                    System.out.println(Math.max(a[0], Math.max(a[1], a[2])));
                    return;
                }
            }else{
                for (int c = 0; c < 3; c++) {
                    b[c]=s.nextInt();
                }
                b[0]=Math.max(b[0]+a[1], b[0]+a[2]);
                b[1]=Math.max(b[1]+a[0], b[1]+a[2]);
                b[2]=Math.max(b[2]+a[1], b[2]+a[0]);
                a=b.clone();
            }
            
            first = false;
        }
        System.out.println(Math.max(a[0], Math.max(a[1], a[2])));
    }
}
