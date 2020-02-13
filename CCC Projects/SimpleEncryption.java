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
public class SimpleEncryption {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String header = s.nextLine();
        String phrase = s.nextLine();
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i)+1 <= 91 && phrase.charAt(i)+1 >= 66) {
                int shift = header.charAt(count) - 65;
                if (phrase.charAt(i) + shift > 90) {
                    System.out.print((char)(phrase.charAt(i) + shift - 26));
                } else {
                    System.out.print((char)(phrase.charAt(i) + shift));
                }

                if (count == header.length()-1) {
                    count = 0;
                } else {
                    count++;
                }
            }
        }

    }
}
