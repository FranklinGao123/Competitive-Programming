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
public class dmopc19c4p1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int time = s.nextInt();
        for (int i = 0; i < time; i++) {
            String a = s.next();
            int count = 0;
            for (int c = 0; c < a.length(); c++) {
                if (a.charAt(c) == '(') {
                    count++;
                }
                if (a.charAt(c) == ')') {
                    count--;
                }
                if (count < 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if (count > 0) {
                System.out.println("NO");
            } else if (count == 0) {
                System.out.println("YES");
            }
        }
    }
}
