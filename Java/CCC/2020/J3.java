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
public class Art {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            String temp = s.next();
            String[] a = temp.split(",");
            minX = Math.min(minX, Integer.parseInt(a[0])-1);
            minY = Math.min(minY, Integer.parseInt(a[1])-1);
            maxX = Math.max(maxX, Integer.parseInt(a[0])+1);
            maxY = Math.max(maxY, Integer.parseInt(a[1])+1);
        }
        System.out.println(minX+","+minY);
        System.out.println(maxX+","+maxY);
        
    }
}
