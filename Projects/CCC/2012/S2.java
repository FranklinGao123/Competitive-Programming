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
public class AromaticNumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String temp = s.nextLine();
        int count = 0;
        int total = 0;
        for (int i = 0; i < temp.length() / 2 - 1; i++) {
            int a = ((int) temp.charAt(count)) - 48;
            char r1 = temp.charAt(count + 1);
            int r = 0;
            switch (r1) {
                case 'I':
                    r = 1;
                    break;
                case 'V':
                    r = 5;
                    break;
                case 'X':
                    r = 10;
                    break;
                case 'L':
                    r = 50;
                    break;
                case 'C':
                    r = 100;
                    break;
                case 'D':
                    r = 500;
                    break;
                case 'M':
                    r = 1000;
                    break;
            }
            int a2 = ((int) temp.charAt(count + 2)) - 48;
            char r2 = temp.charAt(count + 3);
            int r3 = 0;
            switch (r2) {
                case 'I':
                    r3 = 1;
                    break;
                case 'V':
                    r3 = 5;
                    break;
                case 'X':
                    r3 = 10;
                    break;
                case 'L':
                    r3 = 50;
                    break;
                case 'C':
                    r3 = 100;
                    break;
                case 'D':
                    r3 = 500;
                    break;
                case 'M':
                    r3 = 1000;
                    break;
            }
            if (r3 > r) {
                r *= -1;
            }
            total += r * a;
            count += 2;
        }
        int a = ((int) temp.charAt(count)) - 48;
        char r1 = temp.charAt(count + 1);
        int r = 0;
        switch (r1) {
            case 'I':
                r = 1;
                break;
            case 'V':
                r = 5;
                break;
            case 'X':
                r = 10;
                break;
            case 'L':
                r = 50;
                break;
            case 'C':
                r = 100;
                break;
            case 'D':
                r = 500;
                break;
            case 'M':
                r = 1000;
                break;
        }
        total += r * a;
        System.out.println(total);
    }
}
