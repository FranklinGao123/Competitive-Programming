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
public class WhoIsInTheMiddle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[3];
        a[0]=s.nextInt();
        a[1]=s.nextInt();
        a[2]=s.nextInt();
        Arrays.sort(a);
        System.out.println(a[1]);
    }
}
