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
public class dmopc19c4p0 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        char[] aChar = new char[a.length()];
        char[] bChar = new char[b.length()];
        aChar = a.toCharArray();
        bChar = b.toCharArray();
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if ((int) aChar[i] != (int) bChar[i]) {
                diff++;
            }
            if (diff > 1) {
                System.out.println("LARRY IS DEAD!");
                return;
            }
        }
        if (diff == 0) {
            System.out.println("LARRY IS DEAD!");
        } else {
            System.out.println("LARRY IS SAVED!");
        }
    }
}
