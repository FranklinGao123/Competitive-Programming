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
public class Ragaman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S1 = sc.next();
        String S2 = sc.next();

        LinkedList<Character> L1 = new LinkedList<Character>();
        LinkedList<Character> L2 = new LinkedList<Character>();
        char[] A1 = S1.toCharArray();
        for (int i = 0; i < A1.length; i++) {
            L1.add(A1[i]);
        }
        char[] A2 = S2.toCharArray();
        for (int i = 0; i < A2.length; i++) {
            L2.add(A2[i]);
        }

        boolean flag = true;

        for (int i = 0; i < A1.length; i++) {
            Character c = L1.get(i);
            int index = L2.indexOf(c);
            if (index == -1) {
                index = L2.indexOf('*');
                if (index == -1) {
                    flag = false;
                    break;
                } else {
                    L2.remove(index);
                }
            } else {
                L2.remove(index);
            }
        }

        if (flag == true) {
            System.out.println("A");
        } else {
            System.out.println("N");
        }

    }
}
